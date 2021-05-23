class Solution {
    public String minWindow(String s, String t) {
        
//         Approach-1: Brute Force (gives TLE) [O(M*M*N*M) ~ O(N^4)]
        
//         int min = Integer.MAX_VALUE;
//         String ans = "";
        
//         for(int i=0; i<s.length(); i++){
            
//             for(int j=i+t.length()-1; j<s.length(); j++){
                
//                 String sub = s.substring(i, j+1);
//                 if(contains(sub, t)){
//                     // min = Math.min(min, sub.length());
//                     // ans = sub;
                    
//                     if(min > sub.length()){
//                         min = sub.length();
//                         ans = sub;
//                     }
                    
//                 }
                
//             }
            
//         }
//         return ans;
        
        
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
//         Pushing all chars in 't' into hashmap with value as their frequency
        for(int i=0; i<t.length(); i++){
            if(!hm.containsKey(t.charAt(i))){
                hm.put(t.charAt(i), 1);
            }
            else{
                hm.put(t.charAt(i), hm.get(t.charAt(i)) + 1);
            }
        }
        
        String ans = "";
        int count = hm.size();  // keeps track of the no. of chars that we still need to find
        
        int j=0;
        
        for(int i=0; i<s.length(); i++){
            
            // for(int j=0; (count != 0) && (j<s.length()); j++){
            while((count != 0) && (j<s.length())){
                if(hm.containsKey(s.charAt(j))){
                    if(hm.get(s.charAt(j)) > 1){
                        hm.put(s.charAt(j), hm.get(s.charAt(j)) - 1);
                    }
                    else if(hm.get(s.charAt(j)) == 1){
                        hm.put(s.charAt(j), hm.get(s.charAt(j)) - 1);
                        count--;
                        // if(count == 0)
                        //     break;
                    }
                    else{
                        hm.put(s.charAt(j), hm.get(s.charAt(j)) - 1);
                    }
                }
                j++;
            }
            if(count == 0){
                // j--;
                if(ans.length() == 0 || ans.length() > s.substring(i, j).length()){
                    ans = s.substring(i, j);
                }
                
                // if(!hm.containsKey(s.charAt(i))){
                //     i++;
                // }
            }
            
            if(hm.containsKey(s.charAt(i))){
                if(hm.get(s.charAt(i)) >= 0){
                    count++;
                }
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            }
            
        }
        return ans;
    }
    
//     public static boolean contains(String s, String t){
        
//         boolean[] visited = new boolean[s.length()];
        
//         for(int i=0; i<t.length(); i++){
//             int j=0;
//             for(; j<s.length(); j++){
                
//                 if(!visited[j] && s.charAt(j) == t.charAt(i)){
//                     visited[j] = true;
//                     break;
//                 }
                
//             }
            
//             if(j == s.length())
//                 return false;
//         }
//         return true;
        
//     }
    
}
