class Solution {

    int[] memo = new int[45];

    public int climbStairs(int n) {
        if(n <= 3) return n;
        if(memo[n-1] == 0) 
            memo[n-1] = climbStairs(n-1)+climbStairs(n-2);
        return memo[n-1];
    }
}
