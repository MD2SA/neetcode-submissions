class Solution {
    public int characterReplacement(String s, int k) {
		int[] freq = new int[26];
		int l = 0, r = 0;
		int highestFreq = 0;
		int maxWindow = 0;
		while(r<s.length()) {
			char c = s.charAt(r);
			highestFreq = Math.max(highestFreq, ++freq[c-'A']);

			if((r+1-l) <= highestFreq+k) maxWindow = Math.max(maxWindow, r+1-l);
			while((r+1-l) > highestFreq+k) {
				freq[s.charAt(l)-'A']--;
				highestFreq = 0;
				for(int f : freq)
					highestFreq = Math.max(highestFreq, f);
				l++;
			}
			r++;
		}
		return maxWindow;
    }
}
