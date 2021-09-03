class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
//         Approach-1: Recursive Solution
        
//         if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
//             return true;
//         if(s3.length() == 0)
//             return false;
//         if(s1.length() == 0 && s2.length() == 0)
//             return false;
//         if(s1.length() == 0){
//             if(s2.charAt(0) == s3.charAt(0)){
//                 return isInterleave(s1, s2.substring(1), s3.substring(1));
//             }
//             return false;
//         }
//         if(s2.length() == 0){
//             if(s1.charAt(0) == s3.charAt(0)){
//                 return isInterleave(s1.substring(1), s2, s3.substring(1));
//             }
//             return false;
//         }
//         if(s1.charAt(0) == s3.charAt(0)
//             && s2.charAt(0) == s3.charAt(0))
//             return (isInterleave(s1.substring(1), s2, s3.substring(1)) 
//                         || isInterleave(s1, s2.substring(1), s3.substring(1)));
//         if(s1.charAt(0) == s3.charAt(0)){
//             return isInterleave(s1.substring(1), s2, s3.substring(1));
//         }
//         if(s2.charAt(0) == s3.charAt(0))
//             return isInterleave(s1, s2.substring(1), s3.substring(1));
        
//         return false;
        
        
//         Approach-2: DP (bottom - up)
        
        if(s1.length() + s2.length() != s3.length())
            return false;
        
        boolean[][] storage = new boolean[s1.length()+1][s2.length()+1];
        storage[0][0] = true;
        
        for(int i=1; i<storage[0].length; i++){
            storage[0][i] = (storage[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1));
        }
        
        for(int i=1; i<storage.length; i++){
            storage[i][0] = (storage[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1));
        }
        
        for(int i=1; i<storage.length; i++){
            for(int j=1; j<storage[0].length; j++){
                if(storage[i][j-1] == true
                    && s2.charAt(j-1) == s3.charAt(i+j-1)){
                    storage[i][j] = true;
                }
                else if(storage[i-1][j] == true
                        && s1.charAt(i-1) == s3.charAt(i+j-1)){
                    storage[i][j] = true;
                }
                else{
                    storage[i][j] = false;
                }
            }
        }
        return storage[s1.length()][s2.length()];
    }
}
