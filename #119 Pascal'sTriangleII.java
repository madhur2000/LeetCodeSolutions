class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            List<Integer> ans = new LinkedList<>();
            ans.add(1);
            return ans;
        }
        List<Integer> sa = getRow(rowIndex-1);
        List<Integer> ans = new LinkedList<>();
        ans.add(1);
        for(int i=1; i<sa.size(); i++){
            ans.add(sa.get(i-1) + sa.get(i));
        }
        ans.add(1);
        return ans;
    }
}
