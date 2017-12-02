package com.qg.funrily.offer64;

import java.util.*;

/**
 * 面试题64：数据流中的中位数
 * @author FunriLy
 * Created by FunriLy on 2017/12/1.
 * From small beginnings comes great things.
 */
public class Test64 {

    /*
    解法1:采用一个集合存储数据流，并对集合进行排序，取其中位数
     */

    private static List<Integer> array = new ArrayList<>();

    /**
     * 重置(清空)集合
     */
    private static void resetArray() {
        if (!array.isEmpty()){
            array.clear();
        }
    }

    /**
     * 将元素加入集合
     * @param num 插入的元素
     */
    private static void insertArray(int num) {
        array.add(num);
    }

    /**
     * 取集合中位数
     * @return 集合中位数
     */
    private static double getMedianArray() {
        double middle = 0.0;
        int size = array.size();
        if (size != 0) {
            Integer[] number = array.toArray(new Integer[size]);
            Arrays.sort(number);
            if (size % 2 == 0) {
                middle = (number[size/2-1] + number[size/2]) / 2.0;
            } else {
                int index = size / 2;
                middle = number[index];
            }
        }
        return middle;
    }

    /*
    解法2:采用大顶堆+小顶堆作为容器。
    两个堆的数据数目差不能超过1，确保中位数就在两个堆顶的数之中。
    注意：要求大顶堆中的所有数据都要小于小顶堆，确保排序。
     */

    private static int count = 0;
    private static Queue<Integer> minHeap = new PriorityQueue<>();
    private static Queue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            // 重写比较器
            return o2 - o1;
        }
    });

    /**
     * 重置(清空两个顶堆)
     */
    private static void resetHeap() {
        count = 0;
        if (!minHeap.isEmpty()) {
            minHeap.clear();
        }
        if (!maxHeap.isEmpty()) {
            maxHeap.clear();
        }
    }

    /**
     * 将元素插入顶堆
     * @param num 插入的元素
     */
    private static void insertHeap(int num) {
        int size = 2;
        if (count % size == 0) {
            // 把数插入大顶堆
            maxHeap.offer(num);
            // 获得大顶堆最大的数
            int filteredMaxNum = maxHeap.poll();
            // 插入小顶堆
            minHeap.offer(filteredMaxNum);
        } else {
            // 与上面相反
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    /**
     * 取顶堆中位数
     * @return 顶堆中位数
     */
    private static Double getMedianHeap() {
        int size = 2;
        if (count % size == 0) {
            if (minHeap.size() <=0 || maxHeap.size() <= 0) {
                return 0.0;
            }
            int sum = minHeap.peek() + maxHeap.peek();
            return sum * 1.0 / 2.0;
        } else {
            if (minHeap.size() <=0) {
                return 0.0;
            }
            int sum = minHeap.peek();
            return 1.0 * sum;
        }
    }

    public static void main(String[] args) {

        System.out.println(getMedianArray() + " " + getMedianHeap());

        insertArray(5);
        insertHeap(5);
        // 5
        System.out.println(getMedianArray() + " " + getMedianHeap());

        insertArray(2);
        insertHeap(2);
        // 3.5
        System.out.println(getMedianArray() + " " + getMedianHeap());

        insertArray(3);
        insertHeap(3);
        // 3
        System.out.println(getMedianArray() + " " + getMedianHeap());

        insertArray(4);
        insertHeap(4);
        // 3.5
        System.out.println(getMedianArray() + " " + getMedianHeap());

        insertArray(1);
        insertHeap(1);
        // 3
        System.out.println(getMedianArray() + " " + getMedianHeap());

        insertArray(6);
        insertHeap(6);
        // 3.5
        System.out.println(getMedianArray() + " " + getMedianHeap());

        insertArray(7);
        insertHeap(7);
        // 4
        System.out.println(getMedianArray() + " " + getMedianHeap());

        insertArray(0);
        insertHeap(0);
        // 3.5
        System.out.println(getMedianArray() + " " + getMedianHeap());

        insertArray(8);
        insertHeap(8);
        // 4
        System.out.println(getMedianArray() + " " + getMedianHeap());

        resetArray();
        resetHeap();
    }
}
