package com.zer0ne.practice.model;

import com.zer0ne.practice.model.bean.User;
import com.zer0ne.practice.model.impl.IUserModel;
import com.zer0ne.practice.model.impl.OnLoginListener;

public class UserModel implements IUserModel {

    @Override
    public void login(final String username,final String password,final OnLoginListener onLoginListener) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (username.equals("zer0ne") && password.equals("01")) {
                    User user=new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    onLoginListener.onSuccess(user);
                }else{
                    onLoginListener.onFailed();
                }
            }
        }.start();
    }
}
