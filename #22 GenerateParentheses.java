class Solution {
    public List<String> generateParenthesis(int n) {
        
        String currString = "";
        List<String> outputList = new ArrayList<>();
        
        generateParenthesisHelper(n, n, currString, outputList);
        return outputList;
    }
    
    public static void generateParenthesisHelper(int openCount, int closeCount, String currString, List<String> outputList){
        
        if(openCount == 0 && closeCount == 0){
            outputList.add(currString);
            return;
        }
        
        if(openCount == 0){
            generateParenthesisHelper(openCount, closeCount-1, currString + ")", outputList);
            
            return;
            
        }
        
        if(openCount == closeCount){
            generateParenthesisHelper(openCount-1, closeCount, currString + "(", outputList);
            return ;
        }
        
//         one case is left: when openCount < closeCount:
        
        generateParenthesisHelper(openCount-1, closeCount, currString + "(", outputList);
        
        generateParenthesisHelper(openCount, closeCount-1, currString + ")", outputList);
        
        return ;
        
    }
    
}
