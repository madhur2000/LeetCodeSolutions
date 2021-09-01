class Solution {
    public int climbStairs(int n) {
        int[] storage = new int[n+1];
        storage[0] = 1;
        storage[1] = 1;
        for(int i=2; i<=n; i++){
            storage[i] = storage[i-1] + storage[i-2];
        }
        return storage[n];
    }
}
