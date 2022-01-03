class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
//         Approach-1: Brute Force
        
        // int count = 0;
        // for(int i=0; i<time.length; i++){
        //     for(int j=i+1; j<time.length; j++){
        //         if((time[i] + time[j])%60 == 0){
        //             // System.out.println(i + " " + j);
        //             count++;
        //         }
        //     }
        // }
        // return count;
        
        
        
//         Approach-2:
        
        Map<Integer, Integer> frequencies = new HashMap<>();
        int count=0;
        frequencies.put(time[0]%60, 1);
        for(int i=1; i<time.length; i++){
            int secondNum = (60-(time[i]%60))%60;
            if(frequencies.containsKey(secondNum)){
                count += frequencies.get(secondNum);
            }
            frequencies.put(time[i]%60, frequencies.getOrDefault(time[i]%60, 0)+1);
        }
        return count;
    }
}
