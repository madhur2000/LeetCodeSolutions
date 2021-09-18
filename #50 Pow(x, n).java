class Solution {
    public double myPow(double x, int n) {
        
//         Approach-1: TLE
        
//         boolean isNegative = false;
        
//         if(n < 0){
//             isNegative = true;
//             n = 0 - n;
//         }
        
//         double ans = 1;
//         for(int i=0; i<n; i++){
//             ans = ans * x;
//         }
        
//         if(isNegative)
//             ans = 1/ans;
//         return ans;
        
//         Approach-2:
        
        boolean isNegative = false;
        
        if(n < 0){
            isNegative = true;
            n = 0 - n;
        }
        
        double ans = calculatePower(x, n);
        
        if(isNegative)
            ans = 1/ans;
        
        return ans;
    }
    
    static double calculatePower(double x, int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        double sa = calculatePower(x, n/2);
        
        if((n&1) == 0)
            return (sa*sa);
        
        return (x*sa*sa);
    }
    
}
