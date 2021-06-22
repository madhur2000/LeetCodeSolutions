class Solution {
    public int numDecodings(String s) {
//         if(s.charAt(0) == '0') return 0;
        
//         int sa1 = 0, sa2 = 0;
        
//         int num1 = Integer.parseInt(s.substring(0, 1));
        
//         if(num1 <= 26 && num1 >= 1){
//             if(s.length() >= 2){
//                 sa1 = numDecodings(s.substring(1));
//             }
//             else{
//                 sa1 = 1;
//             }
//         }
        
//         if(s.length() < 2) return sa1;
        
//         int num2 = Integer.parseInt(s.substring(0, 2));
        
//         if(num2 <= 26 && num2 >= 1){
//             if(s.length() >= 3){
//                 sa2 = numDecodings(s.substring(2));
//             }
//             else
//                 sa2 = 1;
//         }
        
//         return (sa1 + sa2);
        
        
//         Approach-2: Bottom - up DP
        
        int[] storage = new int[s.length()];
        
        for(int i=s.length()-1; i>=0; i--){
            int ans = 0;
            if(s.charAt(i) == '0'){
                storage[i] = 0; continue;
            }
            
            int num1 = Integer.parseInt(s.substring(i, i+1));
            
            if(num1 <= 26 && num1 >= 1){
                if(i+1 < storage.length){
                    ans += storage[i+1];
                }
                else{
                    ans += 1;
                }
            }
            
            if(i+1 >= s.length()){
                storage[i] = ans;
                continue;
            }
            
            int num2 = Integer.parseInt(s.substring(i, i+2));
            if(num2 <= 26 && num2 >= 1){
                if(i+2 < storage.length){
                    ans += storage[i+2];
                }
                else{
                    ans += 1;
                }
            }
            storage[i] = ans;
        }
        return storage[0];
    }
}
