class Solution {

    int[] nums;
    int[] memo = new int[100];

    public int rob(int[] ns) {
        this.nums = ns;
        return dp(0);
    }

    private int dp(int cur) {
        if(cur>=nums.length) 
            return 0;
        if(memo[cur] == 0)
            memo[cur] = Math.max(nums[cur]+dp(cur+2), dp(cur+1));
        return memo[cur];
    }
}
