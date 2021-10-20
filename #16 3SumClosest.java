class Solution {
    public int threeSumClosest(int[] A, int target) {
        Arrays.sort(A);
        int res = A[0] + A[1] + A[A.length-1];
        for(int i=0; i<A.length; i++){
            int j = i+1;
            int k = A.length-1;
            while(j < k){
                int sum = A[i] + A[j] + A[k];
                if(sum < target){
                    j++;
                } else if(sum > target){
                    k--;
                } else{
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
            }
        }
        return res;
    }
}
