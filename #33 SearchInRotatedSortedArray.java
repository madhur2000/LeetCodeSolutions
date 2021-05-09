class Solution {
    public int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0)
            return -1;
        
        // if(nums.length == 1){
        //     if(nums[0] == target)
        //         return 0;
        //     return -1;
        // }
        
        int pi = findPivotIndex(nums, 0, nums.length-1);
        
        // if(pi == 0){
        //     if(nums[pi] == target)
        //         return pi;
        //     return -1;
        // }
        
        System.out.println(pi);
        
        int index = -1;
        
        if(nums[pi] <= target && target <= nums[nums.length-1]){
            index = binarySearch(nums, pi, nums.length-1, target);
        }
        else{
            index = binarySearch(nums, 0, pi-1, target);
        }
        
        return index;
    }
    
    public static int binarySearch(int[] nums, int start, int end, int target){
        
        if(start > end)
            return -1;
        
        int mid = start + (end - start)/2;
        
        if(nums[mid] == target)
            return mid;
        if(nums[mid] > target)
            return binarySearch(nums, start, mid-1, target);
        return binarySearch(nums, mid+1, end, target);
        
    }
    
    public static int findPivotIndex(int[] nums, int start, int end){
        
        if(start > end)
            return -1;
        
        if(start == end)
            return end;
        
        int mid = start + (end - start)/2;
        
        if(nums[mid] < nums[end]){
            return findPivotIndex(nums, start, mid);
        }
        
        return findPivotIndex(nums, mid+1, end);
        
    }
    
}
