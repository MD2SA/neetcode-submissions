class Solution {
    
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, new StringBuilder());
        return res;
    }

    private void generate(int n, int open, int close,StringBuilder sb) {
        if(sb.length()==n*2) {
            res.add(sb.toString());
            return;
        }

        if(open<n) {
            sb.append('(');
            generate(n, open+1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open) {
            sb.append(')');
            generate(n, open, close+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
