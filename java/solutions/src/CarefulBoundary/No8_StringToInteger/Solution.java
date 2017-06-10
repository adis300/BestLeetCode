package CarefulBoundary.No8_StringToInteger;

/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 */
public class Solution {
    public int myAtoi(String str) {

        str = str.trim();
        if(str.isEmpty()) return 0;
        boolean negative = str.charAt(0) == '-';
        int i = 0;
        if(negative || str.charAt(0) == '+') ++ i;

        long res = 0, counter = 0; char currentChar;
        while (i < str.length()){
            currentChar = str.charAt(i++);
            if (currentChar == '0' && res ==0) continue;
            if(currentChar > '9' || currentChar < '0') break;
            res *= 10;
            res += currentChar - '0';
            counter ++;
            if(counter > 10) break;
        }
        if (negative) res = -res;

        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) res;
    }

    public static void main(String[] args){
        new Solution().myAtoi("1");
    }
}
