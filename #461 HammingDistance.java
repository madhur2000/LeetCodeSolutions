class Solution {
    public int hammingDistance(int x, int y) {
        
        int xor = x^y;
        
        String binaryString = Integer.toBinaryString(xor);
        
        int count = 0;
        
        for(int i=0; i<binaryString.length(); i++){
            if(binaryString.charAt(i) == '1')
                count++;
        }
        return count;
    }
}
