package com.xiaomi.exam;

import java.util.Arrays;

public class Solution {

    public static int count = 0;

    /**
     *
     * @param array 输入的数组实例
     * @param val  需要查找的值
     * @param sorted 数组是否已经排序，0表示升序，1表示降序,其他情况表示无序
     * @return
     */
    public static int binarySearch(int [] array,int val,int sorted){
        count = 0;
        if(array == null) return -1;

        int l = 0;
        int r = array.length - 1;
        int mid = 0;

        //输入数组为升序排序的情况
        if(sorted == 0) {
            if (l>r || val < array[l] || val > array[r] )
                return -1;
            while (l <= r) {
                mid = (l + r) / 2;
                count++;
                if (array[mid] > val) {
                    r = mid - 1;
                } else if (array[mid] < val) {
                    l = mid + 1;
                } else {
                    return mid;
                }

            }
        //输入数组为降序排序的情况
        }else if(sorted == 1){
            if (l>r || val > array[l] || val < array[r])
                return -1;
            while (l <= r) {
                mid = (l + r) / 2;
                count++;
                if (array[mid] > val) {
                    l = mid + 1;
                } else if (array[mid] < val) {
                    r = mid - 1;
                } else {
                    return mid;
                }

            }

        //输入数组为无序数组的情况,该情况不符合二分查找的前置条件需要先排序，再查找，但是这种平均效率为排序效率O(nlogn),不如直接暴力查找，效率为O(n)
        }else {
            for(int i=0; i< array.length;i++){
                count++;
                if(val == array[i]) return i;
            }
        }

        return -1;
    }


}
