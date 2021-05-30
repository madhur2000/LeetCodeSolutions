class Solution {
    public boolean isPalindrome(String s) {
        
        // s = s.replaceAll("[^a-zA-Z0-9]", "");
        
        // s = s.toLowerCase();
        
        // StringBuffer sbr = new StringBuffer(s);
        
//         sbr.reverse();
        
//         return s.equals(sbr.toString());
        
        return helper(s);
        
        
    }
    
    public static boolean helper(String s){
        
        int n = s.length();
        
        int i = 0, j = n-1;
        
        while(i < j){
            
            if((Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))
                && (Character.isDigit(s.charAt(j)) || Character.isLetter(s.charAt(j)))){
                if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                    i++;
                    j--;
                }
                else{
                    
                    System.out.println(s.charAt(i) + " " + s.charAt(j));
                    
                    return false;
                }
            }
            else{
                if(!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i)))
                    i++;

                if(!Character.isDigit(s.charAt(j)) && !Character.isLetter(s.charAt(j)))
                    j--;
            }
            
            
        }
        
        return true;
        
    }
    
}
