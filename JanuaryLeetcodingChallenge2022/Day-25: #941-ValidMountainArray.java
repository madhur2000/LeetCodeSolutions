class Solution {
    public boolean validMountainArray(int[] arr) {
        
        if(arr.length < 3) return false;
        int i=1;
        while(i < arr.length && arr[i-1] < arr[i])
            i++;
        
        i = i-1;
        if(i == 0 || i == arr.length-1) return false;
        int j=i;
        
        while((j+1) < arr.length && arr[j] > arr[j+1])
            j++;
        
        if(j != arr.length-1)
            return false;
        
        return true;
        
    }
}
