package array;

import java.util.Arrays;

/**
 * leetcode26 删除有序数组中的重复项
 * 给你一个升序排列的数组nums，请你原地删除重复出现的元素，使每个元素只出现一次，
 * 返回删除后数组的新长度。元素的相对顺序应该保持一致。然后返回nums中唯一元素的个数。
 */
public class RemoveOrderElement01 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums){
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]){
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
