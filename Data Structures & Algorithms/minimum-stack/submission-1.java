class MinStack {
	Stack<Integer> main = new Stack<>();
	Stack<Integer> min = new Stack<>();
		
	public MinStack() {	}
    
	public void push(int val) {
		main.push(val);
		if(min.isEmpty() || min.peek() >= val) min.push(val);
	}
    
	public void pop() {
		if(main.isEmpty())return;
		int val = main.pop();
        if(val == min.peek()) min.pop();
	}
    
	public int top() {
		return main.peek();
	}
    
	public int getMin() {
		return min.peek();
	}
}

