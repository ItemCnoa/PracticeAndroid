package com.zer0ne.practice.view;

import com.zer0ne.practice.model.bean.User;

public interface LoginView {
    String getUsername();
    String getPassword();
    void clear();
    void showLoading();
    void hideLoading();
    void loginSuccess(User user);
    void loginFailed();
}
