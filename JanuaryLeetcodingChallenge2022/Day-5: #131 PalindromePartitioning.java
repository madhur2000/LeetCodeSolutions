class Solution {
    public List<List<String>> partition(String s) {
        
//         Approach-1: Backtracking method-1
        
        
        // int n = s.length();
        // if(s.length() == 0){
        //     List<List<String>> ans = new ArrayList<>();
        //     ans.add(new ArrayList<>());
        //     return ans;
        // }
        // List<List<String>> ans = new ArrayList<>();
        // for(int i=1; i<=n; i++){
        //     String leftSubstring = s.substring(0, i);
        //     String rightSubstring = s.substring(i);
        //     if(isPalindrome(leftSubstring)){
        //         List<List<String>> smallAns = partition(rightSubstring);
        //         for(List<String> list : smallAns){
        //             List<String> currList = new ArrayList<>();
        //             currList.add(leftSubstring);
        //             currList.addAll(list);
        //             ans.add(currList);
        //         }
        //     }
        // }
        // return ans;
        
        
        
        
        
        
        
        
        
//         Approach-2: Backtracking method-2
        
//         List<List<String>> ans = new ArrayList<>();
//         List<String> currList = new ArrayList<>();
//         helper(s, 0, s.length()-1, ans, currList);
        
//         return ans;
        
        
        
        
        
        
//         Approach-3: Backtracking with DP | Don't know why it's not working
        
        
        List<List<String>> ans = new ArrayList<>();
        List<String> currList = new ArrayList<>();
        boolean[][] storage = new boolean[s.length()][s.length()];
        helperDP(s, 0, s.length()-1, ans, currList, storage);
        
        return ans;
        
    }
    
    
    void helperDP(String s, int start, int end, List<List<String>> ans, List<String> currList, boolean[][] storage){
        if(start > end){
            ans.add(new ArrayList<>(currList));
            return;
        }
        for(int i=start+1; i<=end+1; i++){
            String leftSubstring = s.substring(start, i);
            // String rightSubstring = s.substring(i, end+1);
            if(leftSubstring.charAt(start) == leftSubstring.charAt(i-1)
                && (leftSubstring.length() <= 3 || storage[start+1][i-2])){
                storage[start][i-1] = true;
                currList.add(leftSubstring);
                helperDP(s, i, end, ans, currList, storage);
                currList.remove(currList.size()-1);
            }
        }
    }
    
    // void helper(String s, int start, int end, List<List<String>> ans, List<String> currList){
    //     if((end-start+1) == 0){
    //         ans.add(new ArrayList<>(currList));
    //         return;
    //     }
    //     for(int i=start+1; i<=s.length(); i++){
    //         String leftSubstring = s.substring(start, i);
    //         // String rightSubstring = s.substring(i, end+1);
    //         if(isPalindrome(leftSubstring)){
    //             currList.add(leftSubstring);
    //             helper(s, i, end, ans, currList);
    //             currList.remove(currList.size()-1);
    //         }
    //     }
    // }
    
    
//     boolean isPalindrome(String s){
//         int start=0;
//         int end=s.length()-1;
        
//         while(start < end){
//             if(s.charAt(start) != s.charAt(end)){
//                 return false;
//             }
//             start++;
//             end--;
//         }
//         return true;
//     }
}
