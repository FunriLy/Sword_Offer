package com.qg.funrily.offer55;

/**
 * 面试题55：字符流中第一个不重复的字符
 * @author FunriLy
 * Created by FunriLy on 2017/11/30.
 * From small beginnings comes great things.
 */
public class Test55 {

    private static class CharStatistics {
        private int index = 0;
        private int[] data = new int[256];

        private CharStatistics() {
            // 初始化标记数组为 -1
            for (int i=0; i<data.length; i++) {
                data[i] = -1;
            }
        }

        private void insert(char ch) {
            if (data[ch] == -1) {
                // 标记为当前字符索引
                data[ch] = index;
            } else {
                // 字符出现了一次以上
                data[ch] = -2;
            }
            index++;
        }

        private char firstAppearingOnce(String str) {
            if (str == null) {
                throw new RuntimeException("非法输入！！！");
            }

            for (int i=0; i<str.length(); i++) {
                insert(str.charAt(i));
            }

            char ch = '\0';
            // 查找最小的正数索引值
            int minIndex = Integer.MAX_VALUE;
            for (int i=0; i<data.length; i++) {
                if (data[i] >= 0 && data[i] < minIndex) {
                    minIndex = data[i];
                    ch = (char) i;
                }
            }

            return ch;
        }
    }

    public static void main(String[] args) {
        //
        System.out.println(new CharStatistics().firstAppearingOnce(""));
        // l
        System.out.println(new CharStatistics().firstAppearingOnce("google"));
        // C
        System.out.println(new CharStatistics().firstAppearingOnce("Chinese"));
    }
}
