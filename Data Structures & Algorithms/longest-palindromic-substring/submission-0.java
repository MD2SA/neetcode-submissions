class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] v = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int resIdx = 0, resLen = 0;
        for(int i = n-1; i>=0; i--) {
            for(int j = i; j<n; j++) {
                if(v[i] == v[j] && (j-i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if(j+1-i>resLen) {
                        resIdx = i;
                        resLen = j+1-i;
                    }
                }
            }
        }
        return s.substring(resIdx, resIdx+resLen);

    }
}
