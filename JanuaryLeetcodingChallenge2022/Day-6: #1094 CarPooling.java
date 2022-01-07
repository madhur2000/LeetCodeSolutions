class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> destMap = new HashMap<>();
        Map<Integer, Integer> sourceMap = new HashMap<>();
        
        // int maxDest = 0;
        int maxSource = 0;
        
        for(int i=0; i<trips.length; i++){
            sourceMap.put(trips[i][1], sourceMap.getOrDefault(trips[i][1], 0)+trips[i][0]);
            destMap.put(trips[i][2], destMap.getOrDefault(trips[i][2], 0)+trips[i][0]);
            // maxDest = Math.max(maxDest, trips[i][2]);
            maxSource = Math.max(maxSource, trips[i][2]);
        }
        
        for(int i=0; i<=maxSource; i++){
            if(destMap.containsKey(i))
                capacity += destMap.get(i);
            if(sourceMap.containsKey(i)){
                if(capacity < sourceMap.get(i)) return false;
                capacity -= sourceMap.get(i);
            }
        }
        return true;
    }
}
