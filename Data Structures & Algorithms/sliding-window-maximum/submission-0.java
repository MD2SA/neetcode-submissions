class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] subarray = new int[k];
        int[] res = new int[nums.length-k+1];
        for(int l = 0; l+k<=nums.length; l++) {
			for(int i = 0; i<k; i++) {
				subarray[i] = nums[i+l];
			}
			res[l] = getMax(subarray);
		}
		return res;
    }
    
    private int getMax(int[] nums) {
		int max = nums[0];
		for( int n : nums) {
			max = Math.max(max,n);
		}
		return max;
	} 
}
