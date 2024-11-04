package com.example.login;

// DebtCalculator.java
public class DebtCalculator {

    // 计算每月还款额（等额本息还款法）
    public static double calculateMonthlyPayment(double principal, double annualInterestRate, int loanTermInYears) {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        double monthlyPayment = (principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -loanTermInYears * 12));
        return monthlyPayment;
    }
}