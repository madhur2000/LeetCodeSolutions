class Solution {
    public boolean detectCapitalUse(String word) {
        
//         Approach-1: Time: O(N)
        
        // if(allAreUpperCase(word)) return true;
        // if(allAreLowerCase(word)) return true;
        // if(Character.isUpperCase(word.charAt(0)) && allAreLowerCase(word.substring(1)))
        //     return true;
        // return false;
        
        
//         Approach-2: Time: O(N)
        return word.matches("[A-Z]*|.[a-z]*");
    }
    
//     boolean allAreUpperCase(String word){
//         for(char ch : word.toCharArray()){
//             if(Character.isLowerCase(ch)) return false;
//         }
//         return true;
//     }
    
//     boolean allAreLowerCase(String word){
//         for(char ch : word.toCharArray()){
//             if(Character.isUpperCase(ch)) return false;
//         }
//         return true;
//     }
}
