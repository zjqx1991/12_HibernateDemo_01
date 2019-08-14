package com.revanwang.hibernate.dao;

import com.revanwang.hibernate.domain.User;

import java.util.List;

public interface IUserDAO {

    void save(User user);

    void update(User user);

    void delete(User user);

    User get(Long id);

    List<User> getList();

}
