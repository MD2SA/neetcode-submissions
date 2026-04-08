class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
		int res = 1;
		
		int[][] pairs = new int[position.length][2];
		for(int i = 0; i<position.length; i++) {
			pairs[i][0] = position[i];
			pairs[i][1] = speed[i];
		}
		Arrays.sort(pairs, (a,b)-> {
				return b[0]-a[0];
			});
		
		double prevTime = (double)(target-pairs[0][0])/pairs[0][1];
		for(int i = 1; i<n; i++) {
			double curTime = (double)(target-pairs[i][0])/pairs[i][1]; 
			if(curTime>prevTime) {
				res++;
                prevTime = curTime; 
			}
		}

		return res;
    }
    
}
