import java.util.*;

class MaximumProfit {

    public long maximumProfit(int[] prices, int k) {

        int n = prices.length;

        long[][] dp = new long[k + 1][n];

        for (int t = 1; t <= k; t++) {

            long bestBuy = -prices[0];
            long bestShort = prices[0];

            for (int d = 1; d < n; d++) {

                dp[t][d] = dp[t][d - 1];

                // Normal transaction
                dp[t][d] = Math.max(dp[t][d],
                        prices[d] + bestBuy);

                // Short selling transaction
                dp[t][d] = Math.max(dp[t][d],
                        bestShort - prices[d]);

                // Update best states
                bestBuy = Math.max(bestBuy,
                        dp[t - 1][d - 1] - prices[d]);

                bestShort = Math.max(bestShort,
                        dp[t - 1][d - 1] + prices[d]);
            }
        }

        return dp[k][n - 1];
    }

    public static void main(String[] args) {

        MaximumProfit obj = new MaximumProfit();

        int[] prices = {1, 7, 9, 8, 2};
        int k = 2;

        System.out.println(obj.maximumProfit(prices, k));
    }
}