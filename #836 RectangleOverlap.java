class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0]; int y1 = rec1[1];
        int x2 = rec1[2]; int y2 = rec1[3];
        
        int a1 = rec2[0]; int b1 = rec2[1];
        int a2 = rec2[2]; int b2 = rec2[3];
        
        int width = Math.min(a2, x2) - Math.max(a1, x1);
        int height = Math.min(y2, b2) - Math.max(b1, y1);
        
        if(width <= 0 || height <= 0)
            return false;
        return true;
    }
}
