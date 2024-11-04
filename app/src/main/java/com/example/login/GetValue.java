package com.example.login;

import java.util.LinkedList;
import java.util.List;

public class GetValue {

    public String bracke_dispose(String string) {
        // 处理括号里的表达式，思路，
        // 1.遇到正括号就将它在字符串里的索引保存在一个链表里<插在链表头>
        // 2.遇到第一个反括号就处理这个括号里的表达式<取出链表第一个元素，然后根据这两个索引取出表达式，会调用一个专门处理
        // log,ln,sin,cos,tan等的special_dispose函数，将反回一个自由加减乘除的表达式，在调用alg_dispose函数>
        // 3.函数处理后返回一个可能还含有log,ln,sin,cos,tan等的但没有括号的表达式；

        int flag = 0, flag1 = 0, i = 0;
        int leng = string.length();
        List<Integer> list = new LinkedList<Integer>();
        Character c;
        String str = "", tmp = "", tmp3 = "", tmp4 = "";

        while (true) {
            if (i >= leng)
                break;

            c = string.charAt(i);

            if ('(' == c)
                list.add(0, i);

            if (')' == c) {
                if (0 == list.size()) {
                    System.out.println(")error");
                    return "error";
                }

                str = string.substring(list.get(0) + 1, i);
                tmp = this.special_dispose(str);
                tmp = this.alg_dispose(str);
                if ("error".equals(tmp))
                    return "error";

                tmp3 = string.substring(0, list.get(0));
                tmp4 = string.substring(i + 1, leng);
                string = tmp3 + tmp + tmp4;

                flag = str.length() + 2;
                flag1 = tmp.length();
                leng += (flag1 - flag);
                i += (flag1 - flag);
                list.remove(0);
            }
            i++;
        }

        if (list.size() != 0) {
            System.out.println("(error");
            return "error";
        }
        return string;
    }

    public String special_dispose(String string) {
        // 用于处理特殊表达式；

        if ("error".equals(string)) {
            return "error";
        }
        string = dispose(string, "sin");
        string = dispose(string, "cos");
        string = dispose(string, "tan");
        string = dispose(string, "log");
        string = dispose(string, "ln");
        string = dispose(string, "!");
        string = dispose(string, "^");
        string = dispose(string, "√");
        string = dispose(string, "e");
        return string;
    }

