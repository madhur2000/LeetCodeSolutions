class Solution {
    public List<List<Integer>> generate(int numRows) {
        
//         Approach-1: O(N^2) | T(N) = T(N-1) + N
        
        if(numRows == 1){
            List<Integer> list = new LinkedList<>();
            list.add(1);
            return new LinkedList<>(Arrays.asList(list));
        }
        
        List<List<Integer>> smallAns = generate(numRows-1);
        List<Integer> secondLastRow = smallAns.get(smallAns.size()-1);
        
        List<Integer> lastRow = new LinkedList<>();
        lastRow.add(1);
        for(int i=1; i<secondLastRow.size(); i++){
            lastRow.add(secondLastRow.get(i-1) + secondLastRow.get(i));
        }
        lastRow.add(1);
        
        smallAns.add(lastRow);
        return smallAns;
    }
}
