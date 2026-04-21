class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int l = 0, r = 0;
        int w1N = word1.length();
        int w2N = word2.length();
        while(sb.length() != w1N+w2N) {
            if(w1N>l)
                sb.append(word1.charAt(l++));
            if(w2N>r)
                sb.append(word2.charAt(r++));
        }
        return sb.toString();
    }
}