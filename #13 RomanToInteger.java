class Solution {
    public int romanToInt(String s) {
        
        Map<String, Integer> hm = new HashMap<>();
        
        hm.put("I", 1);
        hm.put("V", 5);
        hm.put("X", 10);
        hm.put("L", 50);
        hm.put("C", 100);
        hm.put("D", 500);
        hm.put("M", 1000);
        hm.put("IV", 4);
        hm.put("IX", 9);
        hm.put("XL", 40);
        hm.put("XC", 90);
        hm.put("CD", 400);
        hm.put("CM", 900);
        
        int ans = 0;
        
        for(int i=0; i<s.length();){
            if(i+2 <= s.length() && hm.containsKey(s.substring(i, i+2))){
                ans += hm.get(s.substring(i, i+2));
                i = i + 2;
            } else{
                ans += hm.get(s.substring(i, i+1));
                i++;
            }
        }
        return ans;
    }
}
