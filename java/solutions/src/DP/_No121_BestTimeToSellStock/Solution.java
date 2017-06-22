package DP._No121_BestTimeToSellStock;

/**
 * int maxProfit(vector<int> &prices) {
 int maxPro = 0;
 int minPrice = INT_MAX;
 for(int i = 0; i < prices.size(); i++){
 minPrice = min(minPrice, prices[i]);
 maxPro = max(maxPro, prices[i] - minPrice);
 }
 return maxPro;
 }
 minPrice is the minimum price from day 0 to day i. And maxPro is the maximum profit we can get from day 0 to day i.

 How to get maxPro? Just get the larger one between current maxPro and prices[i] - minPrice.

 */
public class Solution {

    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minPrice);
        }
        return maxPro;
    }

}
