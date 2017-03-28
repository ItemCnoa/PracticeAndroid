package com.zer0ne.practice.model.impl;

public interface IUserModel {
    void login(String username,String password,OnLoginListener onLoginListener);
}
