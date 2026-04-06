class Solution {

    public int longestConsecutive(int[] nums) {
        if(nums.length < 2) return nums.length;

        Arrays.sort(nums);
        int cur = 1, max = 0; 

        for(int i = 1; i<nums.length; i++) {
            if(nums[i-1]==nums[i])
                continue;
            else if(nums[i-1]+1 == nums[i])
                cur++;
            else {
                if(max<cur) max = cur;
                cur = 1;
            }
        }
        return max>cur?max:cur;
    }

}
