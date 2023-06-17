package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * leetcode169 多数元素
 * 给定一个大小为n的数组nums，返回其中的多数元素。多数元素是指在数组中出现次数大于n/2的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MostlyElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3};
        int i = majorityElement1(nums);
    }

    // 解法1: 空间复杂度较高o(n)的解法：构建一个map存储每个num出现的次数,太慢了！！
    public static int majorityElement1(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int j : nums) {
            int value = hashMap.getOrDefault(j, 0);
            hashMap.put(j, value + 1);
        }
        Set<Integer> set = hashMap.keySet();
        int res = 0;
        for(Integer num : set){
            if (hashMap.get(num) > nums.length / 2){
                res = num;
            }
        }
        return res;
    }

    // 解法2: 使用排序算法，那么数据的第nums.length / 2 的位置的元素肯定就是结果
    // todo 之前的学到的排序算法需要重新搞定，快排，堆排序，以及对应的时间和空间复杂度
    public int majorityElement2(int[] nums) {
        // 自带的排序算法为快排
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
    解法3: Boyer-Moore投票算法 前提是数组中必须存在大于半数的元素
    先将nums[0]作为候选人(candidate)同时选票记为1(vote = 1)，
    然后遍历数组，如果nums[i] != candidate，也就是不支持候选人，则将vote - 1，
    同时如果vote = 0，则将candidate变为num[i],vote重新设置为1
    因为前提是大于半数，所以最终保留的一定是结果
     */
    public int majorityElement3(int[] nums) {
        int candidate = nums[0];
        int vote = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate){
                vote++;
            }else if (--vote == 0){
                candidate = nums[i];
                vote = 1;
            }
        }
        return candidate;
    }
}
