class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        
        Map<Integer, String> hm = new HashMap<>();
        hm.put(2, "abc");
        hm.put(3, "def");
        hm.put(4, "ghi");
        hm.put(5, "jkl");
        hm.put(6, "mno");
        hm.put(7, "pqrs");
        hm.put(8, "tuv");
        hm.put(9, "wxyz");
        
        List<String> ans = new ArrayList<>();
        List<String> sa = letterCombinations(digits.substring(1));
        String letters = hm.get(digits.charAt(0) - '0');

        if(sa.size() != 0){
            for(int i=0; i<letters.length(); i++){
                char c = letters.charAt(i);
                for(String s : sa){
                    ans.add(c + s);
                }
            }
        }
        else{
            for(int i=0; i<letters.length(); i++){
                ans.add(letters.charAt(i) + "");
            }
        }
        return ans;
    }
}
