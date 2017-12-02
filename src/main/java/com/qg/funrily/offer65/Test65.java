package com.qg.funrily.offer65;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题65：滑动窗口的最大值
 * @author FunriLy
 * Created by FunriLy on 2017/12/1.
 * From small beginnings comes great things.
 */
public class Test65 {

    /**
     * 获得滑动窗口的最大值列表
     * @param num 滑动窗口数组
     * @param size 滑动窗口空间大小
     * @return 滑动窗口最大值列表
     */
    private static List<Integer> maxInWindows(List<Integer> num, int size) {
        List<Integer> maxWindow = new LinkedList<>();
        // 参数检查
        if (num == null || size < 1 || num.size() < 1 || size > num.size()) {
            return maxWindow;
        }
        // 构造队列，用于存储索引
        Deque<Integer> index = new LinkedList<>();
        // 构造第一个满值窗口流，并将其最大值存入队列
        for(int i=0; i<size; i++) {
            while (!index.isEmpty() && num.get(i) >= num.get(index.getLast())) {
                // 如果窗口不为空，且当前值大于窗口存储值
                index.removeLast();
            }
            // 最终存入大英窗口最大值的索引
            index.add(i);
        }

        /*
        很巧妙是思路:
        1、从滑动窗口第一次满值开始，接下来每个数都会入队列(可能成为下次窗口的最大值)：
        存储队列会维护一个由大到小的的索引数组，若当前值小于队列最小值(队列最后一个元素)，则正常加入队列；
        若当前值大于数组的最小值，则去掉比当前值小的元素并加入队列。
        2、同时，窗口每次移动都会将队列的最大值(队列队头元素)加入到返回数组中。
        3、在入队的过程中可能发生一种情况，就是队列队头元素已经不在当前窗口内，因此需要将其移除队列。
        其判断条件是：若索引与当前数值的索引之差 大于或者等于 滑动窗口的大小。
         */

        // 滑动窗口已经满，开始移动窗口
        for (int i=size; i<num.size(); i++) {
            // 先将上一个窗口的最大值存入数组
            maxWindow.add(num.get(index.getFirst()));

            while (!index.isEmpty() && num.get(i) >= num.get(index.getLast())) {
                // 移除比当前值小的元素
                index.removeLast();
            }

            if (!index.isEmpty() && index.getFirst() <= (i-size)) {
                // 如果队列不为空
                index.removeFirst();
            }
            // 将当前值索引加入队列
            index.add(i);
        }
        // 注意：最后一个数值索引入队后，需要将最后一个窗口的最大值加入到返回数组
        maxWindow.add(num.get(index.getFirst()));
        return maxWindow;
    }

    /**
     * 将整数数组转换为链表集合
     * @param array 数组
     * @return 链表集合
     */
    private static List<Integer> arrayToList(int[] array) {
        List<Integer> list = new LinkedList<>();
        if (array != null) {
            for (int num : array) {
                list.add(num);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = { 2, 3, 4, 2, 6, 2, 5, 1};
        List<Integer> list = arrayToList(array);
        System.out.println(maxInWindows(list, 3));
    }
}
