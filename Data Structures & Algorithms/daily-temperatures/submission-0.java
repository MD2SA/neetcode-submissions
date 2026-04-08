class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
        Stack<Data> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i<temperatures.length; i++) {
			int temp = temperatures[i];
			while(!stack.isEmpty() && stack.peek().val < temp) {
				int storedIdx = stack.pop().idx;
				res[storedIdx] = i-storedIdx;
			}
			stack.push(new Data(temp, i));
		}
		return res;
	}
    
    private class Data {
		int val;
		int idx;
		public Data(int val, int idx) { this.val = val; this.idx = idx; }
	}
}
