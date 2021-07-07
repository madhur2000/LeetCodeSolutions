class Solution {
    public String decodeString(String s) {
        
//         Time: O(N)
        
        ArrayDeque<String> stack = new ArrayDeque<>();
        
        for(int i=0; i<s.length();){
            char currChar = s.charAt(i);
            if(Character.isLetter(currChar) || currChar == '['){
                stack.push(currChar + "");
                i++;
            }
            else if(Character.isDigit(currChar)){
                String number = "";
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    number += s.charAt(i);
                    i++;
                }
                stack.push(number);
            }
            else if(currChar == ']'){
                String str = "";
                while(!stack.peek().equals("[")){
                    str = stack.pop() + str;
                }
                stack.pop();
                int num = Integer.parseInt(stack.pop());
                // while(num-- > 0){
                //     for(int j=0; j<str.length(); j++){
                //         stack.push(str.charAt(j) + "");
                //     }
                // }
                
                String str2 = "";
                
                while(num-- > 0){
                    str2 = str2 + str;
                }
                
                stack.push(str2);
                
                i++;
            }
        }
        
        String ans = "";
        while(!stack.isEmpty()){
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