    public String alg_dispose(String string) {
        // 处理加减乘除
        string = special_dispose(string);

        if ("error".equals(string)) {
            return "error";
        }

        Character c;
        String str = "";
        List<Double> list = new LinkedList<Double>();
        double tmp = 0;
        boolean add_flag = false;

        for (int i = 0; i < string.length(); i++) {
            c = string.charAt(i);
            if (!Judge.paiduan(c)) {
                str += c;
            } else {
                if (str.length() != 0)
                    list.add(new Double(str));

                str = "";
                switch (c) {
                    case '+':
                        if (2 == list.size()) {
                            if (add_flag) {
                                tmp = list.get(0) + list.get(1);
                                list.clear();
                                list.add(tmp);
                            } else {
                                tmp = list.get(0) - list.get(1);
                                list.clear();
                                list.add(tmp);
                            }
                            break;
                        }
                        add_flag = true;
                        break;
                    case '-':
                        if (2 == list.size()) {
                            if (add_flag) {
                                tmp = list.get(0) + list.get(1);
                                list.clear();
                                list.add(tmp);
                            } else {
                                tmp = list.get(0) - list.get(1);
                                list.clear();
                                list.add(tmp);
                            }
                            add_flag = false;
                            break;
                        }
                        break;
                    case '×':
                        if (i == (string.length() - 1))
                            return "error";
                        while (!(i == (string.length() - 1))
                                && !Judge.paiduan((c = string.charAt(i + 1)))) {
                            str += c;
                            i++;
                        }

                        if (str.length() != 0)
                            list.add(new Double(str));
                        str = "";

                        if (list.size() == 2) {
                            tmp = list.get(0) * list.get(1);
                            list.clear();
                            list.add(0, tmp);
                        } else {
                            tmp = list.get(2) * list.get(1);
                            list.remove(2);
                            list.remove(1);
                            list.add(tmp);
                        }
                        break;
                    case '÷':
                        if (i == (string.length() - 1))
                            return "error";
                        while (!(i == (string.length() - 1))
                                && !Judge.paiduan((c = string.charAt(i + 1)))) {
                            str += c;
                            i++;
                        }

                        if (str.length() != 0)
                            list.add(new Double(str));
                        str = "";

                        if (list.size() == 2) {
                            tmp = list.get(0) / list.get(1);
                            list.clear();
                            list.add(0, tmp);
                        } else {
                            tmp = list.get(2) / list.get(1);
                            list.remove(2);
                            list.remove(1);
                            list.add(tmp);
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        if (str.length() != 0)
            list.add(new Double(str));

        if (2 == list.size()) {
            if (add_flag) {
                tmp = list.get(0) + list.get(1);
                list.clear();
                list.add(tmp);
            } else {
                tmp = list.get(0) - list.get(1);
                list.clear();
                list.add(tmp);
            }
        }
        if (list.size() != 0)
            string = "" + list.get(0);

        return string;
    }

    public String get_r_digit(String string, int index) {
        // 得到index右边的第一个数；
        String tmp = "";
        int length = string.length(), j = index;
        Character character;

        if (index >= length)
            tmp = "error";

        while (true) {
            if (j == length)
                break;

            character = string.charAt(j);
            if (Character.isDigit(character) || (character == '.')) {
                tmp += character;
            } else
                break;
            j++;
        }

        if (0 == tmp.length())
            tmp = "error";
        System.out.println(tmp);
        return tmp;
    }

    public String get_l_digit(String string, int index) {
        // 得到index左边的第一个数；
        String tmp = "";
        int j = index;
        Character c;

        if (index < 0)
            tmp = "error";

        while (true) {
            if (j < 0)
                break;

            c = string.charAt(j);
            if (Character.isDigit(c) || (c == '.')) {
                tmp = "" + c + tmp;
            } else
                break;
            j--;
        }

        if (0 == tmp.length())
            tmp = "error";

        return tmp;
    }

    public String dispose1(String string) {
        // 将π替换为对应的数字；
        int index, leng = string.length();
        double tmp = Math.PI;
        while (leng != 0) {

            index = string.indexOf("π");

            if (-1 == index)
                break;

            if ((index != 0 && (index + 1) != leng)
                    && Character.isDigit(string.charAt(index + 1))
                    && Character.isDigit(string.charAt(index - 1))) {
                string = string.replaceFirst("π", "×" + tmp + "×");
            } else if (index != 0
                    && Character.isDigit(string.charAt(index - 1))) {
                string = string.replaceFirst("π", "×" + tmp);
            } else if (index != 0
                    && Character.isDigit(string.charAt(index + 1))) {
                string = string.replaceFirst("π", "" + tmp + "×");
            } else {
                string = string.replaceFirst("π", "" + tmp);
            }

        }
        return string;
    }

    public String dispose(String string, String dispose) {
        // 处理指定运算符；<log,ln,sin,cos,tan....>
        int index, flag = dispose.length(), flag1, flag2;
        String tmpString = "", tmpString1 = "", tmpString2 = "";
        Double tmp, tmp1;
        while (string.length() != 0) {
            index = string.indexOf(dispose);

            if (-1 == index)
                break;

            if ("!".equals(dispose)) {
                tmpString = get_l_digit(string, index - flag);
                if (!"error".equals(tmpString) && !"error".equals(tmpString1)) {
                    tmp = new Double(tmpString);
                } else {
                    return "error";
                }

                tmp1 = 1.0;
                for (int i = 1; i <= tmp; i++) {
                    tmp1 *= i;
                }

                tmpString2 = "" + tmp1;
                string = string.replaceFirst(tmpString + dispose, tmpString2);

            } else if ("e".equals(dispose)) {
                tmpString = get_r_digit(string, index + flag);
                tmpString1 = get_l_digit(string, index - flag);

                if (!"error".equals(tmpString) && !"error".equals(tmpString1)) {
                    tmp = new Double(tmpString);
                    tmp1 = new Double(tmpString1);
                } else {
                    return "error";
                }

                tmp = Math.pow(10, tmp);
                tmp1 *= tmp;

                tmpString2 = "" + tmp1;
                string = string.replaceFirst(tmpString1 + dispose + tmpString,
                        tmpString2);
                System.out.println(string);

            } else if ("^".equals(dispose)) {
                tmpString = get_r_digit(string, index + flag);
                tmpString1 = get_l_digit(string, index - flag);

                flag1 = tmpString.length();
                flag2 = tmpString1.length();

                if (!"error".equals(tmpString) && !"error".equals(tmpString1)) {
                    tmp = new Double(tmpString);
                    tmp1 = new Double(tmpString1);
                } else {
                    return "error";
                }

                tmp = Math.pow(tmp1, tmp);
                tmpString2 = "" + tmp;
                flag1 = index + flag1 + 1;
                flag2 = index - flag2;

                if (0 == flag2) {
                    tmpString = "";
                } else {
                    tmpString = string.substring(0, flag2);
                }
                if (string.length() == flag1) {
                    tmpString1 = "";
                } else {
                    tmpString1 = string.substring(flag1, string.length());
                }

                string = tmpString + tmpString2 + tmpString1;

            } else {
                tmpString = get_r_digit(string, index + flag);
                flag1 = tmpString.length();
                if (!"error".equals(tmpString))
                    tmp = new Double(tmpString);
                else {
                    return "error";
                }
                tmpString2 = tmpString;

                if ("sin".equals(dispose)) {
                    if ("error".equals(tmp))
                        return "error";
                    tmp = Math.sin(tmp);
                } else if ("cos".equals(dispose)) {
                    if ("error".equals(tmp))
                        return "error";
                    tmp = Math.cos(tmp);
                } else if ("tan".equals(dispose)) {
                    if ("error".equals(tmp))
                        return "error";
                    tmp = Math.tan(tmp);
                } else if ("log".equals(dispose)) {
                    if ("error".equals(tmp))
                        return "error";
                    tmp = Math.log10(tmp);
                } else if ("ln".equals(dispose)) {
                    if ("error".equals(tmp))
                        return "error";
                    tmp = Math.log(tmp);
                } else if ("√".equals(dispose)) {
                    if ("error".equals(tmp))
                        return "error";
                    tmp = Math.sqrt(tmp);
                } else if ("log".equals(dispose)) {
                    if ("error".equals(tmp))
                        return "error";
                    tmp = Math.log(tmp);
                }

                if (index != 0
                        && Character.isDigit(string.charAt(index - 1))) {
                    tmpString = "×" + tmp;
                } else {
                    tmpString = "" + tmp;
                }
                string = string.replaceFirst(dispose + tmpString2, tmpString);
            }
        }

        return string;
    }

    public String advanced_dispose(String string) {
        string = this.dispose1(string);
        string = this.bracke_dispose(string);
        string = this.alg_dispose(string);
        return string;
    }
}







