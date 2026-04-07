class Solution {
	public int trap(int[] height) {
		int l = 0, r = height.length-1;
		int totalWater = 0;
		int lMax = 0, rMax = 0;
		while(l<r) {
			if(height[l]<height[r]) {
				if(height[l]>=lMax) {
					lMax = height[l];
				} else {
					totalWater += lMax - height[l];
				}
				l++;
			} else {
				if(height[r]>=rMax) {
					rMax = height[r];
				} else {
					totalWater += rMax - height[r];
				}
				r--;
			}
		}
		return totalWater;
	}
}
