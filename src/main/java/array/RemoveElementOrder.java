package array;

/**
 * leetcode 删除有序数组中的重复项
 * 给你一个升序排列的数组nums，请你原地删除重复出现的元素，使每个元素只出现一次，
 * 返回删除后数组的新长度。元素的相对顺序应该保持一致。然后返回nums中唯一元素的个数。
 */
public class RemoveElementOrder {
    /*
    还是双指针的解法，right用来遍历数组，而left表示有效数组的长度
    可以优化，例如[1,2,3,4]这样会把数组复制一遍
     */
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] > nums[left]){
                // [1,1,2] 需要现将left + 1，然后再交换
                if (right - left > 1){
                    nums[left + 1] = nums[right];
                }
                left += 1;
            }
        }
        return left + 1;
    }
}
