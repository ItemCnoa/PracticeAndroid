package com.zer0ne.practice.presenter;

import android.os.Handler;

import com.zer0ne.practice.model.UserModel;
import com.zer0ne.practice.model.bean.User;
import com.zer0ne.practice.model.impl.IUserModel;
import com.zer0ne.practice.model.impl.OnLoginListener;
import com.zer0ne.practice.view.LoginView;

public class LoginPresenter {
    private LoginView loginView;
    private IUserModel userModel;
    private Handler handler;

    public LoginPresenter(LoginView loginView){
        this.loginView=loginView;
        userModel=new UserModel();
        handler=new Handler();
    }

    public void login(){
        loginView.showLoading();
        userModel.login(loginView.getUsername(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void onSuccess(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.loginSuccess(user);
                        loginView.hideLoading();
                    }
                });

            }

            @Override
            public void onFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.loginFailed();
                        loginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear(){
        loginView.clear();
    }
}
