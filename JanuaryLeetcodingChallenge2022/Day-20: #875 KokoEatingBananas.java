class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
//         Approach-1: gives TLE but provides a very useful insight:- 1 <= k <= max
//         Time: O(N^2)
        
        // int max = getMaxElement(piles);
        // for(int k=1; k<=max; k++){       //max = 10^9 in worst case!
        //     long curr_h = 0;
        //     for(int i=0; i<piles.length; i++){   //O(N) i.e. 10^9 iterations!
        //         int q = piles[i]/k;
        //         int r = piles[i]%k;
        //         curr_h += q;
        //         if(r != 0)
        //             curr_h += 1;
        //     }
        //     if(curr_h <= h)
        //         return k;
        // }
        // return -1;
        
        
        
//         Approach-2: ACCEPTED | Time: O(N) + O(logN * N) ~ O(logN * N) | Binary Search
        
//         int max = getMaxElement(piles);
        
//         int ans = -1;
        
//         int start = 1;
//         int end = max;
        
//         while(start <= end){
            
//             int k = start + (end - start)/2;
            
//             long curr_h = 0;
//             for(int i=0; i<piles.length; i++){
//                 int q = piles[i]/k;
//                 int r = piles[i]%k;
//                 curr_h += q;
//                 if(r != 0)
//                     curr_h += 1;
//             }
//             if(curr_h > h){
//                 start = k+1;
//             } else{
//                 ans = k;
//                 end = k-1;
//             }
//         }
//         return ans;
        
        
        
        
//         Approach-3: ACCEPTED | Time: O(logN * N) | Binary Search
//         A little bit better than Approach-2
        
        
        // int max = getMaxElement(piles);
        
        int ans = -1;
        
        int start = 1;
        int end = Integer.MAX_VALUE;
        
        while(start <= end){
            
            int k = start + (end - start)/2;
            
            long curr_h = 0;
            for(int i=0; i<piles.length; i++){
                int q = piles[i]/k;
                int r = piles[i]%k;
                curr_h += q;
                if(r != 0)
                    curr_h += 1;
            }
            if(curr_h > h){
                start = k+1;
            } else{
                ans = k;
                end = k-1;
            }
        }
        return ans;
    }
    int getMaxElement(int[] piles){
        int max = piles[0];
        for(int i=1; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }
}
