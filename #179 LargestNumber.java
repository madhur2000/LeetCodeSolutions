import java.math.*;

class Solution {
    public String largestNumber(int[] nums) {
        
//         Approach-1: Recursion
        
//         if(nums == null || nums.length == 0)
//             return "";
        
//         int[] newNums = new int[nums.length-1];
//         int g=0;
        
//         String ans="";
        
//         for(int i=0; i<nums.length; i++){
            
//             newNums = new int[nums.length-1];
//             g=0;
            
//             for(int j=0; j<nums.length; j++){
                
//                 if(j != i){
//                     newNums[g++] = nums[j];
//                 }
                
//             }
            
//             String smallAns = nums[i] + largestNumber(newNums);
            
//             // String possibleAns = nums[i] + smallAns;
            
//             if(ans.equals("")){
//                 ans = smallAns;
//             }
//             else{
            
//                 BigInteger num1 = new BigInteger(smallAns);
//                 BigInteger num2 = new BigInteger(ans);

//                 if(num2.compareTo(num1) < 0){
//                     ans = smallAns;
//                 }
//             }
            
//         }
        
//         return ans;
        
        
//         Approach-2: Uses BigInteger class (which is not good!)
        
//         if(nums == null || nums.length == 0)
//             return "";
        
//         if(nums.length == 1)
//             return nums[0]+"";
        
//         mySort(nums, nums.length-2);
        
//         if(nums[0] == 0)
//             return "0";
        
//         String str = "";
        
//         for(int i=0; i<nums.length-1; i++){
            
//             str += nums[i];
            
//         }
        
//         String option1="";
        
//         if(!str.equals("0"))
//             option1 = str + nums[nums.length-1];
//         else
//             option1 = nums[nums.length-1] + "";
        
//         String option2 = "";
        
//         if(nums[nums.length-1] != 0)
//             option2 = nums[nums.length-1] + str;
//         else
//             option2 = str;
        
//         BigInteger b1 = new BigInteger(option1);
//         BigInteger b2 = new BigInteger(option2);
        
//         int comparisonResult = b1.compareTo(b2);
        
//         if(comparisonResult > 0){
//             return option1;
//         }
        
//         return option2;
        
//         Approach-3:
        
        
        if(nums == null || nums.length == 0)
            return "";
        
        String[] numsString = new String[nums.length];
        
        for(int i=0; i<nums.length; i++){
            numsString[i] = Integer.toString(nums[i]);
        }
        
        Arrays.sort(numsString, new Comparator<String>(){
            
            public int compare(String s1, String s2){       //returns 1 when we need to swap
                
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                
                return order2.compareTo(order1);
                
            }
            
        });
        
        if(numsString[0].equals("0")){
            return "0";
        }
        
        String ans = "";
        
        for(String str : numsString){
            ans += str;
        }
        
        return ans;
    }
    
//     public static void mySort(int[] nums, int n){
        
        
//         for(int k=0; k<=n; k++){
        
//             for(int i=0; i<=n-k; i++){

//                 // for(int j=i+1; j<=n; j++){
//                     String s1 = nums[i] + "" + nums[i+1];

//                     String s2 = nums[i+1] + "" + nums[i];
                
//                     BigInteger b1 = new BigInteger(s1);
//                     BigInteger b2 = new BigInteger(s2);

//                     if(b1.compareTo(b2) < 0){

//                         int temp = nums[i];
//                         nums[i] = nums[i+1];
//                         nums[i+1] = temp;

//                     }

//                 // }

//             }
//         }
//     }
    
    
}
