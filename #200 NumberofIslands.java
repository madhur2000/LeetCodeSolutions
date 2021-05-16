class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        int count = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                
                if(grid[i][j] == '1' && !visited[i][j]){
                    helper(grid, i, j, visited);
                    count++;
                }
                
            }
        }
        return count;
    }
    
    public static void helper(char[][] grid, int i, int j, boolean[][] visited){
        
        // if(grid[i][j] != 1)
        //     return;
        
        visited[i][j] = true;
        
        if(i+1 < grid.length && grid[i+1][j] == '1' && !visited[i+1][j]){
            // visited[i][j] = true;
            helper(grid, i+1, j, visited);
        }
        
        if(i-1 >= 0 && grid[i-1][j] == '1' && !visited[i-1][j]){
            // visited[i-1][j] = true;
            helper(grid, i-1, j, visited);
        }
        
        if(j+1 < grid[0].length && grid[i][j+1] == '1' && !visited[i][j+1]){
            // visited[i][j+1] = true;
            helper(grid, i, j+1, visited);
        }
        
        if(j-1 >= 0 && grid[i][j-1] == '1' && !visited[i][j-1]){
            // visited[i][j-1] = true;
            helper(grid, i, j-1, visited);
        }
        
        // return visited;
    }
}
