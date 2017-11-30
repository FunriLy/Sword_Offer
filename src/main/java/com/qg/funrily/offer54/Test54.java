package com.qg.funrily.offer54;

/**
 * 面试题54：表示数值的字符串
 * @author FunriLy
 * Created by FunriLy on 2017/11/30.
 * From small beginnings comes great things.
 */
public class Test54 {

    /*
    参考资料：https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test54.java
     */

    /**
     * 判断字符串是否可以表示为数值(包括指数和小数)
     * @param string 给定字符串
     * @return 若可以表示为数值返回true，否则返回false
     */
    private static boolean isNumeric(String string) {
        if (string == null || string.length() < 1) {
            return false;
        }

        int index = 0;
        char minus = '-', plus = '+';
        char e = 'e', eM = 'E', point = '.';
        // 去掉可能出现的第一个字符表示
        if (string.charAt(index) == minus || string.charAt(index) == plus) {
            index++;
        }

        // 如果到达字符串末尾
        if (index >= string.length()) {
            return false;
        }

        boolean numeric = true;
        // 对字符串数字部分进行处理
        index = scanDigits(string, index);
        // 还未处理到字符串末尾
        if (index < string.length()) {
            // 如果是小数
            if (string.charAt(index) == point) {
                index++;
                index = scanDigits(string, index);
                if (index >= string.length()) {
                    numeric = true;
                }
                // 含小数点的字符串还没处理完，可能有指数
                else if (string.charAt(index) == e || string.charAt(index) == eM) {
                    numeric = isExponential(string, index);
                } else {
                    numeric = false;
                }
            }
            // 如果是指数
            else if (string.charAt(index) == e || string.charAt(index) == eM) {
                numeric = isExponential(string, index);
            } else {
                numeric = false;
            }

            return numeric;

        } else {
            return true;
        }
    }

    /**
     * 扫描字符串部分的数字
     * @param string 字符串
     * @param index 扫描起始索引
     * @return 扫描到第一个非数字位置的索引
     */
    private static int scanDigits(String string, int index) {
        char minNum = '0', maxNum = '9';
        while (index < string.length() && string.charAt(index) >= minNum && string.charAt(index) <= maxNum) {
            index++;
        }
        return index;
    }

    /**
     * 判断字符串部分是不是指数形式
     * @param string 字符串
     * @param index 扫描起始索引
     * @return 若判断正确返回true，否则返回false
     */
    private static boolean isExponential(String string, int index) {
        char e = 'e';
        char eM = 'E';
        if (index >= string.length()) {
            return false;
        }
        if ((string.charAt(index) != e && string.charAt(index) != eM)) {
            return false;
        }
        // 判断完 e 或者 E 后，索引+1
        index++;
        char minus = '-';
        char plus = '+';
        // 如果只有一个 e 或者 E，返回false
        if (index >= string.length()) {
            return false;
        }
        if (string.charAt(index) == plus || string.charAt(index) == minus) {
            index++;
        }
        if (index >= string.length()) {
            return false;
        }
        // 扫描数字部分
        index = scanDigits(string, index);
        // 如果处理到数组末尾证明是正确的指数
        return index >= string.length();
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("100") + "[" + true + "]");
        System.out.println(isNumeric("123.45e+6") + "[" + true + "]");
        System.out.println(isNumeric("+500") + "[" + true + "]");
        System.out.println(isNumeric("5e2") + "[" + true + "]");
        System.out.println(isNumeric("3.1416") + "[" + true + "]");
        System.out.println(isNumeric("600.") + "[" + true + "]");
        System.out.println(isNumeric("-.123") + "[" + true + "]");
        System.out.println(isNumeric("-1E-16") + "[" + true + "]");
        System.out.println(isNumeric("100") + "[" + true + "]");
        System.out.println(isNumeric("1.79769313486232E+308") + "[" + true + "]");
        System.out.println();

        System.out.println(isNumeric("12e") + "[" + false + "]");
        System.out.println(isNumeric("1a3.14") + "[" + false + "]");
        System.out.println(isNumeric("1+23") + "[" + false + "]");
        System.out.println(isNumeric("1.2.3") + "[" + false + "]");
        System.out.println(isNumeric("+-5") + "[" + false + "]");
        System.out.println(isNumeric("12e+5.4") + "[" + false + "]");
    }
}
