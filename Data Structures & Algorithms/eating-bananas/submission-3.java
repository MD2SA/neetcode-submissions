class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 0;
        for( int p : piles) {
            hi = Math.max(hi, p);
        }
        int res = hi; 
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            int total = 0;
            for(int p : piles)
                total += (p+mid-1)/mid;
            if(total > h) {
                lo = mid +1;
            } else {
                hi = mid-1;
            }
        }
        return lo;
    }
}
