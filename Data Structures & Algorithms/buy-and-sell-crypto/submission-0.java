class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minSoFar = Integer.MAX_VALUE;
        for (int price : prices) {
            maxProfit = Math.max(price - minSoFar, maxProfit);
            minSoFar = Math.min(price, minSoFar);
        }
        return maxProfit;
    }
}
