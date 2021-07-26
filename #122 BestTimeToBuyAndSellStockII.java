import java.util.Collections;
class Solution {
    public int maxProfit(int[] prices) {
        
        // return maxProfit(prices, 0);
        // return maxProfitDP(prices);
        
//         Peak-Valley approach:
        
//         int i = 
        
    }
    
    
    // public static int maxProfit(int[] prices, int start, int[] storage){
        
//         int n = prices.length;
        
//         if(start >= n || start == n-1) return 0;
        
//         int ans = 0;
        
//         for(int i=start; i<n; i++){
//             int buyingCost = prices[i];
//             for(int j=i+1; j<n; j++){
//                 int sa = (prices[j] - buyingCost) + maxProfit(prices, j+1);
//                 ans = Math.max(ans, sa);
//             }
//         }
//         return ans;
        
    // }
    
    // public static int maxProfitDP(int[] prices){
    //     int n = prices.length;
    //     Integer[] storage = new Integer[n];
    //     storage[n-1] = 0;
    //     for(int i=n-2; i>=0; i--){
    //         int maxProfit = storage[i+1];
    //         for(int j=i+1; j<n; j++){
    //             int profit = prices[j] - prices[i];
    //             if((j+1) < n){
    //                 profit += storage[j+1];
    //             }
    //             maxProfit = Math.max(maxProfit, profit);
    //         }
    //         storage[i] = maxProfit;
    //     }
    //     return storage[0];
    // }
    
}
