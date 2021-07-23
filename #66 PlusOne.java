class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        int[] digitsPlusOne = new int[n];
        
        int carry = 0;
        int x = digits[n-1] + 1;
        
        digitsPlusOne[n-1] = x%10;
        carry = x/10;
        
        int i = n-2;
        
        while(i >= 0){
            x = carry + digits[i];
            digitsPlusOne[i] = x%10;
            carry = x/10;
            i--;
        }
        
        if(carry != 0){
            int[] ans = new int[n+1];
            ans[0] = carry;
            for(int k=1; k<n+1; k++){
                ans[k] = digitsPlusOne[k-1];
            }
            return ans;
        }
        return digitsPlusOne;
    }
}
