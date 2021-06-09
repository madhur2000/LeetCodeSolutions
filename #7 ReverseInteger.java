import java.math.BigInteger;
class Solution {
    public int reverse(int x) {
        
        if(x == 0)
            return 0;
        
        String s = Integer.toString(x);
        
        boolean isNegative = false;
        
        if(s.charAt(0) == '-'){
            
            isNegative = true;
            s = s.substring(1);
            
        }
        
        int index = s.length() - 1;
        
        while(index >= 0 && s.charAt(index) == '0'){
            index--;
        }
        
        s = s.substring(0, index + 1);
        
        StringBuilder sb = new StringBuilder(s);
        
        sb.reverse();
        
        String ansString = "";
        
        if(isNegative){
            ansString = "-" + sb.toString();
        }
        else{
            ansString = sb.toString();
        }
        
        BigInteger bi = new BigInteger(ansString);
        BigInteger max = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        BigInteger min = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        
        if(bi.compareTo(max) > 0
            || bi.compareTo(min) < 0){
            
            return 0;
            
        }
        return Integer.parseInt(bi.toString());
    }
}
