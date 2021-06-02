class Solution {
    public int maxProfit(int[] prices) {
        
//         Approach-1: Brute force (recursive)
        // if(prices == null)
        //     return 0;
        // return helper(prices, 0, prices.length-1);
        
        
//         Approach-2: One Pass
        
        int maxProfit = 0;
        
        if(prices == null || prices.length == 0)
            return 0;
        int min = prices[0], max = prices[0];
        
        for(int i=0; i<prices.length; i++){
            
            if(min > prices[i]){
                
                maxProfit = Math.max(maxProfit, (max-min));
                
                min = prices[i];
                max = prices[i];
            }
            if(max < prices[i]){
                max = prices[i];
                maxProfit = Math.max(maxProfit, (max-min));
            }
            
        }
        return maxProfit;
        
    }
    
//     public int helper(int[] prices, int start, int end){
        
//         if(start > end || start == end)
//             return 0;
        
//         int smallAns = helper(prices, start+1, end);
        
//         int greater = prices[start];
        
//         for(int i=start+1; i<prices.length; i++){
//             greater = Math.max(greater, prices[i]);
//         }
//         return Math.max((greater-prices[start]), smallAns);
//     }
    
}






// Revision Session:

// class Solution {
//     public int maxProfit(int[] prices) {
//         if(prices == null || prices.length == 0)
//             return 0;
        
//         int min = prices[0], max = prices[0];
//         int ans = 0;
        
//         for(int i=1; i<prices.length; i++){
//             if(prices[i] < min){
//                 ans = Math.max(ans, max-min);
//                 min = prices[i];
//                 max = prices[i];
//             }
//             else if(prices[i] > max){
//                 max = prices[i];
//             }
//         }
//         return Math.max(ans, max-min);
//     }
// }













