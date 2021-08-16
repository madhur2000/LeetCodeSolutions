class Solution {
    public String convertToBase7(int num) {
        
        if(num == 0)
            return "0";
        
        int i=0;
        
        boolean isNegative = false;
        if(num < 0){
            isNegative = true;
            num = 0 - num;
        }
        
        // String ans_string = "";
        StringBuilder ans_string = new StringBuilder("");
        
        while(num != 0){
            // ans_string = num%7 + ans_string;
            ans_string.insert(0, num%7);
            num /= 7;
        }
        
        if(isNegative){
            // ans_string = "-" + ans_string;
            ans_string.insert(0, "-");
        }
        
        return ans_string.toString();
    }
}
