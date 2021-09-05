class Solution {
    public String removeDuplicates(String s, int k) {
//         int i=0;
//         int j=0;
        
//         while(j < s.length()){
//             if(s.charAt(i) == s.charAt(j))
//                 j++;
//             else{
//                 if((j-i) < k)
//                     i = j;
//                 else{
//                     int n = (j-i)%k;
//                     char[] chars = new char[n];
//                     Arrays.fill(chars, s.charAt(i));
//                     String str = new String(chars);
//                     return removeDuplicates(s.substring(0, i) + str + s.substring(j), k);
//                 }
                
//             }
//         }
        
//         if(s.substring(i).length() >= k){
//             int n = s.substring(i).length()%k;
//             char[] chars = new char[n];
//             Arrays.fill(chars, s.charAt(i));
//             String str = new String(chars);
//             return (s.substring(0, i) + str);
//         }
//         return s;
        
        Deque<Character> charStack = new LinkedList<>();
        Deque<Integer> countStack = new LinkedList<>();
        
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            if(charStack.isEmpty()){
                charStack.push(ch);
                countStack.push(1);
            }
            else{
                if(ch == charStack.peek()){
                    charStack.push(ch);
                    countStack.push(countStack.pop()+1);
                }
                else{
                    charStack.push(ch);
                    countStack.push(1);
                }
            }
            
            if(countStack.peek() == k){
                int n = countStack.pop();
                while(n-- > 0){
                    charStack.pop();
                }
            }
        }
        
        StringBuilder ans = new StringBuilder("");
        
        while(!charStack.isEmpty()){
            // ans.insert(0, charStack.pop());
            ans.append(charStack.pop());
        }
        return ans.reverse().toString();
    }
}
