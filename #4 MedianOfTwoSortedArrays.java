class Solution {
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        
//         int i=0, j=0;
        
//         int m = num1.length, n = num2.length;
        
//         int[] num3 = new int[m+n];
//         int g=0;
        
//         while(i < num1.length && j < num2.length){
//             if(num1[i] <= num2[j]){
//                 num3[g++] = num1[i];
//                 i++;
//             }
//             else{
//                 num3[g++] = num2[j];
//                 j++;
//             }
//         }
        
//         while(i < num1.length){
//             num3[g++] = num1[i];
//             i++;
//         }
        
//         while(j < num2.length){
//             num3[g++] = num2[j];
//             j++;
//         }
        
//         if((num3.length & 1) == 0){
//             return (double) (num3[num3.length/2] + num3[(num3.length/2) - 1]) / 2.0;
//         }
//         return num3[num3.length/2];
        
        
//         Approach-2:
        
        
        int i=0, j=0;
        
        int m = num1.length, n = num2.length;
        
        int[] num3 = new int[((m+n)/2)+1];
        int g=0;
        
        while(i < num1.length && j < num2.length && g < num3.length){
            if(num1[i] <= num2[j]){
                num3[g++] = num1[i];
                i++;
            }
            else{
                num3[g++] = num2[j];
                j++;
            }
        }
        
        while(i < num1.length && g < num3.length){
            num3[g++] = num1[i];
            i++;
        }
        
        while(j < num2.length && g < num3.length){
            num3[g++] = num2[j];
            j++;
        }
        
        if(((m+n) & 1) != 0){
            return num3[num3.length-1];
        }
        return (double)(num3[num3.length-1] + num3[num3.length-2])/2.0;
        
        
    }
}
