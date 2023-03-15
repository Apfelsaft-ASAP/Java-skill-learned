package com.sparta.springsecurity.repository;


import com.sparta.springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { //JPA와 연결이 되어 username을 사용해서 user를 찾을수 있다.
    Optional<User> findByUsername(String username);

}