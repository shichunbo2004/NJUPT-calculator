package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login.db.UserDao;


public class LoginActivity extends AppCompatActivity {
    private static final int RESULT_OK = 1;
    public static final String ACCOUNT = "account";
    public static final String PASSWORD = "password";
    private TextView btnLogin;
    private EditText etAccount;
    private EditText etPassword;
    private TextView tvRegister;
    private UserDao userDao;

    private RadioGroup radiogroup;
    private RadioButton radio_one;
    private RadioButton radio_two;
//    private RadioButton radio_three;
//    private RadioButton radio_four;

    String str; //存放点击的按钮的值
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    public void initView() {
        // 去除默认标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();

        // 绑定控件
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);

        radiogroup = (RadioGroup) findViewById(R.id.id_radiogroup);
        radio_one = (RadioButton) findViewById(R.id.radio_1);
        radio_two = (RadioButton) findViewById(R.id.radio_2);
//        radio_three = (RadioButton) findViewById(R.id.radio_3);
//        radio_four = (RadioButton) findViewById(R.id.radio_4);

        radio_one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        // 匿名内部类方式实现按钮点击事件
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String acc = etAccount.getText().toString().trim();
                String pass = etPassword.getText().toString().trim();
                userDao = new UserDao(getApplicationContext());
                userDao.open();
                if (!userDao.isExist(acc)) {
                    Toast.makeText(LoginActivity.this,"账号不存在，请重新输入！", Toast.LENGTH_SHORT).show();
                } else {
                    if (userDao.getPassword(acc).equals(pass)) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra(ACCOUNT, acc);
                        intent.putExtra(PASSWORD, pass);
                        // 创建意图对象，进行跳转
                        startActivity(intent);
                        // 销毁该活动
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "密码错误，请重新输入！", Toast.LENGTH_SHORT).show();
                    }
                }
                // 关闭DB访问对象
                userDao.close();
            }
        });
            }
        });


        radio_two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 匿名内部类方式实现按钮点击事件
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String acc = etAccount.getText().toString().trim();
                        String pass = etPassword.getText().toString().trim();
                        userDao = new UserDao(getApplicationContext());
                        userDao.open();
                        if (!userDao.isExist(acc)) {
                            Toast.makeText(LoginActivity.this,"账号不存在，请重新输入！", Toast.LENGTH_SHORT).show();
                        } else {
                            if (userDao.getPassword(acc).equals(pass)) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra(ACCOUNT, acc);
                                intent.putExtra(PASSWORD, pass);
                                // 创建意图对象，进行跳转
                                startActivity(intent);
                                // 销毁该活动
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "密码错误，请重新输入！", Toast.LENGTH_SHORT).show();
                            }
                        }
                        // 关闭DB访问对象
                        userDao.close();
                    }
                });

            }
        });


//        radio_three.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // 匿名内部类方式实现按钮点击事件
//                btnLogin.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String acc = etAccount.getText().toString().trim();
//                        String pass = etPassword.getText().toString().trim();
//                        userDao = new UserDao(getApplicationContext());
//                        userDao.open();
//                        if (!userDao.isExist(acc)) {
//                            Toast.makeText(LoginActivity.this,"账号不存在，请重新输入！", Toast.LENGTH_SHORT).show();
//                        } else {
//                            if (userDao.getPassword(acc).equals(pass)) {
//                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                intent.putExtra(ACCOUNT, acc);
//                                // 创建意图对象，进行跳转
//                                startActivity(intent);
//                                // 销毁该活动
//                                finish();
//                            } else {
//                                Toast.makeText(LoginActivity.this, "密码错误，请重新输入！", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                        // 关闭DB访问对象
//                        userDao.close();
//                    }
//                });
//
//            }
//        });
//
//        radio_four.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // 匿名内部类方式实现按钮点击事件
//                btnLogin.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String acc = etAccount.getText().toString().trim();
//                        String pass = etPassword.getText().toString().trim();
//                        userDao = new UserDao(getApplicationContext());
//                        userDao.open();
//                        if (!userDao.isExist(acc)) {
//                            Toast.makeText(LoginActivity.this,"账号不存在，请重新输入！", Toast.LENGTH_SHORT).show();
//                        } else {
//                            if (userDao.getPassword(acc).equals(pass)) {
//                                Intent intent = new Intent(LoginActivity.this,LoginActivity.class);
//                                intent.putExtra(ACCOUNT, acc);
//                                // 创建意图对象，进行跳转
//                                startActivity(intent);
//                                // 销毁该活动
//                                finish();
//                            } else {
//                                Toast.makeText(LoginActivity.this, "密码错误，请重新输入！", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                        // 关闭DB访问对象
//                        userDao.close();
//                    }
//                });
//
//            }
//        });




        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String acc = data.getStringExtra("acc");
                    String pass = data.getStringExtra("pass");
                    etAccount.setText(acc);
                    etPassword.setText(pass);
                }
                break;
            default:
                break;
        }
    }
}
