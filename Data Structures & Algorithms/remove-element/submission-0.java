class Solution {
    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        for(int i = 0; i<k; i++) {
            while(i<k && nums[i] == val) {
                nums[i] = nums[--k];
            }
        }
        return k;
    }
}