class Solution {

    int[] nums;
    int[] memo = new int[100];

    public int rob(int[] ns) {
        this.nums = ns;
        return Math.max(dp(0), dp(1));
    }

    private int dp(int cur) {
        if(cur>=nums.length) 
            return 0;
        if(memo[cur] == 0)
            memo[cur] = nums[cur] + Math.max(dp(cur+2), dp(cur+3));
        return memo[cur];
    }
}
