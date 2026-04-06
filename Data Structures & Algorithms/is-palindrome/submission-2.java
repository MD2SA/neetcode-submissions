class Solution {
    public boolean isPalindrome(String s) {
        s = clean(s);
        int size = s.length();
        for( int i = 0; i<size; i++)
            if(s.charAt(i) != s.charAt(size-1-i))
                return false;
        return true;
    }

    private String clean(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray())
            if(isAlphaNum(c)) sb.append(c);
        return sb.toString();
    }

    private boolean isAlphaNum(char c) {
        return ('a'<=c && c<='z') || ('A'<=c && c<='Z') || ('0'<=c && c<='9');
    }
}
