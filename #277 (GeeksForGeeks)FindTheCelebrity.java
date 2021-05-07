// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
        
        // HashSet<Integer> hashSet = rowsWithAllZeroes(M);
        
        // for(Integer k : hashSet){
            
        //     // System.out.println(k);
            
        //     boolean isCeleb = true;
            
        //     for(int i=0; i<n; i++){
        //         if(i != k && M[i][k] != 1){
        //             isCeleb = false;
        //             break;
        //         }
        //     }
        //     if(isCeleb){
        //         return k;
        //     }
        // }
        // return -1;
        
        int celeb = 0;
        
        for(int i=1; i<n; i++){
            
            if(M[celeb][i] == 1){
                celeb = i;
            }
            
        }
        
        for(int i=0; i<n; i++){
            
            if(i != celeb && M[i][celeb] != 1 || M[celeb][i] == 1){
                return -1;
            }
            
        }
        return celeb;
        
    }
    
    public static HashSet<Integer> rowsWithAllZeroes(int[][] M){
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<M.length; i++){
            
            boolean allAreZeroes = true;
            
            for(int j=0; j<M.length; j++){
                
                if(M[i][j] != 0){
                    allAreZeroes = false;
                    break;
                }
                
            }
            if(allAreZeroes){
                hs.add(i);
            }
        }
        return hs;
    }
    
}
