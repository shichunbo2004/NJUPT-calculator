package com.example.login;

// FinancialCalculator.java
public class FinancialCalculator {

    // 计算复利的未来值
    public static double calculateFutureValue(double principal, double rate, int years) {
        return principal * Math.pow(1 + rate, years);
    }

    // 计算现值
    public static double calculatePresentValue(double futureValue, double rate, int years) {
        return futureValue / Math.pow(1 + rate, years);
    }

    // 计算复利的年金未来值
    public static double calculateAnnuityFutureValue(double payment, double rate, int years) {
        return payment * (((Math.pow(1 + rate, years) - 1) / rate));
    }

    // 计算复利的年金现值
    public static double calculateAnnuityPresentValue(double payment, double rate, int years) {
        return payment * (((1 - Math.pow(1 + rate, -years)) / rate));
    }
}