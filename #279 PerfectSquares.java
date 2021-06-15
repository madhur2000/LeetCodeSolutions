class Solution {
    public int numSquares(int n) {
        
//         Approach-1: Recursion
        
        // int ans = n;
        // for(int i=1; (n - (i * i)) >= 0; i++){
        //     int sa = numSquares(n-(i*i));
        //     ans = Math.min(ans, 1+sa);
        // }
        // return ans;
        
        
//         Approach-2: Top-down DP
        
        // int[] storage = new int[n+1];
        // Arrays.fill(storage, -1);
        // return numSquares(n, storage);
        
        
//         Approach-3: Bottom-Up DP
        
        int[] storage = new int[n+1];
        
        for(int i=0; i<storage.length; i++){
            storage[i] = i;
        }
        
        
        for(int i=2; i<=n; i++){
            for(int j=1; (i-(j*j))>=0; j++){
                storage[i] = Math.min(storage[i], 1 + storage[i-(j*j)]);
            }
        }
        
        return storage[n];
    }
    
//     public static int numSquares(int n, int[] storage){
        
//         if(storage[n] != -1)
//             return storage[n];
        
//         int ans = n;
//         for(int i=1; (n - (i * i)) >= 0; i++){
//             int sa = numSquares(n-(i*i), storage);
//             storage[n-(i*i)] = sa;
//             ans = Math.min(ans, 1+sa);
//         }
        
//         storage[n] = ans;
//         return ans;
//     }
    
}
