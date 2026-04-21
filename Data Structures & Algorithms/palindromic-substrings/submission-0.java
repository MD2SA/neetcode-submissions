class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for(int i = 0; i<n; i++) {
            for(int j = i; j>=0; j--) {
                if(s.charAt(j) == s.charAt(i) && (i+1-j<=2||dp[i-1][j+1])) {
                    res++;
                    dp[i][j] = true;
                }
            }
        }
        return res;
    }
}
