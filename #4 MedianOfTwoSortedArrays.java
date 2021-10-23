class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        
//         Approach-1: Time = O(m+n) | space = O(m+n)
        
//         int m = nums1.length, n = nums2.length;
//         int[] mergedArray = new int[m + n];
//         int g=0;
//         int i=0, j=0;
        
//         while(i<m && j<n){
//             if(nums1[i] < nums2[j]){
//                 mergedArray[g++] = nums1[i];
//                 i++;
//             }
//             else{
//                 mergedArray[g++] = nums2[j++];
//             }
//         }
        
//         while(i<m){
//             mergedArray[g++] = nums1[i++];
//         }
        
//         while(j<n){
//             mergedArray[g++] = nums2[j++];
//         }
        
//         if((mergedArray.length & 1) != 0){
//             return mergedArray[(mergedArray.length-1)/2];
//         }
        
//         return (mergedArray[(mergedArray.length-1)/2] + mergedArray[(mergedArray.length-1)/2 + 1])/2.0;
        
        
//         Approach-2:
        if(a.length > b.length)
			return findMedianSortedArrays(b, a);
		int n1 = a.length;
		int n2 = b.length;
		int low = 0;
		int high = a.length;
		while(low <= high){
			int cut1 = (low + high) >> 1;	//means: (low+high)/2
			int cut2 = (n1 + n2 +1)/2 - cut1;
			int l1 = Integer.MIN_VALUE;
			int l2 = Integer.MIN_VALUE;
			int r1 = Integer.MAX_VALUE;
			int r2 = Integer.MAX_VALUE;
			if(cut1 != 0){
				l1 = a[cut1-1];
			}
			if(cut2 != 0){
				l2 = b[cut2-1];
			}
			if(cut1 != n1){
				r1 = a[cut1];
			}
			if(cut2 != n2){
				r2 = b[cut2];
			}
			if(l1 <= r2 && l2 <= r1){
				if((n1+n2)%2 != 0)
					return Math.max(l1, l2);
				return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
			} else if(l1 > r2){
				high = cut1 - 1;
			} else{
				low = cut1 + 1;
			}
		}
		return 0;
        
    }
}
