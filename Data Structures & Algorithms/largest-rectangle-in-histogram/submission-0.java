class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for( int i = 0; i<heights.length; i++) {
            int min = heights[i];
            maxArea = Math.max(min,maxArea);
            for( int j = i+1; j<heights.length; j++) {
                min = Math.min(heights[j], min);
                maxArea = Math.max(maxArea, (j+1-i)*min);
            }
        }
        return maxArea;
    }
}
