class Solution {
    public boolean isAnagram(String s, String t) {
//         Approach-1: Sorting | (Accepted) | time: O(Nlog(N)) | space: O(N)
        
//         char[] s_array = s.toCharArray();
//         char[] t_array = t.toCharArray();
        
//         Arrays.sort(s_array);
//         Arrays.sort(t_array);
        
//         String s2 = new String(s_array);
//         String t2 = new String(t_array);
        
//         return s2.equals(t2);
        
//         Approach-2: char counts | Resource: Nick White (YouTube) | time: O(N) | space: O(1)

        if(s.length() != t.length())
            return false;
        
        int n = s.length();
        
        int[] charCounts = new int[26];
        for(int i=0; i<n; i++){
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }
        
        for(int i=0; i<charCounts.length; i++){
            if(charCounts[i] != 0)
                return false;
        }
        return true;
        
    }
}
