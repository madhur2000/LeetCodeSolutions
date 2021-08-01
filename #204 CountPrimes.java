class Solution {
    public int countPrimes(int n) {
        
//         Approach-1: Bacho wala concept
        
//         if(n == 0 || n == 1) return 0;
        
//         int count=0;
        
//         for(int i=2; i<n; i++){
//             if(isPrime(i))
//                 count++;
//         }
//         return count;
        
//         Approach-2: Bado wala concept | Sieve of eratosthenes | Time: O(Nlog(logN))
        
        boolean[] sieve = new boolean[n];
        // Arrays.fill(sieve, true);
        
        // Here, false means number is not composite, true means number is composite
        
        for(int i=2; (i*i)<=n; i++){
            if(sieve[i] == false){
                for(int j=i*i; j<n; j=j+i){
                    sieve[j] = true;
                }
            }
        }
        
        int count = 0;
        
        for(int i=2; i<n; i++){
            if(sieve[i] == false)
                count++;
        }
        return count;
    }
    
    
//     public static boolean isPrime(int n){
        
//         for(int i=2; i*i<=n; i++){
//             if(n%i == 0) return false;
//         }
//         return true;
//     }
}
