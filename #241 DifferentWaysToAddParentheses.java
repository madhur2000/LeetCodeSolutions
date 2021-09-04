class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        
//         Approach-1: Recursion
        
//         if(!exp.contains("+")
//             && !exp.contains("-")
//             && !exp.contains("*")){
//             List<Integer> ans = new LinkedList<>();
//             ans.add(Integer.parseInt(exp));
//             return ans;
//         }
        
//         List<Integer> ans = new LinkedList<>();
        
//         for(int i=0; i<exp.length(); i++){
//             if(exp.charAt(i) == '+'
//                 || exp.charAt(i) == '-'
//                 || exp.charAt(i) == '*'){
//                 List<Integer> list1 = diffWaysToCompute(exp.substring(0, i));
//                 List<Integer> list2 = diffWaysToCompute(exp.substring(i+1));
//                 for(Integer num1 : list1){
//                     for(Integer num2 : list2){
//                         if(exp.charAt(i) == '*'){
//                             ans.add(num1 * num2);
//                         }
//                         else if(exp.charAt(i) == '+'){
//                             ans.add(num1 + num2);
//                         }
//                         else{
//                             ans.add(num1 - num2);
//                         }
//                     }
//                 }
//             }
//         }
//         return ans;
        
        
//         Approach-2: Dynamic Programming
        
        return helper(exp, new HashMap<>());
    }
    
    private static List<Integer> helper(String exp, Map<String, List<Integer>> hm){
        
        if(!exp.contains("+")
            && !exp.contains("-")
            && !exp.contains("*")){
            List<Integer> ans = new LinkedList<>();
            ans.add(Integer.parseInt(exp));
            return ans;
        }
        
        if(hm.containsKey(exp))
            return hm.get(exp);
        
        List<Integer> ans = new LinkedList<>();
        
        for(int i=0; i<exp.length(); i++){
            if(exp.charAt(i) == '+'
                || exp.charAt(i) == '-'
                || exp.charAt(i) == '*'){
                List<Integer> list1 = helper(exp.substring(0, i), hm);
                hm.put(exp.substring(0, i), list1);
                List<Integer> list2 = helper(exp.substring(i+1), hm);
                hm.put(exp.substring(i+1), list2);
                for(Integer num1 : list1){
                    for(Integer num2 : list2){
                        if(exp.charAt(i) == '*'){
                            ans.add(num1 * num2);
                        }
                        else if(exp.charAt(i) == '+'){
                            ans.add(num1 + num2);
                        }
                        else{
                            ans.add(num1 - num2);
                        }
                    }
                }
            }
        }
        hm.put(exp, ans);
        return ans;
    }
    
}
