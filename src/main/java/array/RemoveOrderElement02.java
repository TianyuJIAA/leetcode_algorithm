package array;

import java.util.Arrays;

/**
 * leetcode80 删除有序数组中的重复项1
 * 给你一个升序排列的数组nums，请你原地删除重复出现的元素，使得出现次数超过两次的元素只出现两次，
 * 返回删除后数组的新长度。元素的相对顺序应该保持一致。然后返回nums中唯一元素的个数。
 */
public class RemoveOrderElement02 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int res = removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates1(int[] nums){
        // 常规思路不太行，最后一个没有办法处理，会出现测试用例不通过的情况
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[j] == nums[i]){
                i++;
            }
            if (nums[j] != nums[i]){
                int tmp = nums[j];
                if (i - j > 1){
                    nums[++j] = tmp;
                }
                nums[++j] = nums[i];
            }

        }
        return j + 1;
    }

    public static int removeDuplicates(int[] nums){
        // 思路跟删除有序数组中的重复项差不多
        int j = 1;
        for (int i = 2; i < nums.length; i++) {
            //保留两个元素，所以需要看前面的一个
            if (nums[i] != nums[j - 1]){
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
