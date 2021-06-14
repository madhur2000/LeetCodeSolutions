class Solution {
    public int[][] merge(int[][] intervals) {
        
//         Integer[][] intervalsInteger = new Integer[intervals.length][2];
//         for(int i=0; i<intervals.length; i++){
//             for(int j=0; j<2; j++){
//                 intervalsInteger[i][j] = intervals[i][j];
//             }
//         }
        
        
//         Arrays.sort(intervalsInteger, new Comparator<Integer[]>(){
            
//             public int compare(Integer[] a1, Integer[] a2){
//                 return a1[0].compareTo(a2[0]);
//             }
            
//         });
        
//         List<List<Integer>> ans = new ArrayList<>();
        
//         List<Integer> firstInterval = new ArrayList<>();
//         firstInterval.add(intervalsInteger[0][0]);
//         firstInterval.add(intervalsInteger[0][1]);
//         ans.add(firstInterval);
        
//         for(int i=1; i<intervalsInteger.length; i++){
//             if(intervalsInteger[i][0] > ans.get(ans.size()-1).get(1)){
//                 List<Integer> al = new ArrayList<>();
//                 al.add(intervalsInteger[i][0]);
//                 al.add(intervalsInteger[i][1]);
//                 ans.add(al);
//             } else{
//                 List<Integer> al = new ArrayList<>();
//                 List<Integer> removed = ans.get(ans.size()-1);
//                 ans.remove(ans.size()-1);
//                 al.add(Math.min(removed.get(0), intervalsInteger[i][0]));
//                 al.add(Math.max(removed.get(1), intervalsInteger[i][1]));
//                 ans.add(al);
//             }
//         }
        
//         int[][] ans_array = new int[ans.size()][2];
        
//         for(int i=0; i<ans.size(); i++){
//             for(int j=0; j<2; j++){
//                 ans_array[i][j] = ans.get(i).get(j);
//             }
//         }
//         return ans_array;
        
        
        
        
        
        
//         Same Approach | Writing in a more readable form and reducing loops and hence reducing execution time:
        
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2){
                return (a1[0] - a2[0]);
            }
            
        });
        
        List<int[]> ans = new ArrayList<>();
        
        ans.add(new int[]{intervals[0][0], intervals[0][1]});
        
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] > ans.get(ans.size()-1)[1]){
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
            } else{
                int[] removed = ans.get(ans.size()-1);
                ans.remove(ans.size()-1);
                int start = Math.min(removed[0], intervals[i][0]);
                int end = Math.max(removed[1], intervals[i][1]);
                ans.add(new int[]{start, end});
            }
        }
        
        
        int[][] ansArray = new int[ans.size()][2];
                
        for(int i=0; i<ans.size(); i++){
            for(int j=0; j<2; j++){
                ansArray[i][j] = ans.get(i)[j];
            }
        }
        return ansArray;
    }
}
