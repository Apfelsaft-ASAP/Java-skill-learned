package com.sparta.springsecurity.config;


import com.sparta.springsecurity.security.CustomAccessDeniedHandler;
import com.sparta.springsecurity.security.CustomAuthenticationEntryPoint;
import com.sparta.springsecurity.security.CustomSecurityFilter;
import com.sparta.springsecurity.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
@EnableGlobalMethodSecurity(securedEnabled = true) //@Secured 어노테이션 활성화
public class WebSecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean // 비밀번호 암호화 기능 등록
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // h2-console 사용 및 resources 접근 허용 설정
        return (web) -> web.ignoring()                                                      //ignoring() 메서드는 Spring Security의 'WebSecurity' 클래스에 있는 메서드로서,
                .requestMatchers(PathRequest.toH2Console())                                 //요청에 대해 Spring Security 필터 체인을 건너 뛰도록 구성하는데 사용된다.
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());      // 이를 통해 정적 리소스, 로그 파일 등의 경로를 지정하여 해당 경로에 대한 요청에 대해
    }                                                                                       // Spring Security의 인증 및 권한 검사를 우회할 수 있다.

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // CSRF 설정
        http.csrf().disable();

        http.authorizeRequests().antMatchers("/api/user/**").permitAll()  //permitAll()을 하면 해당 URL은 인증하지 않고 들어올수 있다.
//                .antMatchers("/h2-console/**").permitAll()                                //위에서 ignoring() 메서드를 사용하여 인증 처리를 무시하기로 선행되었기 때문에
//                .antMatchers("/css/**").permitAll()                                       //여기에서 permitAll()을 따로 할 필요 없다.
//                .antMatchers("/js/**").permitAll()                                        //.antMatchers(이후에 HttpMethod. 사용하여 방식을 지정할수 있으며, 뒤에 permitAll()이외에도
//                .antMatchers("/images/**").permitAll()                                    //permitAll() : 전부 허가, authenticated : 인증, anonymous : 익명의 사용자, hasAnyRole : 어떠한 권한을 가진 user만  등등.
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .anyRequest().authenticated();                                              //-> 위에 예외처리 이외의 요청들은 Authentication 인증 처리를 하겠다. 라는 설정

        // Custom 로그인 페이지 사용
        http.formLogin().loginPage("/api/user/login-page").permitAll();      //http.formLogin()// Security에서 제공하는 디폴트 Form Login을 사용하겠다는 표시라고 이해하면 됨.

        //Custom Filter 등록하기
        http.addFilterBefore(new CustomSecurityFilter(userDetailsService, passwordEncoder()), UsernamePasswordAuthenticationFilter.class);

        //접근제한페이지 이동 설정
//        http.exceptionHandling().accessDeniedPage("/api/user/forbidden");

        //401 Error 처리, Authorization 즉, 인증과정에서 실패할 시 처리
        http.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint);

        //403 Error 처리, 인증과는 별개로 추가적인 권한이 충족되지 않는 경우
        http.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);


        return http.build();
    }

}
