class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
				if(isClosing(c)) {
					 if (stack.isEmpty() || !isMirrorAndOpening(c, stack.pop()))
						return false;
				}else 
					stack.push(c);
		}
		return stack.isEmpty();
    }
    
    private boolean isMirrorAndOpening(char c, char mirror) {
		return (mirror=='(' && c==')')||(mirror=='[' && c==']')||(mirror=='{' && c=='}');
	}
    private boolean isClosing(char c) {
			return c==')'||c=='}'||c==']';
	}
}
