class Solution {
    public int firstUniqChar(String s) {
        // Approach-1: Brute Force
        // int n = s.length();
        // for(int i=0; i<n; i++){
        //     boolean found = true;
        //     for(int j=0; j<n; j++){
        //         if(j == i)
        //             continue;
        //         if(s.charAt(i) == s.charAt(j)){
        //             found = false;
        //             break;
        //         }
        //     }
        //     if(found)
        //         return i;
        // }
        // return -1;
        
//         Approach-2: HashMap | time: O(N) | space: O(1)
        
        int n = s.length();
        Map<Character, Integer> counts = new HashMap<>();
        for(int i=0; i<n; i++){
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0)+1);
        }
        
        for(int i=0; i<n; i++){
            if(counts.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
