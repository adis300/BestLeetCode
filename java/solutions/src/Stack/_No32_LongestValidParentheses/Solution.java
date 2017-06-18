package Stack._No32_LongestValidParentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring. For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 *
 */
public class Solution {

    // Make use of a mask !!!
    public int longestValidParentheses(String s) {
        Stack<Integer> leftP = new Stack<>();
        boolean[] mask = new boolean[s.length()];

        char thisChar;
        for (int i = 0; i < s.length(); i ++){
            thisChar = s.charAt(i);
            if (thisChar =='('){
                leftP.add(i);
            }else{
                if (leftP.isEmpty()) continue;
                else{
                    mask[leftP.pop()] = true;
                    mask[i] = true;
                }
            }
        }
        int maxLength = 0, counter = 0;
        for (boolean marker: mask){
            if (marker)
                ++ counter;
            else{
                if (counter > maxLength) maxLength = counter;
                counter = 0;
            }
        }
        if (counter > maxLength) maxLength = counter;
        return maxLength;
    }

    // Awesome one stack solution
    public int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        new Solution().longestValidParentheses("(())()(()((");
    }

}
