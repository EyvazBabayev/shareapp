package com.shareapp.dao;

import com.shareapp.model.User;

public interface UserDao {
    void register(User user);
    User getUser(String username,String password);
}
