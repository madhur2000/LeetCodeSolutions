class Pair{
    String s;
    int index = -1;
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
//         Approach-1: Sorting every String | (Accepted) | time: O(N^2); space: O(N)
        
//         int n = strs.length;
//         Set<String> hs = new HashSet<>();
        
//         List<List<String>> ans = new ArrayList<>();
        
//         String[] strs2 = new String[n];
        
//         for(int i=0; i<n; i++){
//             char[] temp = strs[i].toCharArray();
//             Arrays.sort(temp);
//             strs2[i] = new String(temp);
//         }
        
//         for(int i=0; i<n; i++){
//             if(!hs.contains(strs2[i])){
//                 hs.add(strs2[i]);
//                 String temp = strs2[i];
//                 List<String> sa = new ArrayList<>();
//                 sa.add(strs[i]);
                
//                 for(int j=i+1; j<n; j++){
//                     if(strs2[j].equals(temp)){
//                         sa.add(strs[j]);
//                     }
//                 }
//                 ans.add(sa);
//             }
//         }
//         return ans;
        
        
//         Approach-2: sorting each word then sorting the whole array | Time: O(NlogN) | Space: O(N)
        
//         int n = strs.length;
        
//         List<List<String>> ans = new ArrayList<>();
        
//         Pair[] strs2 = new Pair[n];
        
//         for(int i=0; i<n; i++){
//             char[] temp = strs[i].toCharArray();
//             Arrays.sort(temp);
            
//             Pair pair = new Pair();
//             pair.s = new String(temp);
//             pair.index = i;
            
//             strs2[i] = pair;
            
//             // strs2[i].s = new String(temp);
//             // strs2[i].index = i;
//         }
        
//         Arrays.sort(strs2, new Comparator<Pair>(){
            
//             public int compare(Pair p1, Pair p2){
//                 return p1.s.compareTo(p2.s);
//             }
            
//         });
        
//         int i, j;
        
//         for(i=0; i<n; ){
//             List<String> sa = new ArrayList<>();
//             for(j=i; j<n; j++){
//                 if(strs2[i].s.equals(strs2[j].s)){
//                     sa.add(strs[strs2[j].index]);
//                 }
//                 else
//                     break;
//             }
//             ans.add(sa);
//             i = j;
//         }
//         return ans;
        
        
//         Approach-3: using approach used in Valid Anagrams Question i.e. charCounts | gives TLE | time: O(N^2) (not sure, it appears like: N * N * 26 in worst case which O(N^2) i think)
        
        
        /*
        * The Worst Approach
        */
        
//         Set<String> hs = new HashSet<>();
        
//         List<List<String>> ans = new ArrayList<>();
//         for(int i=0; i<strs.length; i++){
//             List<String> sa = new ArrayList<>();
            
//             if(hs.contains(strs[i]))
//                 continue;
            
//             sa.add(strs[i]);
//             hs.add(strs[i]);
            
//             int[] charCounts1 = new int[26];
            
//             for(int j=0; j<strs[i].length(); j++){
//                 charCounts1[strs[i].charAt(j) - 'a']++;
//             }
            
//             for(int k=i+1; k<strs.length; k++){
//                 int[] charCounts2 = new int[26];
                
//                 for(int l=0; l<strs[k].length(); l++){
//                     charCounts2[strs[k].charAt(l) - 'a']++;
//                 }
//                 if(areEqual(charCounts1, charCounts2)){
//                     sa.add(strs[k]);
//                     hs.add(strs[k]);
//                 }
//             }
//             ans.add(sa);
//         }
//         return ans;
        
//         Approach-4: Very good use of HashMap | time: O(N) | Apni Kaksha YouTube
        
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for(String s : strs){
//             char[] temp = s.toCharArray();
//             Arrays.sort(temp);
//             String sorted_s = new String(temp);
            
            int[] charCounts = new int[26];
            String sorted_s = "";
            
            for(int i=0; i<s.length(); i++){
                charCounts[s.charAt(i) - 'a']++;
            }
            
            for(int i=0; i<charCounts.length; i++){
                if(charCounts[i] != 0){
                    char ch = (char)(i + 'a');
                    while(charCounts[i]-- > 0){
                        sorted_s += ch;
                    }
                }
            }
            
            if(!hm.containsKey(sorted_s)){
                hm.put(sorted_s, new ArrayList<>(Arrays.asList(s)));
            }
            else{
                hm.get(sorted_s).add(s);
            }
        }
        return new ArrayList<>(hm.values());
    }
    
//     public static boolean areEqual(int[] a1, int[] a2){
//         for(int i=0; i<26; i++){
            
//             if(a1[i] != a2[i])
//                 return false;
            
//         }
//         return true;
//     }
    
}
