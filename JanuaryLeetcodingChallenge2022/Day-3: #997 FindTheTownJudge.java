class Solution {
    public int findJudge(int n, int[][] trust) {
        
        
//         Approach-1: Very complex approach | time: O(N^2)
        
        
//         if(trust.length == 0 && n > 1)
//             return -1;
//         //convert to map
//         Map<Integer, Set<Integer>> map = new HashMap<>();
//         for(int i=0; i<trust.length; i++){
//             if(!map.containsKey(trust[i][0])){
//                 Set<Integer> set = new HashSet<>();
//                 set.add(trust[i][1]);
//                 map.put(trust[i][0], set);
//             } else{
//                 Set<Integer> set = map.get(trust[i][0]);
//                 set.add(trust[i][1]);
//             }
//         }
        
//         for(int i=1; i<=n; i++){
//             if(!map.containsKey(i) && everybodyTrustsI(map, i, n))
//                 return i;
//         }
//         return -1;
        
        
        
        
        
        
//         Approach-2: Let's preprocess the array and convert it into a matrix | time: O(N^2)
//         This way, the problem becomes the 'CELEBRITY PROBLEM'
        
//         int[][] knows = new int[n+1][n+1];
        
//         for(int i=0; i<trust.length; i++){
//             knows[trust[i][0]][trust[i][1]] = 1;
//         }
        
//         int townJudge = 1;
        
//         for(int i=2; i<=n; i++){
//             if(knows[townJudge][i] == 1){
//                 townJudge = i;
//             }
//         }
        
//         for(int i=1; i<=n; i++){
//             if(i != townJudge && (knows[i][townJudge] != 1 || knows[townJudge][i] == 1)){
//                 return -1;
//             }
//         }
        
//         return townJudge;
        
        
        
        
        
        
        
//      Approach-3: Best Approach | time: O(N)
        
        int[] trustsCount = new int[n+1];
        int[] trustedByCount = new int[n+1];
        
        for(int i=0; i<trust.length; i++){
            trustsCount[trust[i][0]]++;
            trustedByCount[trust[i][1]]++;
        }
        
        int townJudge = -1;
        
        for(int i=1; i<trustedByCount.length; i++){
            if(trustedByCount[i] == n-1){
                townJudge = i;
                break;
            }
        }
        
        if(townJudge != -1 && trustsCount[townJudge] == 0){
            return townJudge;
        }
        
        return -1;
    }
//     boolean everybodyTrustsI(Map<Integer, Set<Integer>> map, int i, int n){
        
//         for(int j=1; j<=n; j++){
//             if( j != i && (!map.containsKey(j) || !map.get(j).contains(i))){
//                 return false;
//             }
//         }
        
//         return true;
        
//     }
}
