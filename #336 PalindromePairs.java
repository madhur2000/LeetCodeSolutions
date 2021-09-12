class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
//         Approach-1: Brute Force | Time: O(N*N*K) | NOT ACCEPTED
        
        // List<List<Integer>> ans = new ArrayList<>();
        // for(int i=0; i<words.length; i++){
        //     for(int j=0; j<words.length; j++){
        //         if(i != j){
        //             String s = words[i] + words[j];
        //             if(isPalindrome(s)){
        //                 List<Integer> list = new ArrayList<>();
        //                 list.add(i);
        //                 list.add(j);
        //                 ans.add(list);
        //             }
        //         }
        //     }
        // }
        // return ans;
        
//         Approach-2: HashMap | Time: O(N*K*K) | ACCEPTED
        
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> allStrings = new HashMap<>();
        for(int i=0; i<words.length; i++){
            allStrings.put(words[i], i);
        }
        
//      what if "" is present as one of the strings
        
        if(allStrings.containsKey("")){
            int empty_index = allStrings.get("");
            for(int i=0; i<words.length; i++){
                if(!words[i].equals("") && isPalindrome(words[i])){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(empty_index);
                    ans.add(list);
                    List<Integer> list2 = new ArrayList<>();
                    list2.add(empty_index);
                    list2.add(i);
                    ans.add(list2);
                }
            }
            allStrings.remove("");
        }
        
        
        for(int i=0; i<words.length; i++){
            String curr_string = words[i];
            for(int j=0; j<curr_string.length(); j++){
                String left = curr_string.substring(0, j);
                String right = curr_string.substring(j);
                String rightReversed = reverseString(right);
                if(isPalindrome(left) && allStrings.containsKey(rightReversed) 
                    && allStrings.get(rightReversed) != i){
                    List<Integer> list = new ArrayList<>();
                    list.add(allStrings.get(rightReversed));
                    list.add(i);
                    ans.add(list);
                }
                String leftReversed = reverseString(left);
                if(isPalindrome(right) && allStrings.containsKey(leftReversed) 
                    && allStrings.get(leftReversed) != i){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(allStrings.get(leftReversed));
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    
    private static boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
    private static String reverseString(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}
