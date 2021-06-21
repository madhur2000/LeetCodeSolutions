import java.util.Map.Entry;
class Solution {
    public int longestSubstring(String s, int k) {
        
//         Approach-1: Brute Force | Time: O(N^3) | space = O(N)
        
        
//         // String ans = "";
//         int ans = 0;
//         for(int i=0; i<s.length(); i++){
//             for(int j=i+1; j<=s.length(); j++){
//                 String curr = s.substring(i, j);
//                 HashMap<Character, Integer> hm = getFrequencies(curr);
                
//                 // Colection<Integer> frequencies = hm.values();
//                 Set<Entry<Character, Integer>> entries = hm.entrySet();
//                 boolean possibleAns = true;
//                 for(Entry<Character, Integer> entry : entries){
//                     if(entry.getValue() < k){
//                         possibleAns = false;
//                         break;
//                     }
//                 }
//                 if(possibleAns){
//                     if(ans < curr.length()){
//                         ans = curr.length();
//                     }
//                 }
//             }
//         }
//         return ans;
        
        
        
//         Approach-2: Brute Force | Recurtsive
        
//         Map<Character, Integer> hm = new HashMap<>();
//         for(int i=0; i<s.length(); i++){
//             if(!hm.containsKey(s.charAt(i))){
//                 hm.put(s.charAt(i), 1);
//             }
//             else{
//                 hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
//             }
//         }
        
//         boolean s_is_ans = check(hm, k);
        
//         if(s_is_ans){
//             return s.length();
//         }
        
//         int smallAns1 = longestSubstring(s.substring(1), k);
//         int smallAns2 = longestSubstring(s.substring(0, s.length() - 1), k);
        
//         return Math.max(smallAns1, smallAns2);
        
        
        
//         Approach-3: Top - down DP
        
        // int[][] storage = new int[s.length()][s.length()];
        // for(int[] arr : storage){
        //     Arrays.fill(arr, -1);
        // }
        
        // return longestSubstringM(s, 0, s.length()-1, k, storage);
        
        
//         Approach-4: Bottom - up DP
//         int[][] storage = new int[s.length()][s.length()];
        
//         if(k == 1){
//             for(int i=0; i<storage.length; i++){
//                 storage[i][i] = 1;
//             }
//         } else{
//             for(int i=0; i<storage.length; i++){
//                 storage[i][i] = 0;
//             }
//         }
        
//         for(int n=1; n<storage.length; n++){
//             for(int i=0; (i+n)<storage.length; i++){
                
//                 Map<Character, Integer> hm = new HashMap<>();
//                 String sub = s.substring(i, i+n+1);
//                 for(int m=0; m<sub.length(); m++){
//                     if(!hm.containsKey(sub.charAt(m))){
//                         hm.put(sub.charAt(m), 1);
//                     }
//                     else{
//                         hm.put(sub.charAt(m), hm.get(sub.charAt(m)) + 1);
//                     }
//                 }
                
//                 if(check(hm, k)){
//                     storage[i][i+n] = i+n-i+1;
//                 }
//                 else{
//                     storage[i][i+n] = Math.max(storage[i][i+n-1], storage[i+1][i+n]);
//                 }
//             }
//         }
        
//         return storage[0][s.length()-1];
        
//         Approach-6: ACCEPTED | https://www.youtube.com/watch?v=bHZkCAcj3dc 
        
        if(k == 1) return s.length();
        
        if(s.length() < k) return 0;
        
        Map<Character, Integer> hm = new HashMap<>();
        
        Set obstacles = new HashSet<>();
        
        for(int i=0; i<s.length(); i++){
            if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i), 1);
            }
            else{
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            }
        }
        
        Set<Character> charSet = hm.keySet();
        
        for(Character c : charSet){
            if(hm.get(c) < k){
                obstacles.add(c);
            }
        }
        
        for(int i=0; i<s.length(); i++){
            if(obstacles.contains(s.charAt(i))){
                int sa1 = longestSubstring(s.substring(0, i), k);
                while(i < s.length() && obstacles.contains(s.charAt(i))){
                    i++;
                }
                
                int sa2 = 0;
                if(i < s.length()){
                    sa2 = longestSubstring(s.substring(i), k);
                }
                return Math.max(sa1, sa2);
            }
        }
        
        return s.length();
    }
    
    
    
//     public static int longestSubstringM(String s, int start, int end, int k, int[][] storage){
        
//         if(storage[start][end] != -1) return storage[start][end];
        
//         Map<Character, Integer> hm = new HashMap<>();
        
//         for(int i=start; i<=end; i++){
//             if(!hm.containsKey(s.charAt(i))){
//                 hm.put(s.charAt(i), 1);
//             }
//             else{
//                 hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
//             }
//         }
        
//         boolean s_is_ans = check(hm, k);
        
//         if(s_is_ans){
//             storage[start][end] = end-start+1;
//             return storage[start][end];
//         }
        
//         int smallAns1 = 0;
//         int smallAns2 = 0;
        
//         if(start+1 < s.length()){
//             smallAns1 = longestSubstringM(s, start+1, end, k, storage);
//         }
        
//         if(end-1 >= 0){
//             smallAns2 = longestSubstringM(s, start, end-1, k, storage);
//         }
//         storage[start][end] = Math.max(smallAns1, smallAns2);
        
//         return storage[start][end];
        
//     }
    
    
    /* public static boolean check(Map<Character, Integer> hm, int k){
        
        Set<Entry<Character, Integer>> entries = hm.entrySet();        
        for(Entry<Character, Integer> entry : entries){
            if(entry.getValue() < k){
                return false;
            }
        }
        return true;
    } */
    
    
    // public static HashMap<Character, Integer> getFrequencies(String s){
    //     HashMap<Character, Integer> hm = new HashMap<>();
    //     for(int i=0; i<s.length(); i++){
    //         if(!hm.containsKey(s.charAt(i))){
    //             hm.put(s.charAt(i), 1);
    //         }
    //         else{
    //             hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
    //         }
    //     }
    //     return hm;
    // }
    
}
