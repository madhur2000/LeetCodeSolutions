class Solution {
    public int smallestRepunitDivByK(int k) {
//        Set<Integer> seenRemainders = new HashSet<>();
//         int length_of_n = 0;
//         int r = 1;
        
//         if(k == 1) return 1;
        
//         while(seenRemainders.add(r)){
//             // n = (n*10) + 1;
//             // r = n%k;
//             r = (r*10 + 1)%k;
//             length_of_n++;
//             if(r == 0)
//                 return (length_of_n + 1);
//         }
//         return -1;
        
        
//         Easy to understand:
        
//         Set<Integer> seenRemainders = new HashSet<>();
//         int length = 1;
//         int r = 0;
        
//         while(true){
//             r = (r*10 + 1)%k;
//             if(r == 0)
//                 return length;
//             else{
//                 if(seenRemainders.contains(r))
//                     return -1;
//                 seenRemainders.add(r);
//                 length++;
//             }
//         }
        
        
        
//      Using Pigeon hole Principle (i.e; n can be anything, nut reaminders can only lie in- [0, k-1])   
        Set<Integer> seenRemainders = new HashSet<>();
        int length = 1;
        int r = 0;
        
        for(int i=0; i<k; i++){
            r = (r*10 + 1)%k;
            if(r == 0)
                return length;
            else{
                length++;
            }
        }
        
        return -1;
        
    }
}
