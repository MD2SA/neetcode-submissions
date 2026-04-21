class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<operations.length; i++) {
            String op = operations[i];
            if("+".equals(op)) {
                int a = stack.pop();
                int r = a+stack.peek();
                stack.push(a);
                stack.push(r);
            } else if("C".equals(op)) {
                stack.pop();
            } else if("D".equals(op)) {
                stack.push(stack.peek()*2);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int res = 0;
        while(!stack.isEmpty()) res+=stack.pop();
        return res;
    }
}