class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i = 0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(String s : strs) {
                if(s.length() <= i || c != s.charAt(i))
                    return s.substring(0,i);
            }
        }
        return strs[0];
    }
}