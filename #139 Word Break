class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int[][] storage = new int[s.length()][s.length()];
        
        for(int i=0; i<storage.length; i++){
            for(int j=0; j<storage.length; j++){
                storage[i][j] = -1;
            }
        }
        
        return helper(s, wordDict, storage);
        
        
    }
    
    
    public static boolean helper(String s, List<String> wordDict, int[][] storage){
        
        if(wordDict.contains(s))
            return true;
        
        if(storage[0][s.length()-1] != -1)
            return (storage[0][s.length()-1] == 1);
        
        boolean ans = false;
        
        for(int i=1; i<s.length(); i++){
            if(wordDict.contains(s.substring(i))){
                int sa = (helper(s.substring(0, i), wordDict, storage) ? 1 : 0);
                storage[0][i-1] = sa;
                if(sa == 1){
                    storage[0][s.length()-1] = 1;
                    return (storage[0][s.length()-1] == 1);
                }
            }
        }
        
        storage[0][s.length()-1] = 0;
        return (storage[0][s.length()-1] == 1);
        
    }
    
}
