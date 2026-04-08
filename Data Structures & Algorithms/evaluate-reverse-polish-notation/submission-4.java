class Solution {
  public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
			if(isOp(token)){
				int val2 = stack.pop();
				int val1 = stack.pop();
				int r = makeOp(val1,val2,token);
				System.out.println(val1+":"+val2+":"+r+":"+token);
				stack.push(r);
			} else {
				stack.push(Integer.valueOf(token));
			}
		}
		return stack.pop();
    }
    
    private boolean isOp(String s) {
			return "*+/-".contains(s);
	}
	
	private int makeOp(int v1, int v2, String op) {
			if("+".equals(op)) return v1+v2;
			else if("*".equals(op)) return v1*v2;
			else if("-".equals(op)) return v1-v2;
			return v1/v2;
	}
}
