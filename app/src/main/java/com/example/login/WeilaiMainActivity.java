package com.example.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WeilaiMainActivity extends AppCompatActivity {

    private EditText principalEditText;
    private EditText rateEditText;
    private EditText yearsEditText;
    private TextView resultTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weilai);

        principalEditText = findViewById(R.id.principalEditText);
        rateEditText = findViewById(R.id.rateEditText);
        yearsEditText = findViewById(R.id.yearsEditText);
        resultTextView = findViewById(R.id.resultTextView);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double principal = Double.parseDouble(principalEditText.getText().toString());
                double rate = Double.parseDouble(rateEditText.getText().toString());
                int years = Integer.parseInt(yearsEditText.getText().toString());

                double futureValue = FinancialCalculator.calculateFutureValue(principal, rate, years);
                resultTextView.setText(String.format("Future Value: %.2f", futureValue));
            }
        });
    }
}