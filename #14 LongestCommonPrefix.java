class Solution {
    public String longestCommonPrefix(String[] strs) {
        
//         Approach-1: O(N^2) | Accepted | runtime: 9ms
        
//         String output = "";
        
//         int n = strs.length;
        
//         for(int i=0; i<strs[0].length(); i++){
//             char c = strs[0].charAt(i);
//             boolean isSame = true;
//             for(int j=1; j<n; j++){
//                 if(i >= strs[j].length() || strs[j].charAt(i) != c){
//                     isSame = false;
//                     break;
//                 }
//             }
//             if(isSame){
//                 output += c;
//             }
//             else
//                 break;
//         }
//         return output;
        
        if(strs.length == 0) return "";
        
        String lcp = strs[0];
        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(lcp) != 0){
                lcp = lcp.substring(0, lcp.length()-1);
            }
        }
        
        return lcp;
        
    }
}
