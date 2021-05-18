class Solution {
    public int calculate(String s) {
        
        int i=0;
        ArrayDeque<String> st = new ArrayDeque<>();
        
        while(i < s.length()){
            String operator = "";
            String operand = "";
            // String operandString = "";
            while(i < s.length()
                  && s.charAt(i) != '+' 
                  && s.charAt(i) != '-' 
                  && s.charAt(i) != '*'
                  && s.charAt(i) != '/'){
                
                operand += s.charAt(i);
                i++;
            }
            
            if(!st.isEmpty() && st.peek().equals("*")){
                st.pop();
                String num1String = st.pop().trim();
                // if(!st.empty() && st.peek().equals("-")){
                //     num1String = st.pop() + num1String;
                // }
                
                int num1 = Integer.parseInt(num1String.trim());
                int num2 = Integer.parseInt(operand.trim());
                
                st.push((num1 * num2) + "");
                
            }
            else if(!st.isEmpty() && st.peek().equals("/")){
                st.pop();
                String num1String = st.pop().trim();
                // if(!st.empty() && st.peek().equals("-")){
                //     num1String = st.pop() + num1String;
                // }
                
                int num1 = Integer.parseInt(num1String.trim());
                int num2 = Integer.parseInt(operand.trim());
                
                st.push((num1 / num2) + "");
            }
            
            else{
                st.push(operand);
            }
            
            if(i < s.length()){
                operator = s.charAt(i) + "";
                st.push(operator);
            }
            
            i++;
        }
        
        
        int sum = 0;
        
        while(!st.isEmpty()){
            
            String numString = st.pop().trim();
            
            if(!st.isEmpty() && st.pop().equals("-")){
                numString = "-" + numString;
            }
            
            int num = Integer.parseInt(numString);
            
            sum += num;
            
        }
        
        return sum;
    }
}
