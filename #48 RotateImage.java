class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseAllColumns(matrix);
    }
    
    public static void transpose(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix[0].length; j++){
                swap(matrix, i, j);
            }
        }
    }
    
    public static void reverseAllColumns(int[][] matrix){
        int i1 = 0, i2 = matrix[0].length-1;
        while(i1 < i2){
            int j=0;
            while(j < matrix.length){
                int temp = matrix[j][i1];
                matrix[j][i1] = matrix[j][i2];
                matrix[j][i2] = temp;
                j++;
            }
            i1++;
            i2--;
        }
    }
    
    public static void swap(int[][] matrix, int i, int j){
        
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
        
    }
}
