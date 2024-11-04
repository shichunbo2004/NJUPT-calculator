package com.example.login;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ratectivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        // 绑定输入框和输出框
        final EditText editTextAnnualRate = findViewById(R.id.editTextAnnualRate);
        TextView textViewMonthlyRate = findViewById(R.id.textViewMonthlyRate);
        TextView textViewDailyRate = findViewById(R.id.textViewDailyRate);

        // 计算按钮点击事件
        findViewById(R.id.buttonCalculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取用户输入的年利率
                double annualRate = Double.parseDouble(editTextAnnualRate.getText().toString());

                // 计算月利率和日利率
                double monthlyRate = annualRate / 12 / 100;
                double dailyRate = monthlyRate / 30;

                // 显示计算结果
                textViewMonthlyRate.setText(String.format("%.4f", monthlyRate));
                textViewDailyRate.setText(String.format("%.4f", dailyRate));
            }
        });
    }
}