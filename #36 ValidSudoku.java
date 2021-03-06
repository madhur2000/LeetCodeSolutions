class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<Character> hs = new HashSet<>();
        
        for(int i=0; i<board.length; i++){
            hs = new HashSet<>();
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] != '.'){
                    if(!hs.contains(board[i][j])){
                        hs.add(board[i][j]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        for(int i=0; i<board.length; i++){
            hs = new HashSet<>();
            for(int j=0; j<board[i].length; j++){
                if(board[j][i] != '.'){
                    if(!hs.contains(board[j][i])){
                        hs.add(board[j][i]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        hs = new HashSet<>();
        
//         sub-box 1:
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] != '.'){
                    if(!hs.contains(board[i][j])){
                        hs.add(board[i][j]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        hs = new HashSet<>();
        
//         sub-box 2:
        for(int i=0; i<3; i++){
            for(int j=3; j<6; j++){
                if(board[i][j] != '.'){
                    if(!hs.contains(board[i][j])){
                        hs.add(board[i][j]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        hs = new HashSet<>();
        
//         sub-box 3:
        for(int i=0; i<3; i++){
            for(int j=6; j<9; j++){
                if(board[i][j] != '.'){
                    if(!hs.contains(board[i][j])){
                        hs.add(board[i][j]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        hs = new HashSet<>();
        
//         sub-box 4:
        for(int i=3; i<6; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] != '.'){
                    if(!hs.contains(board[i][j])){
                        hs.add(board[i][j]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        hs = new HashSet<>();
        
//         sub-box 5:
        for(int i=3; i<6; i++){
            for(int j=3; j<6; j++){
                if(board[i][j] != '.'){
                    if(!hs.contains(board[i][j])){
                        hs.add(board[i][j]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        hs = new HashSet<>();
        
//         sub-box 6:
        for(int i=3; i<6; i++){
            for(int j=6; j<9; j++){
                if(board[i][j] != '.'){
                    if(!hs.contains(board[i][j])){
                        hs.add(board[i][j]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        hs = new HashSet<>();
        
//         sub-box 7:
        for(int i=6; i<9; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] != '.'){
                    if(!hs.contains(board[i][j])){
                        hs.add(board[i][j]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        hs = new HashSet<>();
        
//         sub-box 8:
        for(int i=6; i<9; i++){
            for(int j=3; j<6; j++){
                if(board[i][j] != '.'){
                    if(!hs.contains(board[i][j])){
                        hs.add(board[i][j]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        hs = new HashSet<>();
        
//         sub-box 9:
        for(int i=6; i<9; i++){
            for(int j=6; j<9; j++){
                if(board[i][j] != '.'){
                    if(!hs.contains(board[i][j])){
                        hs.add(board[i][j]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        return true;
        
    }
}

// Approach - 2: better than approach-1, if board is N X N
// class Solution {
//     public boolean isValidSudoku(char[][] board) {
        
//         HashSet<String> hs = new HashSet<>();
        
//         for(int i=0; i<board.length; i++){
//             for(int j=0; j<board[i].length; j++){
                
//                 if(board[i][j] != '.'){
//                     boolean x1 = hs.add(board[i][j] + " found in row " + i);
//                     boolean x2 = hs.add(board[i][j] + " found in column " + j);
//                     boolean x3 = hs.add(board[i][j] + " found in sub-box " + "(" + i/3 + "," + j/3 + ")");
                    
//                     if(!x1 || !x2 || !x3)
//                         return false;
//                 }
//             }
//         }
//         return true;
//     }
// }
