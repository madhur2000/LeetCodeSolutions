// class Solution {
//     public int romanToInt(String s) {
        
//         Map<String, Integer> hm = new HashMap<>();
        
//         hm.put("I", 1);
//         hm.put("V", 5);
//         hm.put("X", 10);
//         hm.put("L", 50);
//         hm.put("C", 100);
//         hm.put("D", 500);
//         hm.put("M", 1000);
//         hm.put("IV", 4);
//         hm.put("IX", 9);
//         hm.put("XL", 40);
//         hm.put("XC", 90);
//         hm.put("CD", 400);
//         hm.put("CM", 900);
        
//         int ans = 0;
        
//         for(int i=0; i<s.length();){
//             if(i+2 <= s.length() && hm.containsKey(s.substring(i, i+2))){
//                 ans += hm.get(s.substring(i, i+2));
//                 i = i + 2;
//             } else{
//                 ans += hm.get(s.substring(i, i+1));
//                 i++;
//             }
//         }
//         return ans;
//     }
// }


// Revision Session:



class Solution {
    public int romanToInt(String s) {
        
//         Approach-1: Thought by myself
        
//         Map<Character, Integer> hm = new HashMap<>();
//         hm.put('I', 1);
//         hm.put('V', 5);
//         hm.put('X', 10);
//         hm.put('L', 50);
//         hm.put('C', 100);
//         hm.put('D', 500);
//         hm.put('M', 1000);
        
//         int ans = 0;
        
//         for(int i=0; i<s.length();){
//             char c = s.charAt(i);
//             if(c == 'I'){
//                 if(i+1<s.length() && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
//                     ans = ans + hm.get(s.charAt(i+1)) - hm.get(c);
//                     i+=2;
//                 }
//                 else{
//                     ans = ans + 1;
//                     i+=1;
//                 }
//             }
//             else if(c == 'X'){
//                 if(i+1 < s.length() && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
//                     ans = ans + hm.get(s.charAt(i+1)) - hm.get(c);
//                     i+=2;
//                 }
//                 else{
//                     ans = ans + 10;
//                     i+=1;
//                 }
//             }
//             else if(c == 'C'){
//                 if(i+1<s.length() && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
//                     ans = ans + hm.get(s.charAt(i+1)) - hm.get(c);
//                     i+=2;
//                 }
//                 else{
//                     ans = ans + 100;
//                     i+=1;
//                 }
//             }
//             else{
//                 ans = ans + hm.get(c);
//                 i+=1;
//             }
//         }
//         return ans;
        
        
//         Approach-2: understood from 'discuss'
        
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        
        int ans = 0;
        
        for(int i=s.length()-1; i>=0; i--){
            if(i+1 < s.length() && hm.get(s.charAt(i)) < hm.get(s.charAt(i+1))){
                ans = ans - hm.get(s.charAt(i));
            }
            else{
                ans = ans + hm.get(s.charAt(i));
            }
        }
        return ans;
    }
}
