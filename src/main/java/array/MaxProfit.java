package array;


/**
 * 买卖股票的最佳时机相关leetcode题
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(1);
    }

    /*
    121.买卖股票的最佳时机1
    给定一个数组prices，它的第一个元素prices[i]表示给定股票第i天的价格。
    你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票，
    设计一个算法来计算你所能获取的最大利润
     */

    // 通用方法: 暴力枚举法 超出时间限制了。。。
    public int maxProfit1(int[] prices){
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int tmp = prices[j] - prices[i];
                if (tmp > profit) profit = tmp;
            }
        }
        return profit;
    }

    /*
    价值投资长期持有
    动态规划不太明白，还是使用通俗的方法解决
    因为是先买入股票再卖出，同时只有一次交易，可以使用滑动窗口解决。在这个窗口内要保证最左侧为最小值，然后分别计算右侧与窗口最左侧的插值，
    当右侧滑动出现更小值则将次作为滑动窗口的最左侧，重复上面的操作，直到遍历整个数组
    */
    public int maxProfit(int[] prices){
        int max = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length){
            if (prices[right] > prices[left]){
                max = Math.max(max, prices[right] - prices[left]);
            }else {
                left = right;
            }
            right++;
        }
        return max;
    }

}
