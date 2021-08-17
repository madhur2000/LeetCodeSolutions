// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int index = binarySearch(nums, 0, nums.length-1, target);
        
//         if(index == -1)
//             return new int[]{-1, -1};
        
//         int leftIndex = binarySearch(nums, 0, index, target);
//         int temp = leftIndex;
//         while(temp != -1){
//             temp = binarySearch(nums, 0, leftIndex-1, target);
//             if(temp != -1)
//                 leftIndex = temp;
//         }
        
//         int rightIndex = binarySearch(nums, index, nums.length-1, target);
//         temp = rightIndex;
        
//         while(temp != -1){
//             temp = binarySearch(nums, rightIndex+1, nums.length-1, target);
//             if(temp != -1)
//                 rightIndex = temp;
//         }
//         return new int[]{leftIndex, rightIndex};
//     }
    
//     public static int binarySearch(int[] nums, int start, int end, int target){
        
//         while(start <= end){
//             int mid = start + (end - start)/2;
//             if(nums[mid] == target)
//                 return mid;
//             else if(target < nums[mid])
//                 end = mid-1;
//             else
//                 start = mid+1;
//         }
//         return -1;
//     }
// }


// Approach-2: Better one! and easier

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = getStartIndex(nums, target);
        ans[1] = getEndIndex(nums, target);
        return ans;
    }
    
    public static int getStartIndex(int[] nums, int target){
        
        int index = -1;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                index = mid;
                end = end-1;
            }
            else if(nums[mid] < target){
                start = start+1;
            }
            else
                end = end-1;
        }
        return index;
    }
    
    public static int getEndIndex(int[] nums, int target){
        
        int index = -1;
        int start=0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                index = mid;
                start = start+1;
            }
            else if(nums[mid] < target){
                start = start+1;
            }
            else
                end = end-1;
        }
        return index;
    }
    
}
