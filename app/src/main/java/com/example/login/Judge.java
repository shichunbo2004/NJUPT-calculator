package com.example.login;

public class Judge {
    public String judge(String string, String c) {
        switch (string.charAt(string.length() - 1)) {
            case '+':
            case '-':
            case '×':
            case '÷':
                string = string.substring(0, string.length() - 1) + c;
                break;
            default:
                string += c;
                break;
        }
        return string;
    }

    public static String dispose(String string) {
        int leng = string.length() - 1;
        Character character;
        if (0 == leng) {
            return "error";
        }
        for (int i = 0; i < leng; i++) {
            character = string.charAt(i);
            if (Character.isLetter(character)) {
                return "error";
            }

        }

        return string;
    }

    public String judge1(String string) {
        int p = string.length() - 1;
        boolean flag = true;
        Character tmp = string.charAt(p);

        if (0 == p)
            string += ".";

        if (Character.isDigit(tmp) && 0 != p) {
            while (flag) {
                if (!Character.isDigit(tmp)) {
                    flag = false;
                    if (tmp != '.')
                        string += ".";
                }

                if (0 == --p && (tmp != '.')) {
                    string += ".";
                    break;
                }

                tmp = string.charAt(p);
            }

        }
        return string;
    }

    public static boolean paiduan(Character c) {
        switch (c) {
            case '+':
            case '-':
            case '×':
            case '÷':
                return true;
            default:
                return false;
        }
    }

    public String digit_judge(String string, String c, boolean flag) {
        if ("0".equals(string)) {
            string = c;
        } else if (flag) {
            string = c;
        } else
            string += c;
        return string;
    }

    public String digit_dispose(String string) {
        if ("error".equals(string)) {
            return string;
        }

        Double double1 = new Double(string);

        if(double1>999999999999999.0)
            return "∞";

        long l = (long) (double1 * 1e4);
        double1 = (Double) (l / 1e4);

        string = "" + double1;
        return string;
    }
}













