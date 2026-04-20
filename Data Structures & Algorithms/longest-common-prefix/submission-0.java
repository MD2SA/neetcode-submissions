class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(String s : strs) {
                if(s.length() <= i || c != s.charAt(i)) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}