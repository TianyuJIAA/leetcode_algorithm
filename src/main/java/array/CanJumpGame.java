package array;

import javax.swing.plaf.metal.MetalTheme;
import java.util.Arrays;

/**
 * 55.跳跃游戏
 * 给你一个非负整数数组nums，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回true；否则，返回false
 * nums = [2,3,1,1,4] -> true
 * nums = [3,2,1,0,4] -> false
 */
public class CanJumpGame {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        boolean res = canJump(nums);
        System.out.println(res);
    }

    /*
    到达问题使用反向思路求解是不是更合理一点?
    比如如果可以从第i个台阶到达最后一个台阶，那么需要判断是否存在从第j个台阶跳到第i个台阶，一次类推，直到反推到第一个台阶
     */
    public static boolean canJump1(int[] nums){
        int len = nums.length;
        if (len == 1) return true;
        for (int i = len - 2; i >= 0; i--) {
              if (nums[i] >= len - 1 - i){
                  canJump1(Arrays.copyOfRange(nums,0,i+1));
              }
        }
        return false;
    }

    /*
    来源于官方解法: 贪心
    从头遍历数组，始终维护最远可以到达的位置。
    当遍历到某个位置时，首先判断是否在可以到达的位置内：
    如果不在则直接返回false，
    如果在则判断从当前位置可以达到的最远位置，如果此时已经超过了数组的最大索引位置，直接返回true
    如果未超过且从此位置能达到的最远位置超过了之前维护的最远可以达到的位置，则更新
     */
    public static boolean canJump(int[] nums){
        int target = nums.length;
        if (target == 1) return true;
        int max_pos = nums[0];
        for (int i = 1; i < target; i++) {
            if (i > max_pos){
                return false;
            }else {
                if (i + nums[i] >= target - 1) return true;
                max_pos = Math.max(max_pos, i + nums[i]);
            }
        }
        return false;
    }


}
