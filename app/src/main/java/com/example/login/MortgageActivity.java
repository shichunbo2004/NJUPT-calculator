package com.example.login;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MortgageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage);

        final EditText loanAmountEditText = findViewById(R.id.loanAmount);
        final EditText interestRateEditText = findViewById(R.id.interestRate);
        final TextView resultText = findViewById(R.id.resultText);

        findViewById(R.id.calculateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double loanAmount = Double.parseDouble(loanAmountEditText.getText().toString());
                double interestRate = Double.parseDouble(interestRateEditText.getText().toString()) / 100;
                int loanTerm = Integer.parseInt(loanAmountEditText.getText().toString()) * 12; // 假设每月还款

                double monthlyPayment = calculateMonthlyPayment(loanAmount, interestRate, loanTerm);
                resultText.setText(String.format("每月还款额: %.2f", monthlyPayment));
            }
        });
    }

    private double calculateMonthlyPayment(double loanAmount, double interestRate, int loanTerm) {
        double monthlyInterestRate = interestRate / 12;
        double monthlyPayment = loanAmount * (monthlyInterestRate / (1 - Math.pow(1 / (1 + monthlyInterestRate), loanTerm)));
        return monthlyPayment;
    }
}