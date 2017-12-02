package com.qg.funrily.offer29;

/**
 * 面试题29：数组中出现次数超过一半的数字
 * @author FunriLy
 * Created by FunriLy on 2017/11/26.
 * From small beginnings comes great things.
 */
public class Test29 {

    /**
     * 定义了一个全局控制遍历
     * 1、若inputInvalid==true，则非法输入返回0
     * 2、若inputInvalid==false，则合法输入但没有超过数组一半返回0
     */
    private static boolean inputInvalid = false;

    /**
     * 根据start进行快速排序
     * 将小于number[start]的数放置于start左边，否则放置于start右边
     * @param number 给定数组
     * @param start 排序起始索引
     * @param end 排序结束索引
     * @return number[start]新索引
     */
    private static int partition(int[] number, int start, int end) {
        int temp = number[start];
        while (start < end) {
            while (number[end] >= temp && start < end) {
                end--;
            }
            // 从数组结尾开始找到第一个比temp小的索引
            if (start < end) {
                // 交换位置
                number[start] = number[end];
                // 记住这里end的位置是空的
                start++;
            }
            /* 切换扫描指针 */
            while (number[start] < temp && start < end) {
                start++;
            }
            // 从数组开头开始找到第一个比temp大的索引
            if (start < end) {
                number[end] = number[start];
                // 这里start的位置是空的
                end--;
            }
        }
        // start == end
        number[start] = temp;
        return start;
    }

    /**
     * 对输入的数组进行检查
     * @param number 数组
     * @return 如果输入非法返回true，否则返回false
     */
    private static boolean checkInvalidArray(int[] number) {
        inputInvalid = false;
        if (number == null || number.length <=0){
            inputInvalid = true;
        }
        return inputInvalid;
    }

    /**
     * 检查某个数在数组中的个数是否超过数组的一半
     * @param number 给定数组
     * @param index 给定数字
     * @return 如果超过一半返回true，否则返回false
     */
    private static boolean checkMoreThanHalf(int[] number, int index) {
        int count = 0, multiple = 2;
        for (int num : number) {
            if (index == num) {
                count++;
            }
        }
        boolean isMoreThanHalf = true;
        if (count*multiple <= number.length) {
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }

    /**
     * 找到数组中出现次数超过一半的数字
     * 基于partition函数的 O(n) 算法
     * 排序后根据索引缩小搜索范围
     * @param number 给定数组
     * @return 找到的结果数字
     */
    private static int moreThanHalfNum1(int[] number) {
        if (checkInvalidArray(number)) {
            // 若输入非法，返回0
            return 0;
        }
        // 获得中间坐标
        int middle = number.length >> 1;
        int start = 0;
        int end = number.length - 1;
        int index = partition(number, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(number, start, end);
            } else {
                start = index + 1;
                index = partition(number, start, end);
            }
        }
        int result = number[index];
        // 检查是否超过数组的一半
        if (!checkMoreThanHalf(number, result)) {
            return 0;
        }
        return result;
    }

    /**
     * 找到数组中出现次数超过一半的数字
     * 基于数组特点的 O(n) 算法
     * @param number 给定数组
     * @return 找到的结果数字
     */
    private static int moreThanHalfNum2(int[] number) {
        if (checkInvalidArray(number)) {
            return 0;
        }

        int result = number[0];
        int count = 0;

        /*
        因为所求数出现次数超过数组一半。
        我们按照最坏情况来看，目标每一次出现count++后，会有一个混淆数字出现count--，最后count>=0。
        所以，在目标存在的前提下，统计出现最频繁的数就是我们需要找到的目标。
        但也可能出现目标不存在的情况，所以还要经过一层检查。
         */

        for (int i=1; i<number.length; i++) {
            if (count == 0){
                result = number[i];
                count = 1;
            } else if (number[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        if (!checkMoreThanHalf(number, result)) {
            result = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=====基于partition函数的 O(n) 算法=====");
        int[] number1 = {1,2,3,2,2,2,5,4,2};
        int result1 = moreThanHalfNum1(number1);
        System.out.println("输入是否合法：" + !inputInvalid + ", 结果为：" + result1);
        int result2 = moreThanHalfNum1(null);
        System.out.println("输入是否合法：" + !inputInvalid + ", 结果为：" + result2);
        System.out.println("");

        System.out.println("=====基于数组特点的 O(n) 算法=====");
        int result3 = moreThanHalfNum2(number1);
        System.out.println("输入是否合法：" + !inputInvalid + ", 结果为：" + result3);
        int result4 = moreThanHalfNum2(null);
        System.out.println("输入是否合法：" + !inputInvalid + ", 结果为：" + result4);
    }
}
