package Stack.No20_ValidParentheses;


import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */
public class Solution {

    // Code with spirit
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    Stack<Character> pStack = new Stack<>();

    public boolean isValid(String s) {
        char thisChar, lastChar;
        for (int i = 0; i < s.length(); i ++){
            thisChar = s.charAt(i);
            if (thisChar == '(' || thisChar == '{' || thisChar == '['){
                pStack.add(thisChar);
            }else {
                if (pStack.isEmpty()) return false;

                lastChar = pStack.pop();

                if (thisChar == ')' && lastChar == '(') continue;
                if (thisChar == ']' && lastChar == '[') continue;
                if (thisChar == '}' && lastChar == '{') continue;

                return false;
            }
        }
        return pStack.isEmpty();
    }

}
