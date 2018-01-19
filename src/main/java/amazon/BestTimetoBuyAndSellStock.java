package amazon;

/**
 * Created by admin on 2018/1/18.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p/>
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * <p/>
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * <p/>
 * In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyAndSellStock {

    public int maxProfit1(int[] prices) {



        int right = prices.length - 1, maxProfit = 0;

        while (right > 0) {
            for (int left = 0; left < right; left++) {
                if (prices[left] < prices[right]) {

                    int currentProfit = prices[right] - prices[left];
                    if (currentProfit > maxProfit) {
                        maxProfit = currentProfit;
                    }
                }
            }
            right--;
        }
        return maxProfit;

    }

    /**
     * max subarray problem using Kadane's Algorithm
     *
     * {a,b,c}
     * c-a = (b-a)+(c-b) 相当于累加差值求和
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {

        int maxCur = 0,maxSoFar = 0;
        for (int i=1;i<prices.length;i++){

            //相邻差值累加求和
            maxCur+=prices[i]-prices[i-1];
            //如果求和的值小于0，则断开连续点，从0开始重新累加
            maxCur= Math.max(0,maxCur);
            //比较当前累加值和保留的最大值
            maxSoFar = Math.max(maxCur,maxSoFar);
        }


        return maxSoFar;
    }


}
