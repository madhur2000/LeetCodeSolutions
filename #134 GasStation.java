class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
//         Approach-1: Recursive | O(N^2)
        
        // int n = gas.length;
        // for(int i=0; i<n; i++){
        //     if(gas[i] >= cost[i] && helper(gas, cost, i, (i+1)%n, gas[i] - cost[i])){
        //         return i;
        //     }
        // }
        // return -1;
        
        
//         Approach-2: Two Pointer | O(N) | https://www.youtube.com/watch?v=zcnVaVJkLhY
        
        int n = gas.length;
        
        int front = 0;
        int rear = 0;
        
        int remainingGas = 0;
        
        for(int i=0; i<n; i++){
            if(gas[rear] < cost[rear]){
                front++;
                if(front >= n)
                    return -1;
                rear = front;
            }
            else{
                remainingGas += gas[rear] - cost[rear];
                rear = (rear+1) % n;
                while(front != rear && (remainingGas + gas[rear]) >= cost[rear]){
                    remainingGas += gas[rear] - cost[rear];
                    rear = (rear+1) % n;
                }
                if(front == rear)
                    return front;
                if(remainingGas + gas[rear] < cost[rear]){
                    front = rear+1;
                    if(front >= n) return -1;
                    rear = front;
                    remainingGas = 0;
                }
            }
        }
        return -1;
    }
    
//     public static boolean helper(int[] gas, int[] cost, int start, int index, int remainingGas){
        
//         if(index == start) return true;
        
//         if(remainingGas + gas[index] >= cost[index]){
//             return helper(gas, cost, start, (index+1)%gas.length, remainingGas + gas[index] - cost[index]);
//         }
//         return false;
//     }
}
