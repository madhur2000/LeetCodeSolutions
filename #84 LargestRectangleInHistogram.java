class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] prevSmallerArr = prevSmaller(heights);
        int[] nextSmallerArr = nextSmaller(heights);
        int maxArea = 0;
        int n = heights.length;
        for(int i=0; i<n; i++){
            int height = heights[i];
            int width = nextSmallerArr[i] - prevSmallerArr[i] - 1;
            maxArea = Math.max(maxArea, height*width);
        }
        return maxArea;
    }
    
    static int[] prevSmaller(int[] heights){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        stack.push(0);
        for(int i=1; i<n; i++){
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.empty()){
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
    
    static int[] nextSmaller(int[] heights){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        // stack.push(n-1);
        // ans[n-1] = n;
        for(int i=n-1; i>=0; i--){
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.empty()){
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
}
