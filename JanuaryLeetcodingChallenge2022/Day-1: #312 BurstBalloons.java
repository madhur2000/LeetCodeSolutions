class Solution {
    public int maxCoins(int[] nums) {
        
//         Approach-1: Recursion | Time: O(N*N!)
        
        // int maxCoins = 0;
        // for(int i=0; i<nums.length; i++){
        //     int[] newNums = getNewNums(nums, i);
        //     int currCoins = nums[i];
        //     if((i-1) >= 0){
        //         currCoins = currCoins * nums[i-1];
        //     }
        //     if((i+1) < nums.length){
        //         currCoins = currCoins * nums[i+1];
        //     }
        //     int remainingCoins = maxCoins(newNums);
        //     currCoins += remainingCoins;
        //     maxCoins = Math.max(maxCoins, currCoins);
        // }
        // return maxCoins;
        
        
        
        
//         Approach-2: DP
        
        int n = nums.length;
        int[][] storage = new int[n][n];
        // int maxCoins = 0;
        
        for(int winSize=1; winSize<=n; winSize++){
            for(int i=0; (i+winSize-1)<n; i++){
                int start = i;
                int end = i+winSize-1;
                for(int k=start; k<=end; k++){
                    int leftCoins=0, currCoins=nums[k], rightCoins=0;
                    if((k-1) >= start)
                        leftCoins = storage[start][k-1];
                    if((k+1) <= end)
                        rightCoins = storage[k+1][end];
                    if((start-1) >= 0)
                        currCoins *= nums[start-1];
                    if((end+1) < nums.length)
                        currCoins *= nums[end+1];
                    storage[start][end] = Math.max(storage[start][end], leftCoins + currCoins + rightCoins);
                }
            }
        }
        
        
        // printMatrix(storage);
        
        
        return storage[0][n-1];
        
    }
    
    void printMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    // private int[] getNewNums(int[] nums, int i){
    //     int[] newNums = new int[nums.length-1];
    //     int index = 0;
    //     for(int j=0; j<nums.length; j++){
    //         if(j != i){
    //             newNums[index++] = nums[j];
    //         }
    //     }
    //     return newNums;
    // }
}
