package com.example.demo.dao;

import com.example.demo.entity.Password;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PasswordDao {
    void insert(Password password);
    List<Password> find(Password password);
    void update(Password password);
}
