class Solution {
    public String addStrings(String num1, String num2) {
        
        StringBuilder ans = new StringBuilder("");
        
        int i = num1.length()-1;
        int j = num2.length()-1;
        
        int carry = 0;
        
        while(i >= 0 || j >= 0 || carry != 0){
            
            int a=0, b=0, c=0;
            
            if(i >= 0){
                a = num1.charAt(i) - '0';
            }
            if(j >= 0){
                b = num2.charAt(j) - '0';
            }
            
            c = a + b + carry;
            // ans = c%10 + ans;
            ans.insert(0, c%10);
            carry = c/10;
            i--;
            j--;
        }
        
        return ans.toString();
    }
}
