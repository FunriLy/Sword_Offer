package com.qg.funrily.offer04;

/**
 * 面试题4：替换空格
 * @author FunriLy
 * Created by FunriLy on 2017/11/21.
 * From small beginnings comes great things.
 */
public class Test04 {

    /**
     * 将字符数组中空格替换为"%20"
     * @param string 字符数组
     * @param length 字符数组已经使用的长度
     */
    private static void replaceBlank(char[] string, int length) {
        if (string==null || length<=0) {
            return;
        }

        int numberOfBlank = 0;
        for (int i=0; i<length; i++) {
            if (string[i] == ' ') {
                numberOfBlank++;
            }
        }

        int newLength = length + numberOfBlank * 2;
        int tmpLength = newLength;
        if (newLength > string.length) {
            return;
        }
        // 不存在空格
        if (numberOfBlank == 0) {
            return;
        }
        // 从后往前开始处理数据
        length--;
        newLength--;
        while (length >= 0 && length < newLength) {
            // 如是当前字符是空白字符，进行"%20"替换
            if (string[length] == ' ') {
                string[newLength--] = '0';
                string[newLength--] = '2';
                string[newLength--] = '%';
            } else { // 否则移动字符
                string[newLength--] = string[length];
            }
            length--;
        }

        System.out.println(new String(string, 0, tmpLength));
    }

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = 'F';
        string[1] = 'u';
        string[2] = 'n';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'i';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'L';
        string[9] = ' ';
        string[10] = 'y';
        string[11] = ' ';
        replaceBlank(string, 12);
    }
}
