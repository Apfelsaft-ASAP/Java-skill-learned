package com.sparta.springsecurity.security;


import com.sparta.springsecurity.entity.User;
import com.sparta.springsecurity.entity.UserRoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {   //user도 담고 username과 password를 생성자로 초기화 할수 있다.
                                                        //UserDetailsServiceImpl에서 검증해서 가져온 객체
    private final User user;
    private final String username;
    private final String password;

    public UserDetailsImpl(User user, String username, String password) {
        this.user = user;
        this.username = username;
        this.password = password;
    }

    public User getUser() {     //user를 가져오는 getUser()
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        UserRoleEnum role = user.getRole();                                                     //user의 권한을 가지고와서
        String authority = role.getAuthority();                                                 //이걸 스트링 값으로 만든다.

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);  //추상화 하여 사용한다.
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        return authorities;                                                                     //권한을 가지고 오는 부분
    }

    @Override
    public String getUsername() {       //user의 이름과 password를 가져올수 있다.
        return this.username;           //기본적으로 return 값이 null이고 아래 처럼 false값으로 디폴트값이 지정되어있다.
    }                                   //username과 password를 사용해야하기 때문에 지정됨.

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}