class Solution {
    public boolean isPowerOfThree(int n) {
        
//         Approach-1:
//         long y=1;
        
//         while(y < n){
//             y = y * 3;
//         }
//         if(y > n)
//             return false;
//         return true;
        
        
//         Approach-2:
        
        if(n <= 0)
            return false;
        
        while(n%3 == 0){
            n /= 3;
        }
        
        return (n == 1);
        
    }
}
