class Solution {

    public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    public int backtrack(int[] nums, int i, int total){
        if(nums.length<=i) {
            return total;
        }
        int res = backtrack(nums, i+1, total^nums[i]);

        res += backtrack(nums, i+1, total);
        return res;
    }
}