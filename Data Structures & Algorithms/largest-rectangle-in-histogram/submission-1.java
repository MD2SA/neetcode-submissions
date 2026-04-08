class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for( int i = 0; i<heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                maxArea = Math.max(maxArea, (j - i + 1) * min);
            }
        }
        return maxArea;
    }
}
