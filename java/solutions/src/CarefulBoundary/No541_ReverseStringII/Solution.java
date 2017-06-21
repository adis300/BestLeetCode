package CarefulBoundary.No541_ReverseStringII;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting
 * from the start of the string. If there are less than k characters left, reverse all of them. If there are less
 * than 2k but greater than or equal to k characters, then reverse the first k characters and left
 * the other as original.
 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"
 Restrictions:
 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]
 */
public class Solution {
    /**
     * Alternative solution, reverse * append by sections using recursion.
     */
    public String reverseStr(String s, int k) {
        int count = s.length()/k + k;
        StringBuilder builder = new StringBuilder();
        int j;
        for (int i = 0; i < count; i ++){
            if (i % 2 ==0){
                j = i * k + k - 1;
                while (j >= i * k){
                    if(j < s.length()) builder.append(s.charAt(j));
                    j --;
                }
            }else{
                j = i * k;
                while (j < i * k + k && j < s.length()) builder.append(s.charAt(j++));
            }
        }

        return builder.toString();
    }

    public String reverseStr1(String s, int k) {
        char[] charArray = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int i = 0, j = k - 1;
        while(i < charArray.length){
            if (i <= j && i > j - k){
                while (j >= i){
                    if(j < charArray.length)  builder.append(charArray[j]);
                    --j;
                }
                j += 3 * k;
                i += k;
            }else{
                builder.append(charArray[i]);
                ++i;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
        new Solution().reverseStr("abcdefg", 2);
    }
}
