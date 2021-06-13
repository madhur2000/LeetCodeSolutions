class Solution {
    public boolean exist(char[][] board, String word) {
        
        int rowCount = board.length;
        int colCount = board[0].length;
        
        boolean[][] visited = new boolean[rowCount][colCount];
        
        for(int i=0; i<rowCount; i++){
            for(int j=0; j<colCount; j++){
                
                if(helper(board, 0, word, visited, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean helper(char[][] board, int index, String word, boolean[][] visited, int i, int j){
        if(index >= word.length())
            return true;
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }
        
        if(word.charAt(index) != board[i][j])
            return false;
        
        if(visited[i][j])
            return false;
        
        visited[i][j] = true;
        
        boolean upAns = helper(board, index+1, word, visited, i-1, j);
        boolean downAns = helper(board, index+1, word, visited, i+1, j);
        boolean leftAns = helper(board, index+1, word, visited, i, j-1);
        boolean rightAns = helper(board, index+1, word, visited, i, j+1);
        
        if(upAns || downAns || leftAns || rightAns){
            return true;
        }
        
        visited[i][j] = false;  // if a cell is not going to give us the answer, then it must be reset to false because it may not be the starting character of word but it may be present at some other index of word. And if it will be marked as visited, then it won't be used by the call which needs it.
        
//         Test Case which made me understand this: [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]; word = "ABCESEEE"
        
        return false;
    }
    
}
