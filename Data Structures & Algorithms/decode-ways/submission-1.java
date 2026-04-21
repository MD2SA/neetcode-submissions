class Solution {

    private int res = 0;
    private int[] memo;

    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return backtrack(s, 0);
    }

    public int backtrack(String s, int index) {
        if(s.length()==index) 
            return 1;

        if(s.charAt(index) == '0')
            return memo[index] = 0;

        if(memo[index] != -1)
            return memo[index];
        
        int count = backtrack(s, index+1);

        if(index+1<s.length()) {
            int prefix = Integer.parseInt(s.substring(index,index+2));
            if(prefix<=26)
                count += backtrack(s, index+2);
        }
        return memo[index] = count;
    }

}
