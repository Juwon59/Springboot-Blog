package com.example.myblogproject.repository;

import com.example.myblogproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//DAO
//자동으로 bean 등록이 된다.
// @Repository //생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {
}
