class Solution {
    public int lengthOfLongestSubstring(String s) {
			if(s.length()==0) return 0;
			Map<Character, Integer> map = new HashMap<>();
			int max = 0;
			int l = 0;
			for( int i = 0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(map.containsKey(c)) {
					l = Math.max(l, map.get(c)+1);
				}
				map.put(c,i);
				
				max = Math.max(max, i-l+1);
			}
			return max;
    }
}
