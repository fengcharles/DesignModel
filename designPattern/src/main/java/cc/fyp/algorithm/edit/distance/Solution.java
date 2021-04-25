package cc.fyp.algorithm.edit.distance;

import java.util.HashMap;
import java.util.Map;

/**
 * 搜索重复数字的算法
 * @author von
 * @description:
 * @date 2020/12/30 18:19
 */
class Solution {
    public static int findRepeatNumber(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int x [] = new int[]{1,2,3,4,2};
        int repeatNumber = findRepeatNumber(x);
        System.out.println(repeatNumber);
    }
}
