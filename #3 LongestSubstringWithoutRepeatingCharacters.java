class Solution {
    public int lengthOfLongestSubstring(String s) {
        
//         Approach-1: Iterative:
//         int ans = 0;
        
//         for(int i=0; i<s.length(); i++){
//             for(int j=i+1; j<=s.length(); j++){
//                 String sub = s.substring(i, j);
//                 if(containsAllDistinctChars(sub)){
                    
//                     if(ans < sub.length())
//                         ans = sub.length();
                    
//                 }
//             }
//         }
//         return ans;
        
//         if(containsAllDistinctChars(s)){
//             return s.length();
//         }
        
//         int sa1 = lengthOfLongestSubstring(s.substring(1));
//         int sa2 = lengthOfLongestSubstring(s.substring(0, s.length()-1));
        
//         return Math.max(sa1, sa2);
        
        
//         Approach-2: Memoization:
//         int[][] storage = new int[s.length()][s.length()];
//         return helper(s, 0, s.length()-1, storage);
        
        
//         Approach-3: DP(NOT WORKING)
//         int[][] storage = new int[s.length()][s.length()];
        
//         for(int i=0; i<s.length(); i++){
            
//             for(int j=0; j<s.length(); j++){
//                 if(i+j+1 < s.length())
//                     storage[j][i+j+1] = Math.max(storage[j][j+i], storage[j+1][j+1+i]);
//             }
            
//         }
//         return storage[0][s.length()-1];
        
        
        
//         Approach-4: Sliding Window
        
        int i = 0;
        int j = 0;
        
        int max = 0;
        
        HashSet<Character> hs = new HashSet<>();
        
        while(j<s.length()){
            if(!hs.contains(s.charAt(j))){
                hs.add(s.charAt(j));
                j++;
            }
            else{   //hs.contains(s.charAt(j))
                
                max = Math.max(max, hs.size());
                hs.remove(s.charAt(i));
                i++;
            }
        }
        
        max = Math.max(max, hs.size());
        
        return max;
        
    }
    
    public static int helper(String s, int start, int end, int[][] storage){
        
        if(start > end)
            return 0;
        if(start == end){
            storage[start][end] = 1;
            return storage[start][end];
        }
        
        if(containsAllDistinctChars(s.substring(start, end+1))){
            storage[start][end] = s.substring(start, end+1).length();
            return storage[start][end];
        }
        
        if(storage[start][end] != 0)
            return storage[start][end];
        
        int sa1 = helper(s, start+1, end, storage);
        storage[start+1][end] = sa1;
        
        int sa2 = helper(s, start, end-1, storage);
        storage[start][end-1] = sa2;
        
        storage[start][end] = Math.max(sa1, sa2);
        return storage[start][end];
        
    }
    
    
    public static boolean containsAllDistinctChars(String s){
        
        HashSet<Character> hs = new HashSet<>();
        
        for(int i=0; i<s.length(); i++){
            hs.add(s.charAt(i));
        }
        
        if(hs.size() == s.length()){
            return true;
        }
        return false;
        
    }
    
}
