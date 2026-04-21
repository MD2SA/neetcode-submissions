class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Character> st = new HashMap<>();
        Set<Character> seen = new HashSet<>();
        for(int i = 0; i<s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(st.containsKey(cs) && st.get(cs) != ct) return false;
            if(!st.containsKey(cs) && seen.contains(ct)) return false;
            st.put(cs, ct);
            seen.add(ct);
        }
        return true;
    }
}