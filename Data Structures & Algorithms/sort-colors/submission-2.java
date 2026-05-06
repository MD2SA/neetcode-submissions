class Solution {
    public void sortColors(int[] nums) {
        int[] counter = new int[3];
        for(int n : nums)
            counter[n]++;
        int l = 0;
        for(int i = 0; i<nums.length; i++) {
            while(counter[l] <= 0) l++;
            nums[i] = l;
            counter[l]--;
        }
    }
}