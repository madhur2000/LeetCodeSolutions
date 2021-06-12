class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> hs = new HashSet<>();
        
        while(n != 1){
            
            if(n < 0)
                return false;
            
            int sum = 0;
            while(n != 0){
                sum += Math.pow(n%10, 2);
                n = n/10;
            }
            n = sum;
            if(!hs.add(sum)){
                return false;
            }
        }
        return true;
        
    }
}
