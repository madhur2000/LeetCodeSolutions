class Solution {
    public boolean exist(char[][] board, String word) {
        
        int rowCount = board.length;
        int colCount = board[0].length;
        
        for(int i=0; i<rowCount; i++){
            for(int j=0; j<colCount; j++){
                
                boolean[][] visited = new boolean[rowCount][colCount];
                if(helper(board, word, visited, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean helper(char[][] board, String word, boolean[][] visited, int i, int j){
        if(word.length() == 0)
            return true;
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }
        
        if(word.charAt(0) != board[i][j])
            return false;
        
        if(visited[i][j])
            return false;
        
        visited[i][j] = true;
        
        boolean upAns = helper(board, word.substring(1), visited, i-1, j);
        boolean downAns = helper(board, word.substring(1), visited, i+1, j);
        boolean leftAns = helper(board, word.substring(1), visited, i, j-1);
        boolean rightAns = helper(board, word.substring(1), visited, i, j+1);
        
        visited[i][j] = false;
        
        return (upAns || downAns || leftAns || rightAns);
        
    }
    
}
