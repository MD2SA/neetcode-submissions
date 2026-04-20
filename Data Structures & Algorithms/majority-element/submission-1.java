class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int count = 0; 
        for(int n : nums) {
            if(n == maj) count++;
            else if(--count == 0) {
                maj = n;
                count = 1;
            }
        }
        return maj;
    }
}