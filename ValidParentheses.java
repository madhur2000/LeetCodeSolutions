class Solution {
    public boolean isValid(String s) {
        Stack <Character> st = new Stack <>() ;
        char arr [] = s.toCharArray() ;
        for ( char c : arr )
        {
           if ( c == '(' || c == '[' || c == '{')
           {
             st.push(c) ;
           }
           else
           {
              if (st.isEmpty())
              {
                return false ;
              }
              if ( (c == ')' && st.peek() == '(') || (c == ']' && st.peek() =='[') || (c == '}' && st.peek() == '{') )
              {
                st.pop() ;
              }
              else
              {
                return false ;
              }
    
           }
        }
      if (st.isEmpty())
      {
        return true ;
      }
      return false  ;
    }
}
