class Solution {
    public int maxArea(int[] heights) {
        int max = -1;
        int cur = -1;
        int l = 0, r = heights.length-1;
        while(l<r) {
            cur = (r-l)*Math.min(heights[l],heights[r]);
            max = Math.max(cur,max);
            if(heights[l]<heights[r]) l++;
            else r--;
        }
        return max;
    }

}
