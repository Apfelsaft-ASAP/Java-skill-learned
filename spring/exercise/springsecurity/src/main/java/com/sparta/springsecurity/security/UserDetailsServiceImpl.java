package com.sparta.springsecurity.security;

import com.sparta.springsecurity.entity.User;
import com.sparta.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service                    //@Service 어노테이션을 추가하여 Bean으로 등록함.
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;    //userrepository와 연결을 함.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("UserDetailsServiceImpl.loadUserByUsername : " + username);

        User user = userRepository.findByUsername(username)                     //DB에서 사용자를 조회함.
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        return new UserDetailsImpl(user, user.getUsername(), user.getPassword());
    }       //반환값은 UserDetailsImpl 생성자의 user와 username, password가 들어가기 때문에
            //DB에서 조회 해온 user, username, password를 반환한다.
}

//UserDetailsServiceImpl은 user를 DB에서 조회하고 인증한 후 UserDetails를 반환하고 UserDetails를 사용하여 인증 객체를 만든다.