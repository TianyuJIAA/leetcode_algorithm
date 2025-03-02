package array;

/**
 * 122.买卖股票的最佳时机2
 * 给定一个整数数组prices，表示某支股票第i天的价格。
 * 在每一天，你可以决定是否购买或出售股票。你在任何时候最多只能持有一只股票。
 * 你也可以先购买，然后在同一天出售T+0
 * 返回你能获得的最大利润
 * prices = [7,1,5,3,6,4]
 */
public class MaxProfit02 {
    public static void main(String[] args) {
        System.out.println(1);
    }

    /*
    思路与最佳时机1类似，还是打算通过滑动窗口解决
    因为可以买卖多次，窗口的昨边界还是维持窗口内最小的股价，同时保证窗口内股价是递增的
    在这个窗口内要保证最左侧为最小值，然后向右滑动窗口，要始终窗口内的数据是递增的，当第i天的股价小于第i-1天时需要结算，
    此时股票收益为prices[i-1] - prices[left]。并将第i天的股价作为滑动窗口的最左侧，重复上面的操作，直到遍历整个数组
    同时需要特殊处理最后一段为单调递增的情况。
    波段交易
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length){
            if (prices[right] <= prices[right - 1]){
                profit += prices[right - 1] - prices[left];
                left = right;
            }
            right++;
            if (right == prices.length){
                profit += prices[right - 1] - prices[left];
            }
        }
        return profit;
    }

}
