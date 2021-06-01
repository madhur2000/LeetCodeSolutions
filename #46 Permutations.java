class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        if(nums.length == 1){
            
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[0]);
            ans.add(temp);
            return ans;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            
            int[] temp = new int[nums.length-1];
            int g=0;
            for(int j=0; j<nums.length; j++){
                if(j != i){
                    temp[g++] = nums[j];
                }
            }
            
            List<List<Integer>> sa = permute(temp);
            
            for(int k=0; k<sa.size(); k++){
                
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add(nums[i]);
                curr.addAll(sa.get(k));
                ans.add(curr);
                
            }
            
        }
        return ans;
    }
}
