class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        helper(nums, ans, currList, map);
        return ans;
    }
    void helper(int[] nums, List<List<Integer>> ans, List<Integer> currList, Map<Integer, Integer> map){
        if(currList.size() == nums.length){
            ans.add(new ArrayList<>(currList));
            return;
        }
        for(Integer num : map.keySet()){
            if(map.get(num) != 0){
                map.put(num, map.get(num)-1);
                currList.add(num);
                helper(nums, ans, currList, map);
                map.put(num, map.get(num)+1);
                currList.remove(currList.size()-1);
            }
        }
    }
}
