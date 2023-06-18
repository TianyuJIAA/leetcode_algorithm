package array;

/**
 * leetcode189 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class RotateArray {
    /*
    难度在于如何修改原数组即空间复杂度为o(1)
    这里其实是类似分治算法的思想？
    [1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1] -> [5,6,7] + [1,2,3,4]
    等于将原数组旋转了3次，一次是整体旋转，然后分别对两个子数组进行旋转
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        //[1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1]
        rotateMethod(nums,0,nums.length - 1);
        //[7,6,5,4,3,2,1] -> [5,6,7,4,3,2,1]
        rotateMethod(nums,0,k - 1);
        //[5,6,7,4,3,2,1] -> [5,6,7,1,2,3,4]
        rotateMethod(nums,k,nums.length - 1);
    }

    public void rotateMethod(int[] nums,int start,int end){
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
