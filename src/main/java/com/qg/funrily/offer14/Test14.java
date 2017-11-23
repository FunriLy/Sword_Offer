package com.qg.funrily.offer14;

/**
 * 面试题14：调整数组顺序使奇数位于偶数前面
 * @author FunriLy
 * Created by FunriLy on 2017/11/23.
 * From small beginnings comes great things.
 */
public class Test14 {

    /**
     * 调整数组元素，使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分
     * @param datas 给定数组
     */
    private static void reorder(int[] datas) {
        if (datas == null || datas.length <=0) {
            throw new RuntimeException("非法输入！");
        }
        int left = 0;
        int right = datas.length - 1;
        while (left < right) {
            while(left<right&&!isEven(datas[left])){
                left++;
            }
            while(left<right&&isEven(datas[right])){
                right--;
            }
            if(left<right){
                int temp = datas[right];
                datas[right] = datas[left];
                datas[left] = temp;
            }
            if(left>=right){
                break;
            }
        }
    }

    /**
     * 判断一个整数是否是偶数
     * @param i 给定整数
     * @return 若返回true是偶数，否则是奇数
     */
    private static boolean isEven(int i) {
        // 采用位移，是因为效率比取余操作快
        return (i&0x1)==0;
    }

    public static void main(String[] args) {
        int[] datas={3,7,4,8,23,56,77,89,46,11,66,77};
        reorder(datas);
        for(int data : datas){
            System.out.println(data);
        }
    }
}
