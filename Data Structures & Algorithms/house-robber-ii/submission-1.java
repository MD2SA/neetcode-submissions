class Solution {
    
    int[] nums;

    public int rob(int[] ns) {
        if(ns.length == 1) return ns[0];
        this.nums = ns;
        int[] memo1 = new int[ns.length];
        int[] memo2 = new int[ns.length];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        return Math.max(dp(0, nums.length-2, memo1), dp(1, nums.length-1, memo2));
    }

    private int dp(int cur, int limit, int[] memo) {
        if(cur>limit) 
            return 0;
        if(memo[cur] == -1)
            memo[cur] = Math.max(nums[cur]+dp(cur+2, limit, memo), dp(cur+1, limit, memo));
        return memo[cur];
    }
}
