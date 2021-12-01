class Solution {
    public int findUnsortedSubarray(int[] A) {
        int[] A_unsorted = new int[A.length];
        for(int i=0; i<A.length; i++){
            A_unsorted[i] = A[i];
        }
        Arrays.sort(A);
        int start = 0;
        int end = -1;
        for(int i=0; i<A.length; i++){
            if(A[i] != A_unsorted[i]){
                start = i;
                break;
            }
        }
        for(int i=A.length-1; i>=0; i--){
            if(A[i] != A_unsorted[i]){
                end = i;
                break;
            }
        }
        return (end-start+1);
    }
}
