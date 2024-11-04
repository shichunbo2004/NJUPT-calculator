package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class RegisterActivity extends AppCompatActivity {
    private static final int RESULT_OK = 1;

    private TextView btnRegister;
    private TextView btnCancel;
    private EditText etAccount;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    public void initView() {
        // 去除默认标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();

        // 绑定控件
        etAccount =findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        btnRegister = findViewById(R.id.btn_register);
        btnCancel = findViewById(R.id.btn_cancel);

        // 设置点击事件
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String acc = etAccount.getText().toString().trim();
                String pass = etPassword.getText().toString().trim();
                String confirm = etConfirmPassword.getText().toString().trim();
                Yonghu user = new Yonghu(acc, pass);
                userDao = new UserDao(getApplicationContext());
                userDao.open();
                if (userDao.findUser(user)) {
                    Toast.makeText(RegisterActivity.this, "账号已存在", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pass) || TextUtils.isEmpty(confirm)) {
                    Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else if(!pass.equals(confirm)) {
                    Toast.makeText(RegisterActivity.this, "两次输入的密码不同", Toast.LENGTH_SHORT).show();
                } else {
                    userDao.addUser(user);
                    Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    //将账号和密码传递过去
                    intent.putExtra("acc", acc);
                    intent.putExtra("pass", pass);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                userDao.close();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}