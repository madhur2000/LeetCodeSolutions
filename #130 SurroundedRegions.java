class Solution {
    public void solve(char[][] board) {
        
//         dfs on border elements which are 'O'
        
        for(int i=0; i<board.length; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
            if(board[i][board[0].length-1] == 'O'){
                dfs(board, i, board[0].length-1);
            }
        }
        
        for(int i=0; i<board[0].length; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
            if(board[board.length-1][i] == 'O'){
                dfs(board, board.length-1, i);
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
                
            }
        }
        
    }
    
    public static void dfs(char[][] board, int i, int j){
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        dfsHelper(board, i, j, visited);
        
    }
    
    
    public static void dfsHelper(char[][] board, int i, int j, boolean[][] visited){
        
        visited[i][j] = true;
        
        board[i][j] = '*';
        
        if(j+1 < board[0].length && board[i][j+1] == 'O' && !visited[i][j+1]){
            dfsHelper(board, i, j+1, visited);
        }
        if(j-1 >= 0 && board[i][j-1] == 'O' && !visited[i][j-1]){
            dfsHelper(board, i, j-1, visited);
        }
        if(i+1 < board.length && board[i+1][j] == 'O' && !visited[i+1][j]){
            dfsHelper(board, i+1, j, visited);
        }
        if(i-1 >= 0 && board[i-1][j] == 'O' && !visited[i-1][j]){
            dfsHelper(board, i-1, j, visited);
        }
        
    }
    
}
