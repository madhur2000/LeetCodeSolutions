class Solution {
    public int strStr(String haystack, String needle) {
        
        for(int i=0; (i+needle.length())<=haystack.length(); i++){
            
            String currentSubstring = haystack.substring(i, i+needle.length());
            
            if(currentSubstring.equals(needle)){
                return i;
            }
            
        }
        return -1;
        
    }
}
