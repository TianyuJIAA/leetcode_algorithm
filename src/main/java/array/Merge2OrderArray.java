package array;

import java.util.Arrays;

/**
 * leetcode 88.合并两个有序数组
 * 给你两个按非递减顺序排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 复杂度要求：O(m + n)
 */

public class Merge2OrderArray {
    public static void main(String[] args){
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3, n = 3;
        int[] nums2 = new int[]{2,5,6};

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        // 时间复杂度复合规则，但是空间复杂度过高
        int[] res = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n){
            if (nums1[i] <= nums2[j]){
                res[k++] = nums1[i++];
            }else {
                res[k++] = nums2[j++];
            }
        }
        while (i < m){
            res[k++] = nums1[i++];
        }
        while (j < n){
            res[k++] = nums2[j++];
        }
        System.arraycopy(res, 0, nums1, 0, res.length);
    }

    // 优化空间复杂度，不单独创建数组

}
