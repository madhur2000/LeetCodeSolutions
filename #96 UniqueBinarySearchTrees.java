class Solution {
    public int numTrees(int n) {
        // if(n == 0)
        //     return 1;
        // int ans = 0;
        // for(int i=1; i<=n; i++){
        //     ans += (numTrees(i-1) * numTrees(n-i));
        // }
        // return ans;
        
        int[] storage = new int[n+1];
        storage[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                storage[i] += storage[j-1] * storage[i-j];
            }
        }
        return storage[n];
    }
}
