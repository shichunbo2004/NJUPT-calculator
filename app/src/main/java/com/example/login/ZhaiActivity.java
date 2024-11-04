package com.example.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ZhaiActivity extends AppCompatActivity {

    private EditText principalEditText;
    private EditText annualInterestRateEditText;
    private EditText loanTermInYearsEditText;
    private TextView monthlyPaymentTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zai);

        principalEditText = findViewById(R.id.principalEditText);
        annualInterestRateEditText = findViewById(R.id.annualInterestRateEditText);
        loanTermInYearsEditText = findViewById(R.id.loanTermInYearsEditText);
        monthlyPaymentTextView = findViewById(R.id.monthlyPaymentTextView);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double principal = Double.parseDouble(principalEditText.getText().toString());
                double annualInterestRate = Double.parseDouble(annualInterestRateEditText.getText().toString());
                int loanTermInYears = Integer.parseInt(loanTermInYearsEditText.getText().toString());

                double monthlyPayment = DebtCalculator.calculateMonthlyPayment(principal, annualInterestRate, loanTermInYears);
                monthlyPaymentTextView.setText(String.format("每月还款额: %.2f", monthlyPayment));
            }
        });
    }
}