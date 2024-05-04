package com.BookMyShow.demo.Repositeries;

import com.BookMyShow.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    //JPA respository


    @Override
    Optional<User> findById(Long userId);
    //find the user by the given userid;


    @Override
    List<User> findAllById(Iterable<Long> longs);
    //select * from users where user_id IN (1,2,3,4,5);
}
