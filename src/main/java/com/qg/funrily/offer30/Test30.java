package com.qg.funrily.offer30;

import java.util.Arrays;

/**
 * 面试题30：最小的k个数
 * @author FunriLy
 * Created by FunriLy on 2017/11/27.
 * From small beginnings comes great things.
 */
public class Test30 {

    private static int partition(int[] number, int start, int end) {
        int temp = number[start];
        while (start < end) {
            while (number[end] >= temp && start < end) {
                end--;
            }
            if (start < end) {
                number[start] = number[end];
                start++;
            }
            while (number[start] < temp && start < end) {
                start++;
            }
            if (start < end) {
                number[end] = number[start];
                end--;
            }
        }
        number[start] = temp;
        return start;
    }

    /**
     * 最小的k个数
     * @param input 给定数组
     * @param k 给定长度
     * @return 含有最小k个数的数组
     */
    private static int[] getLeastNumbers1(int[] input, int k) {
        if (input == null || input.length<=0 || k<=0 || k>input.length) {
            return null;
        }
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k-1) {
            if (index > k-1) {
                end = index - 1;
                index = partition(input, start, end);
            } else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }
        int[] output = new int[k];
        System.arraycopy(input, 0, output, 0, k);
        return output;
    }

    /**
     * 最小的k个数
     * 时间复杂度 O(n*log n) 适合处理海量数据
     * 参考资料：https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/No30.java
     * @param input 给定数组
     * @param k 给定长度
     * @return 含有最小k个数的数组
     */
    private static int[] getLeastNumbers2(int[] input, int k) {
        if (input == null || input.length<=0 || k<=0 || k>input.length) {
            return null;
        }
        int[] arr = new int[k];
        // 先构造容器，并将前k个数字填充入容器
        for(int i=0; i<k; i++) {
            arr[i] = input[i];
        }
        // 构造堆
        buildHeap(arr);
        for (int j=k; j<arr.length; j++) {
            // 堆接下来的数字进行判断，若小于堆顶元素则入堆
            if (input[j] < arr[0]) {
                arr[0] = input[j];
                // 入堆后进行调整，确保最大元素位于堆顶
                maxHeap(arr, 1, k);
            }
        }
        return arr;
    }

    /**
     * 构造最大堆
     * @param arr 给定数组
     */
    private static void buildHeap(int[] arr) {
        int heapSize = arr.length;
        int k = 2;
        for(int i=arr.length/k; i>0; i--) {
            // 堆排序为了寻找规律，一般是从1开始计数的，下面的-1操作也反映了这个问题
            maxHeap(arr, i, heapSize);
        }
    }

    /**
     * 调整为最大堆
     * 堆排序操作
     * @param arr 给定数组
     * @param i 当前调整索引
     * @param heapSize 堆大小
     */
    private static void maxHeap(int[] arr,int i,int heapSize){
        int largest = i;
        // 堆元素为i，则左孩子为2*i，右孩子为2*i+1
        int left = 2 * i;
        int right = 2 * i + 1;
        if (left<=heapSize && arr[largest-1]<arr[left-1]) {
            largest = left;
        }
        if (right<=heapSize && arr[largest-1]<arr[right-1]) {
            largest = right;
        }

        if (largest != i) {
            // 若堆不平衡，找到最大孩子节点与其主节点进行交换
            int temp = arr[i-1];
            arr[i-1] = arr[largest-1];
            arr[largest-1] = temp;
            // 同时对其孩子进行重新调整
            maxHeap(arr, largest, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] output1 = getLeastNumbers1(input, 4);
        int[] output2 = getLeastNumbers2(input, 4);
        System.out.println("时间复杂度 O(n) 算法：" + Arrays.toString(output1));
        System.out.println("时间复杂度 O(n*log n) 算法：" + Arrays.toString(output2));
    }
}
