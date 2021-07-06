class Solution {
    public int balancedStringSplit(String s) {
        
//         Approach-1: Accepted
        
//         int i=0, j=0;
//         int count = 0;
//         int r_count=0, l_count=0;
        
//         while(j<s.length()){
            
//             char c = s.charAt(j);
//             if(c == 'L')
//                 l_count++;
//             else
//                 r_count++;
            
//             if(l_count != 0 && r_count == l_count){
//                 count++;
//                 i=j+1;
//                 j=j+1;
//                 r_count=0;
//                 l_count=0;
//             }
//             else{
//                 j++;
//             }
//         }
//         return count;
        
//         Approach-2: given in hint-1
        
        int balance = 0;
        int count=0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'L') balance++;
            else balance--;
            
            if(balance == 0)
                count++;
        }
        return count;
    }
}
