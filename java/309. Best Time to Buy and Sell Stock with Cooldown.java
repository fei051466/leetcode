public class Solution {
    public int maxProfit(int[] prices) {

        /*
        buy[i] = max(rest[i-1] - prices, buy[i-1])
        sell[i] = max(sell[i-1], buy[i-1] + prices)
        rest[i] = max(rest[i-1], sell[i-1], buy[i-1])

        rest[i] = max(rest[i-1], sell[i-1])
        rest[i] = sell[i-1]

        buy[i] = max(sell[i-2] - prices, buy[i-1])
        sell[i] = max(sell[i-1], buy[i-1] + prices)
        */

        int pre_sell = 0;
        int sell = 0;
        int pre_buy = 0;
        int buy = Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++){
            pre_buy = buy;
            buy = Math.max(pre_sell - prices[i], pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_sell, pre_buy + prices[i]);
        }
        return sell;

    }
}