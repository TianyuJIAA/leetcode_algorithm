package array;

/**
 * leetcode27 移除元素
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class RemoveElement {
    /*
    思路：将等于val的元素移动到数据的末尾，其他元素放在数组的前面，顺序无所谓
    双指针，一个用来遍历数组，另一个指向待交换的位置
    left指向返回也就是有效数组的索引位置，而right用来遍历数组
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val){
                // 这里是可以优化的，其实不需要交换left和right的值，因为遍历了一边数组，所以将不等于val的值都拿到了前面来
//                int tmp = nums[left];
                nums[left] = nums[right];
//                nums[right] = tmp;
                left++;
            }
        }
        return left;
    }

    //nums[right] != val的逻辑看起来有点怪
    public int removeElement1(int[] nums,int val){
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == val){
                int tmp = nums[i];
                nums[i] = nums[right];
                nums[right] = tmp;
                i--;
                right--;
            }
        }
        return right + 1;
    }
}
