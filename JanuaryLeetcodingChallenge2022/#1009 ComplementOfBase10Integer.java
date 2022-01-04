class Solution {
    public int bitwiseComplement(int n) {
        
//         Approach-1: time= O(N)
        
        // String n_binary = intToBinary(n);
        // String complement = getComplement(n_binary);
        // return binaryToInt(complement);
        
        
        
        
        
        
        
//         Approach-2: Bit Manipulation | time: log(n)
        
        int length = Integer.toBinaryString(n).length();    //log(n) [base: 2]
        
        int A = n;
        int C = (1 << length) - 1;
        
        return (A^C);
        
    }
    // String intToBinary(int n){
    //     return Integer.toBinaryString(n);
    // }
    // String getComplement(String n_binary){
    //     StringBuilder n_complement_binary = new StringBuilder();
    //     for(char bit : n_binary.toCharArray()){
    //         if(bit == '1')
    //             n_complement_binary.append('0');
    //         else
    //             n_complement_binary.append('1');
    //     }
    //     return n_complement_binary.toString();
    // }
    // int binaryToInt(String s){
    //     int ans = 0;
    //     for(int i=0; i<s.length(); i++){
    //         if(s.charAt(i) == '1')
    //             ans += Math.pow(2, s.length()-i-1);
    //     }
    //     return ans;
    // }
}
