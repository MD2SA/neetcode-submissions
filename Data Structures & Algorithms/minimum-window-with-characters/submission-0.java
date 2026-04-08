class Solution {
	public String minWindow(String s, String t) {
		if(s.length()<t.length()) return "";
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : t.toCharArray())
			freq.put(c, freq.getOrDefault(c, 0)+1);
		
		Map<Character, Integer> curFreq = new HashMap<>();
		int l = 0;
		int totalFound = 0, res = s.length()+1, startAt = 0;

        for(int r = l; r<s.length(); r++) {
			char c = s.charAt(r);
			
			if(freq.containsKey(c)) {
				curFreq.put(c, curFreq.getOrDefault(c,0)+1);
				if(curFreq.get(c).intValue() <= freq.get(c).intValue())
					totalFound++;
			}

			while(totalFound == t.length()) {
				if(res > r - l + 1) {
					res = r - l + 1;
					startAt = l;
				}
					
				char ch = s.charAt(l);
				if(freq.containsKey(ch)) {
					curFreq.put(ch, curFreq.get(ch)-1);
					if(curFreq.get(ch).intValue() < freq.get(ch).intValue())
						totalFound--;
				}
				l++;
			}
		}
		if(res > s.length()) return "";
		return s.substring(startAt, startAt+res);
    }   
}
