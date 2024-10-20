class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : expression.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                boolean hasTrue = false;
                boolean hasFalse = false;
                
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') hasTrue = true;
                    if (val == 'f') hasFalse = true;
                }
                
                stack.pop();
                
                char operator = stack.pop();
                
                if (operator == '!') {
                    stack.push(hasFalse ? 't' : 'f');
                } else if (operator == '&') {
                    stack.push(hasFalse ? 'f' : 't');
                } else if (operator == '|') {
                    stack.push(hasTrue ? 't' : 'f');
                }
            }
        }  
        
        return stack.pop() == 't'; 
    }
}

