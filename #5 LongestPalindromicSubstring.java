class Solution {
    public String longestPalindrome(String s) {
        

//         Approach-1: recursion O(2^N)
//         boolean isPalindrome = isPalindrome(s);
        
//         if(isPalindrome)
//             return s;
        
//         String sa1 = longestPalindrome(s.substring(1));
//         String sa2 = longestPalindrome(s.substring(0, s.length()-1));
        
//         if(sa1.length() > sa2.length())
//             return sa1;
//         return sa2;
        
        
//         Approach-2: Brute force O(N^3)
//         String ans = "";
        
//         for(int i=0; i<s.length(); i++){
//             for(int j=i; j<s.length(); j++){
//                 String currString = s.substring(i, j+1);
//                 boolean isPalin = isPalindrome(currString);
//                 if(isPalin){
//                     if(ans.length() < currString.length()){
//                         ans = currString;
//                     }
//                 }
//             }
//         }
//         return ans;
        
        
//         Approach-3: DP O(N^2)
        
        String ans = s.charAt(0) + "";
        
        int[][] storage = new int[s.length()][s.length()];
        
        for(int i=0; i<s.length(); i++){
            
            storage[i][i] = 1;
            
        }
        
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) == s.charAt(i)){
                storage[i-1][i] = 1;
                if(s.substring(i-1, i+1).length() > ans.length()){
                    ans = s.substring(i-1, i+1);
                }
            }
        }
        
        int n = 2;
        
        while(n < s.length()){
        
            for(int i=0 ;(i + n)<s.length(); i++){

                String currString = s.substring(i, i+n+1);
                
                if(currString.charAt(0) == currString.charAt(currString.length() - 1)){
                    if(storage[i+1][i+n-1] == 1){
                        storage[i][i+n] = 1;
                        // System.out.println("(" + i + ", " + (i+n) + ")");
                        
                        if(currString.length() > ans.length()){
                            ans = currString;
                            // System.out.println("(" + i + ", " + (i+n) + ")");
                        }
                    }
                }

            }
            n++;
        }
        
// //         Printing the storage matrix:
//         for(int i=0; i<s.length(); i++){
//             for(int j=0; j<s.length(); j++){
//                 System.out.print(storage[i][j] + " ");
//             }
//             System.out.println();
//         }
        
        
        
        
        
        
//         String ans = "";
        
//         for(int i=0; i<s.length(); i++){
//             for(int j=i; j<s.length(); j++){
//                 if(storage[i][j] == 1){
//                     if(ans.length() < s.substring(i, j+1).length()){
//                         ans = s.substring(i, j+1);
//                     }
//                 }
//             }
//         }
        return ans;
        
    }
    
//     public static boolean isPalindrome(String s){
        
// //         less optimized way:
// //         Stack<Character> stack = new Stack<>();
// //         for(int i=0; i<s.length(); i++) {
// //             stack.push(s.charAt(i));
// //         }
        
// //         String reversed_s = "";
// //         while(!stack.empty()){
            
// //             reversed_s += stack.pop();
            
// //         }
// //         if(s.equals(reversed_s)){
// //             return true;
// //         }
// //         return false;
        
        
// //         more optimized:
//         int i, j;
        
//         if(s.length() % 2 != 0){
//             i = s.length()/2;
//             j = i;
//         }
//         else{
//             i = (s.length()/2) - 1;
//             j = i + 1;
//         }
        
//         while(i >= 0 && j < s.length()){
//             if(s.charAt(i) == s.charAt(j)){
//                 i--;
//                 j++;
//             }
//             else{
//                 return false;
//             }
//         }
        
//         return true;
        
//     }
    
}
