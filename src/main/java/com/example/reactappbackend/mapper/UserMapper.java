package com.example.reactappbackend.mapper;

import com.example.reactappbackend.model.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    void registerUser(User user);

    User findByEmail(String email);

    void updateToken(User user);
}
