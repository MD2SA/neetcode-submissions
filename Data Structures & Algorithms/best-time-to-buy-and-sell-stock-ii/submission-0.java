class Solution {

    int[] memo;

    public int maxProfit(int[] prices) {
        memo = new int[prices.length];
        Arrays.fill(memo, -1);
        return dfs(prices[0], 1, prices);
    }

    private int dfs(int buy, int cur, int[] nums) {
        if(cur>=nums.length) 
            return 0;
        if(memo[cur] != -1) return memo[cur];

        if(buy>nums[cur]) 
            buy = nums[cur];

        int sellNow = (nums[cur]-buy)+dfs(nums[cur],cur+1, nums);
        int sellLater = dfs(buy, cur+1, nums);
        memo[cur] = Math.max(sellNow, sellLater);

        return memo[cur];
    }
}