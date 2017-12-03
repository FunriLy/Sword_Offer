package com.qg.funrily.offer53;

/**
 * 面试题53：正则表达式匹配
 * @author FunriLy
 * Created by FunriLy on 2017/11/30.
 * From small beginnings comes great things.
 */
public class Test53 {

    // todo:该题多看几遍

    private static final char STAR = '*';
    private static final char POINT = '.';

    /**
     * 正则表达式匹配
     * @param input 输入字符串
     * @param pattern 匹配字符串
     * @return 若匹配成功返回true，否则返回false
     */
    private static boolean match(String input, String pattern) {
        return !(input == null || pattern == null) && matchCore(input, pattern, 0, 0);
    }

    /**
     * 正则表达式匹配
     * @param input 输入字符串
     * @param pattern 匹配字符串
     * @param i 输入字符串当前匹配索引
     * @param p 匹配字符串当前匹配索引
     * @return 若匹配成功返回true，否则返回false
     */
    private static boolean matchCore(String input, String pattern, int i, int p) {
        // 若输入字符串、匹配字符串遍历同时到达结束，表示匹配成功
        if (i >= input.length() && p >= pattern.length()) {
            return true;
        }
        // 若只有匹配字符串遍历结束，表示匹配失败
        if (i != input.length() && p >= pattern.length()) {
            return false;
        }
        // 只要匹配字符串遍历未结束，不能确定输入字符串的情况

        // 若匹配字符串下一个字符为 '*'
        if (p + 1 <pattern.length() && pattern.charAt(p+1) == STAR) {
            // 若输入字符串已经结束
            if (i >= input.length()) {
                // 移动两位
                return matchCore(input, pattern, i, p+2);
            } else {
                // 输入字符串还没遍历结束
                if (pattern.charAt(p) == input.charAt(i) || pattern.charAt(p) == POINT) {
                    // 如果当前字符串匹配成功，或者当前匹配字符串为 '.'
                    return
                            // 匹配串向后移动一个位置，模式串向后移动两个位置
                            matchCore(input, pattern, i + 1, p + 2)
                                    // 匹配串向后移动一个位置，模式串不移动
                                    || matchCore(input, pattern, i+1, p)
                                    // 匹配串不移动，模式串向后移动两个位置
                                    || matchCore(input, pattern, i, p + 2);
                } else {
                    // 移动两位，相当于当前字符和 '*' 被忽略了，匹配字符串中0个字符
                    return matchCore(input, pattern, i, p+2);
                }
            }
        }
        // 再次检查输入字符串有没有结束
        if (i >= input.length()) {
            return false;
        } else {
            // 如果没有结束，若当前两个字符串字符相同，或者匹配字符串当前字符为 '.'
            // 则两个字符串同时往前移动一位，继续匹配
            if (input.charAt(i) == pattern.charAt(p) || pattern.charAt(p) == POINT) {
                return matchCore(input, pattern, i+1, p+1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(match("", ""));
        System.out.println(match("", ".*"));
        // false
        System.out.println(match("", ".") + " false");
        System.out.println(match("", "c*"));
        System.out.println(match("a", ".*"));
        // false
        System.out.println(match("a", "a.") + " false");
        // false
        System.out.println(match("a", "") + " false");
        System.out.println(match("a", "."));
        System.out.println(match("a", "ab*"));
        // false
        System.out.println(match("a", "ab*a") + " false");
        System.out.println(match("aa", "aa"));
        System.out.println(match("aa", "a*"));
        System.out.println(match("aa", ".*"));
        // false
        System.out.println(match("aa", ".") + " false");
        System.out.println(match("ab", ".*"));
        System.out.println(match("aaa", "aa*"));
        // false
        System.out.println(match("aaa", "aa.a") + " false");
        System.out.println(match("aaa", "a.a"));
        // false
        System.out.println(match("aaa", ".a") + " false");
        System.out.println(match("aaa", "a*a"));
        // false
        System.out.println(match("aaa", "ab*a") + " false");
        System.out.println(match("aaa", "ab*ac*a"));
        System.out.println(match("aaa", "ab*a*c*a"));
        System.out.println(match("aaa", ".*"));
        System.out.println(match("aab", "c*a*b"));
        System.out.println(match("aaca", "ab*a*c*a"));
        // false
        System.out.println(match("aaba", "ab*a*c*a") + " false");
        System.out.println(match("bbbba", ".*a*a"));
        // false
        System.out.println(match("bcbbabab", ".*a*a") + " false");
    }
}
