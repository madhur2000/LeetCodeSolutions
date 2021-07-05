class Solution {
    public int reverse(int x) {
        
//         boolean isNegative = false;
        
//         if(x < 0){
//             x = 0 - x;
//             isNegative = true;
//         }
        
        int rev = 0;
        int prevRev = 0;
        
        while(x != 0){
            rev = rev * 10 + x%10;
            
            // System.out.println(x%10);
            
            if((rev - x%10)/10 != prevRev)
                return 0;
            
            prevRev = rev;
            x /= 10;
        }
        
        // return isNegative ? (0 - rev) : rev;
        
        return rev;
        
    }
}
