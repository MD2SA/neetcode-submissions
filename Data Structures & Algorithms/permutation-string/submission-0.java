class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for(char c : s1.toCharArray()) 
			freq[c-'a']++;
			
		int n = s1.length();
		int l = 0;
		int[] curFreq = new int[26];
		for( int r = 0; r<s2.length(); r++) {
			char c = s2.charAt(r);
			curFreq[c-'a']++;
			
			if(r < n-1) continue;

			boolean found = true;
			for(int i = 0; i<freq.length; i++) {
				if(freq[i]!=curFreq[i]) {
					found = false;
					break;
				}
			}
			if(found) 
				return true;
				
			curFreq[s2.charAt(l)-'a']--;
			l++;
		}
		
		return false;
    }
}
