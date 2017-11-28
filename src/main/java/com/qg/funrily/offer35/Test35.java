package com.qg.funrily.offer35;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题35：第一个只出现一次的字符
 * @author FunriLy
 * Created by FunriLy on 2017/11/28.
 * From small beginnings comes great things.
 */
public class Test35 {

    /**
     * 在给定字符串中找到第一个只出现一次的字符
     * @param s 给定字符串
     * @return 寻找结果
     */
    private static char firstNotRepeatingChar(String s) {
        if (s == null || s.length() < 1) {
            throw new RuntimeException("非法输入!!!");
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] strChar = s.toCharArray();
        // 计数
        for (int i=0; i<strChar.length; i++) {
            char ch = strChar[i];
            if (map.containsKey(ch)) {
                // 如果出现超过一次，设置为-2
                map.put(ch, -2);
            } else {
                // 如果第一次出现，则记录其索引位置
                map.put(ch, i);
            }
        }
        char result = '\0';
        int index = Integer.MAX_VALUE;

        for (char key : map.keySet()) {
            // 找到值为非零且最小的map
            if (map.get(key) >= 0 && map.get(key) < index) {
                index = map.get(key);
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // l
        System.out.println(firstNotRepeatingChar("google"));
        //
        System.out.println(firstNotRepeatingChar("aabccdbd"));
        // a
        System.out.println(firstNotRepeatingChar("abcdefg"));
        // b
        System.out.println(firstNotRepeatingChar("abaccdeff"));
    }
}
