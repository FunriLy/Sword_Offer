package com.qg.funrily.offer40;

/**
 * 面试题40：数组中只出现一次的数字(升级版)
 * @author FunriLy
 * Created by FunriLy on 2017/11/28.
 * From small beginnings comes great things.
 */
public class Test40 {

    /*
    整数数组中不重复的数字只有一个:
    遍历数组，异或每一个数，最后剩下唯一不重复的数。
     */

    /**
     * 查找数组中出现一次的数字
     * 要求数组中只有一个数出现一次，前提数字出现次数必须为偶数次
     * @param number 给定数组
     * @return 查找到的结果
     */
    private static int numberOfOne(int[] number) {
        int length = number.length;
        int result = -1;
        if(length > 1) {
            result = number[0];
            for (int i=1; i<length; i++) {
                result = result ^ number[i];
            }
        }
        return result;
    }

    /*
    先遍历一遍数组，异或得到一个数N，这个数就是只出现一次的那两个数异或的结果。
    找到N最低为1的位（假设是m位），再次遍历数组，按m位为1和为0将数组分为两个数组，此时只出现一次的两个数就被分到了不同的组
    然后再采用 查找数组中出现一次的数字 的方法来找到了个目标数字。
     */

    // todo:这里详细看一下《剑指Offer》，书上解释更加详细！

    /**
     * 查找数组中两个只出现一次的数字
     * @param number 给定数组
     * @param num 存储结果数组
     */
    private static void numberOfTwo(int[] number, int[] num) {
        if (number == null || number.length <= 1) {
            return;
        }
        int length = number.length;
        int temp = number[0];
        for (int i=1; i<length; i++) {
            temp ^= number[i];
        }
        int index = findFirstOne(temp);
        for (int i=0; i<length; i++) {
            if (isOne(number[i], index)) {
                // 从一组子数组中查找出现一次的数
                num[0] ^= number[i];
            } else {
                // 从另外一组子数组中查找出现一次的数
                num[1] ^= number[i];
            }
        }
    }

    /**
     * 查找数字中第几位为 1
     * @param n 给定数字
     * @return 索引
     */
    private static int findFirstOne(int n) {
        int i = 0;
        while ((n & 1) == 0) {
            i++;
            n = n>>1;
        }
        return i;
    }

    /**
     * 判断数字在二进制表示中从右起第 index 位是不是 1
     * @param num 给定数字
     * @param index 索引位置
     * @return 若第 index 位是 1 返回true，否则返回 false
     */
    private static boolean isOne(int num, int index) {
        return  (((num >> index) & 1) == 1);
    }

    /*
    重复的数字大于两个，采用 Map 来存储出现次数
     */

    /*
    若数组为字符数组，因为字符只有256个，可以用一个容量为256的数组来标识字符出现的次数
     */

    /**
     * 找出字符串中第一个只出现一次的字符
     * @param str 给定字符串
     * @return 若找到则返回结果字符，否则返回 '\0'
     */
    private static char findFirst(String str) {
        if (str == null || str.length() < 1) {
            return '\0';
        }
        int[] hashTable = new int[256];
        int length = str.length();
        char[] array = str.toCharArray();
        for (int i=0; i<length; i++) {
            hashTable[array[i]]++;
        }

        for (int i=0; i<length; i++) {
            if (hashTable[array[i]] == 1) {
                return array[i];
            }
        }
        // 没有找到目标字符
        return '\0';
    }


    public static void main(String[] args) {
        int[] data1 = { 1, 3, 3, 6, 6};
        System.out.println(numberOfOne(data1));

        int[] data2 = { 2, 4, 3, 6, 3, 2, 5, 5};
        int[] num = {0, 0};
        numberOfTwo(data2, num);
        System.out.println(num[0] + " " + num[1]);

        System.out.println(findFirst("abcdabc"));
    }
}
