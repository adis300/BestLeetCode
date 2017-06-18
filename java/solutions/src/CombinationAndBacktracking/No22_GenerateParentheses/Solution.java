package CombinationAndBacktracking.No22_GenerateParentheses;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 *
 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class Solution {

    // Simplified code

    public void generateParenthesis(int leftCount, int rightCount, String content, List<String> result){
        if (leftCount > 0 || rightCount > 0){

            // Right count has to be always greater or equal to leftCount
            if (leftCount > 0){

                if (rightCount > leftCount) generateParenthesis(leftCount, rightCount - 1, content + ')', result);
                generateParenthesis(leftCount - 1, rightCount, content + '(', result);

            }else  // leftCount equals zero
                generateParenthesis(leftCount, rightCount - 1, content + ')', result);

        }else
            result.add(content);

    }


    /* Original thought process
    public void generateParenthesis(int leftCount, int rightCount, String content, List<String> result){
        if (leftCount > 0 || rightCount > 0){
            // Right count has to be always greater or equal to leftCount
            if (leftCount > 0){
                if (rightCount > leftCount) {
                    generateParenthesis(leftCount, rightCount - 1, content + ')', result);
                    generateParenthesis(leftCount - 1, rightCount, content + '(', result);
                }else // leftCount == rightCount
                    generateParenthesis(leftCount - 1, rightCount, content + '(', result);
            }else { // leftCount equals zero
                generateParenthesis(leftCount, rightCount - 1, content + ')', result);
            }
        }else{
            result.add(content);
        }
    }*/

    public List<String> generateParenthesis(int n) {
        List<String> results = new LinkedList<>();
        generateParenthesis(n, n, "", results);

        return results;
    }
}
