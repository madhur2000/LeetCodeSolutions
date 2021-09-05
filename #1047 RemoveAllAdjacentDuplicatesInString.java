class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        
        for(char c : s.toCharArray()){
            if(stack.isEmpty()
                || stack.peek() != c){
                stack.push(c);
            }
            else{
                stack.pop();
            }
        }
        
        StringBuilder ans = new StringBuilder("");
        
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
