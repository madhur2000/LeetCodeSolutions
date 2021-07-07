class Solution {
    public int distributeCandies(int[] candyType) {
        
        int n = candyType.length;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            if(!set.contains(candyType[i])){
                set.add(candyType[i]);
            }
        }
        
        if(n/2 >= set.size()) return set.size();
        
        return (n/2);
        
    }
}
