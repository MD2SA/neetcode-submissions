class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l<r) {
            char left = s.charAt(l);
            char right = s.charAt(r);
            if(left != right) {
                return isPalindrome(s.substring(l+1,r+1)) ||
                isPalindrome(s.substring(l,r));
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        for(int i= 0; i<s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}