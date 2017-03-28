package com.zer0ne.practice.view.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zer0ne.practice.R;
import com.zer0ne.practice.model.bean.User;
import com.zer0ne.practice.presenter.LoginPresenter;
import com.zer0ne.practice.view.LoginView;

public class Login extends AppCompatActivity implements LoginView {
    private EditText etUsername,etPassword;
    private ProgressBar pbLoading;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername= (EditText) findViewById(R.id.etUsername);
        etPassword= (EditText) findViewById(R.id.etPassword);
        pbLoading= (ProgressBar) findViewById(R.id.pbLoading);

        loginPresenter=new LoginPresenter(this);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login();
            }
        });

        findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.clear();
            }
        });

    }

    @Override
    public String getUsername() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void clear() {
        etUsername.setText("");
        etPassword.setText("");
    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void loginSuccess(User user) {
        Toast.makeText(Login.this, user.getUsername() + " login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(Login.this, "login failed", Toast.LENGTH_SHORT).show();
    }
}
