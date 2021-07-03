class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
//         Approach-1: Brute Force | O(N^3)
        
//         int count = 0;
        
//         for(int i=0; i<arr.length; i++){
//             for(int j=i+1; j<arr.length; j++){
//                 for(int k=j+1; k<arr.length; k++){
//                     if(arr[i] + arr[j] + arr[k] == target)
//                         count++;
//                 }
//             }
//         }
//         return count;
        
        
//         Approach-2: HashMap | O(N^2) | Accepted
        
        // Arrays.sort(arr);
        
//         int count = 0;
        
//         for(int i=0; i<arr.length; i++){
//             int target2 = target - arr[i];
//             count += (twoSum(arr, i+1, target2) % (1000000000 + 7));
//             count = count % (1000000000 + 7);
//         }
//         return (count % (1000000000 + 7));
        
        
//         Approach-3: three pointers | O(N^2) | Accepted
        
        int mod = 1000000000 + 7;
        
        Arrays.sort(arr);
        
        int count = 0;
        
        for(int i=0; i<arr.length; i++){
            int target2 = target - arr[i];
            int j = i+1;
            int k = arr.length-1;
            while(j < k){
                if(arr[j] + arr[k] < target2){
                    j++;
                }
                else if(arr[j] + arr[k] > target2){
                    k--;
                }
                else{
                    if(arr[j] != arr[k]){
                        int temp = arr[j];
                        int c1 = 0;
                        while(arr[j] == temp){
                            c1 = (c1 + 1)%mod;
                            j++;
                        }
                        temp = arr[k];
                        int c2 = 0;
                        while(arr[k] == temp){
                            c2 = (c2 + 1)%mod;
                            k--;
                        }
                        count = (count + (c1 * c2)%mod)%mod;
                    }
                    else{
                        count += (((k-j+1)%mod * (k-j)%mod)%mod)/2;
                        count = count%mod;
                        break;
                    }
                }
            }
        }
        return count;
        
    }
    
    
//     public static int twoSum(int[] arr, int start, int target){
        
//         Map<Integer, Integer> hm = new HashMap<>();
//         int count = 0;
        
//         int n = arr.length;
        
//         for(int i=start; i<n; i++){
//             if(!hm.containsKey(arr[i])){
//                 hm.put(arr[i], 1);
//             }
//             else{
//                 hm.put(arr[i], hm.get(arr[i]) + 1);
//             }
//         }
        
//         for(int i=start; i<n; i++){
//             if(hm.containsKey(target - arr[i])){
//                 if((2 * arr[i]) != target){
//                     count += (hm.get(target - arr[i]) % (1000000000 + 7));
//                     count = count % (1000000000 + 7);
//                 } else{
//                     count += ((hm.get(target - arr[i]) - 1) % (1000000000 + 7));
//                     count = count % (1000000000 + 7);
//                 }
//             }
//         }
//         return ((count/2) % (1000000000 + 7));
//     }
    
}
