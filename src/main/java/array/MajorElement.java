package array;

import java.util.Arrays;

/**
 * leetcode169 多数元素
 * 给定一个大小为n的数组nums，返回其中的多数元素。多数元素是指在数组中出现次数大于n/2的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorElement {
    public static void main(String[] args) {
        int[] nums = new int[]{10,2,2,2,2,3};
        System.out.println(majorityElement1(nums));
    }

    // 对原数组排序，中间index处的即为多数元素
    public static int majorityElement1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
    解法2: Boyer-Moore投票算法 前提是数组中必须存在大于半数的元素
    先将nums[0]作为候选人(candidate)同时选票记为1(vote = 1)，
    然后遍历数组，如果nums[i] != candidate，也就是不支持候选人，则将vote - 1，
    同时如果vote = 0，则将candidate变为num[i],vote重新设置为1
    因为前提是大于半数，所以最终保留的一定是结果
     */
    public static int majorityElement2(int[] nums){
        int candidate = nums[0];
        int vote = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]){
                vote++;
            } else if (--vote == 0) {
                candidate = nums[i];
                vote = 1;
            }
        }
        return candidate;
    }
}
