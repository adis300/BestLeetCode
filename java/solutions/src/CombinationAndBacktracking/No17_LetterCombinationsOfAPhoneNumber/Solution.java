package CombinationAndBacktracking.No17_LetterCombinationsOfAPhoneNumber;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution {

    private static char[][] chars = new char[][]{
            new char[]{' '}, new char[]{},
            new char[]{'a','b','c'}, new char[]{'d','e','f'}, new char[]{'g','h','i'},
            new char[]{'j','k','l'}, new char[]{'m','n','o'}, new char[]{'p','q','r','s'},
            new char[]{'t','u','v'}, new char[]{'w','x','y','z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();

        if (digits.isEmpty()) return  result;

        findCombination(digits.toCharArray(), result, 0, "");
        return result;
    }

    public void findCombination(char[] digits, List<String> results, int startIndex, String currentPart){

        if (startIndex == digits.length) {
            results.add(currentPart);
            return;
        }

        char currentChar = digits[startIndex];
        if (currentChar == '1')
            findCombination(digits, results, startIndex + 1, currentPart);

        else {
            for (char character: chars[digits[startIndex] - '0'])
                findCombination(digits, results, startIndex + 1, currentPart + character);

        }
    }

    public static void main(String[] args){
        new Solution().letterCombinations("");
    }

}
