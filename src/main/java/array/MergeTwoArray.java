package array;

import java.util.Arrays;

/**
     * leetcode 88.合并两个有序数组
     * 给你两个按非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * 请你合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * 复杂度要求：O(m + n)
     **/
public class MergeTwoArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3,n = 3;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //恶心的测试用例：nums1=[0] m = 0 。。
        int i = 0, j = 0, p = 0;
        int[] res = new int[nums1.length];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[p++] = nums1[i++];
            } else {
                res[p++] = nums2[j++];
            }
        }
        while (i < m) {
            res[p++] = nums1[i++];
        }
        while (j < n) {
            res[p++] = nums2[j++];
        }
        System.arraycopy(res, 0, nums1, 0, res.length);
    }

    /*
    时间复杂度已经足够低，但是空间复杂度还不够，需要优化
    因为nums数组的后面为0，所以指针分别指向两个数组有效数字的尾部
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1,j = n - 1,len = m + n - 1;
        while (i >= 0 && j >= 0){
            nums1[len--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
        }
        System.arraycopy(nums2,i,nums1,0, j + 1);
    }

}
