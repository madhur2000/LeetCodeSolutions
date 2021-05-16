class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        if(nums.length == 1){
            List<List<Integer>> result = new ArrayList<>();
            // result = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[0]);
            result.add(temp);
            return result;
        }
        // List<List<Integer>> al = new ArrayList<>();
        // return al;
        
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            int[] currArr = getArrayLeavingI(nums, i);
            // List<Integer> temp = new ArrayList<>();
            // temp.add(nums[i]);
            
            List<List<Integer>> temp2 = permute(currArr);
            for(int j=0; j<temp2.size(); j++){
                
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                
                for(int k=0; k<temp2.get(j).size(); k++){
                    temp.add(temp2.get(j).get(k));
                }
                result.add(temp);
            }
            
        }
        
        return result;
    }
    
    public static int[] getArrayLeavingI(int[] nums, int i){
        int[] result = new int[nums.length-1];
        int g=0;
        
        for(int m=0; m<nums.length; m++){
            if(m != i){
                result[g++] = nums[m];
            }
        }
        return result;
    }
    
}
