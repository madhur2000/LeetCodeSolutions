class Solution {
    public int longestArithSeqLength(int[] A) {
        
// Approach-1: O(2^N)

        // int n = A.size();
        // int[][] storage = new int[n][n];
        // Map<Integer, List<int[]>> map = new HashMap<>();
        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         storage[i][j] = A.get(j) - A.get(i);
        //         if(!map.containsKey(storage[i][j])){
        //             List<int[]> list = new ArrayList<>();
        //             int[] arr = new int[2];
        //             arr[0] = i;
        //             arr[1] = j;
        //             list.add(arr);
        //             map.put(storage[i][j], list);
        //         } else{
        //             List<int[]> list = map.get(storage[i][j]);
        //             list.add(new int[]{i, j});
        //         }
        //     }
        // }

        // int maxLength = 1;
        // for(Integer diff : map.keySet()){
        //     List<int[]> list = map.get(diff);
        //     for(int i=0; i<list.size(); i++){
        //         int currLength = 2;
        //         int[] arr = list.get(i);
        //         int end = arr[1];
        //         for(int j=0; j<list.size(); j++){
        //             if(list.get(j)[0] == end){
        //                 currLength++;
        //                 end = list.get(j)[1];
        //             }
        //         }
        //         maxLength = Math.max(maxLength, currLength);
        //     }
        //     // maxLength = Math.max(maxLength, currLength);
        // }
        // return maxLength;


// Approach-2: O(N^3) | Accepted

        // int maxLength = 0;

        // if(A.size() == 1)
        //     return 1;

        // for(int i=0; i<A.size(); i++){
        //     for(int j=i+1; j<A.size(); j++){
        //         int d = A.get(j) - A.get(i);
        //         int end = A.get(j);
        //         int length = 2;
        //         for(int k=j+1; k<A.size(); k++){
        //             if(A.get(k) - end == d){
        //                 end = A.get(k);
        //                 length++;
        //             }
        //         }
        //         maxLength = Math.max(maxLength, length);
        //     }
        // }
        // return maxLength;

// Approach-3: O(N^2) | DP

        int n = A.length;
        HashMap<Integer, Integer>[] storage = new HashMap[n];
        Arrays.fill(storage, new HashMap<>());
        for(int i=1; i<n; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0; j<i; j++){
                // HashMap<Integer, Integer> prevMap = storage[j];
                int currDiff = A[i] - A[j];
                if(!storage[j].containsKey(currDiff)){
                    map.put(currDiff, 1);
                } else{
                    map.put(currDiff, storage[j].get(currDiff)+1);
                }
            }
            storage[i] = map;
        }

        int maxLength = 0;

        for(HashMap<Integer, Integer> map : storage){
            for(Integer d : map.keySet()){
                maxLength = Math.max(maxLength, map.get(d));
            }
        }
        return (maxLength+1);
    }
}
