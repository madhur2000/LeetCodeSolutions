class Solution {
    public List<List<String>> partition(String s) {
        
//         Approach-1: Recursion | O(N^2)
        
        List<List<String>> ans = new ArrayList<>();
        for(int i=1; i<=s.length(); i++){
            String leftHalf = s.substring(0, i);
            if(isPalindrome(leftHalf)){
                if(i<s.length()){
                    List<List<String>> sa = partition(s.substring(i));
                    for(List<String> l : sa){
                        List<String> list = new ArrayList<>();
                        list.add(leftHalf);
                        list.addAll(l);
                        ans.add(list);
                    }
                }
                else{
                    ans.add(new ArrayList<>(Arrays.asList(leftHalf)));
                }
            }
        }
        return ans;
    }
    
    public static boolean isPalindrome(String s){
        int i=0; int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
}
