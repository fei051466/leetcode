public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        if(prices.length == 2){
            if(prices[0] >= prices[1]){
                return 0;
            }
            else{
                return prices[1] - prices[0];
            }
        }
        int res = 0;
        int index = 2;
        int low = 0;
        boolean asc = prices[0] < prices[1];
        if(asc){
            low = prices[0];
        }
        while(index < prices.length){
            if(asc){
                if(prices[index] < prices[index-1]){
                    res += prices[index-1] - low;
                    asc = false;
                }
            }
            else{
                if(prices[index] >= prices[index-1]){
                    low = prices[index-1];
                    asc = true;
                }
            }
            index++;
        }
        if(asc){
            res += prices[prices.length-1] - low;
        }

        return res;
    }
}