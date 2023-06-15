package array;

/**
 * leetcode80. 删除有序数组中的重复项 II
 * 给你一个有序数组nums,请你原地删除重复出现的元素，使得出现次数超过两次的元素只出现两次，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。
 */
public class RemoveElementOrder2 {
    public int removeDuplicates(int[] nums) {
        /*
        快慢指针的经典解法，因为可以保留重复的数字长度最大为2，所以数组的前两个数可以保留
        从第三个数开始判断，如果num[fast] != nums[low - 1] => nums[low + 1] = nums[fast] low++ fast++
        nice
         */
        int n = nums.length;
        if (n <= 2) return n;
        int low = 1;
        for (int fast = 2; fast < n; fast++) {
            if (nums[fast] != nums[low - 1]){
                if (fast - low > 1) {
                    nums[low + 1] = nums[fast];
                }
                low++;
            }
        }
        return low + 1;
    }

    public int removeDuplicates1(int[] nums) {
        // while循环的写法
        int n = nums.length;
        if (n <= 2) return n;
        int low = 1;
        int fast = 2;
        while (fast < n){
            if (nums[fast] != nums[low - 1]){
                if (fast - low > 1) {
                    nums[low + 1] = nums[fast];
                }
                low++;
            }
            fast++;
        }
        return low + 1;
    }
}
