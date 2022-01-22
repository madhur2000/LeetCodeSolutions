class Solution {
    public boolean winnerSquareGame(int n) {
        
//         Approach-1: Recursion | gives TLE
        
//         if(n == 0)
//             return false;
        
//         for(int i=1; (i*i)<=n; i++){
//             if(!winnerSquareGame(n-(i*i)))
//                 return true;
//         }
        
//         return false;
        
        if(n == 0)
            return false;
        if(n == 1)
            return true;
        
        boolean[] currentStateResult = new boolean[n+1];
        
        currentStateResult[0] = false;
        currentStateResult[1] = true;
        
        for(int i=2; i<=n; i++){
            for(int j=1; (j*j)<=i; j++){
                if(!currentStateResult[i-(j*j)]){
                    currentStateResult[i] = true;
                    break;
                }
                // else
                //     currentStateResult[i] = false;
            }
        }
        return currentStateResult[n];
    }
}
