package com.zer0ne.practice.model.impl;

import com.zer0ne.practice.model.bean.User;

public interface OnLoginListener {
    void onSuccess(User user);
    void onFailed();
}
