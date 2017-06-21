package Strings.No557_ReverseStringIII;

import java.util.Stack;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.

 */
public class Solution {

    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {   // when i is a non-space
                int j = i;
                while (j + 1 < ca.length && ca[j + 1] != ' ') { j++; } // move j to the end of the word
                reverse(ca, i, j);
                i = j;
            }
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }

    // Two pointer solution
    public String reverseWords2(String s) {

        StringBuilder builder = new StringBuilder();
        char[] charArray = s.toCharArray();

        int i = 0;
        int start = i;
        int end = -1;
        while (i < charArray.length){
            if (charArray[i] != ' ') ++i;
            else{
                if (end < 0){
                    end = i - 1;
                    while (end >= start && end >=0){
                        if(end < s.length())builder.append(charArray[end]);
                        --end;
                    }
                }
                builder.append(' ');
                ++i;
                start = i;
                end = -1;
            }
        }
        start = builder.length();
        if (charArray.length > start){
            end = charArray.length - 1;
            for (int j = end; j >= start; j --)
                builder.append(charArray[j]);
        }
        return builder.toString();
    }

    // Using a stack
    public String reverseWords1(String s) {
        Stack<Character> charStack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for(char c : s.toCharArray()){
            if (c == ' '){
                while (!charStack.isEmpty()) builder.append(charStack.pop());
                builder.append(c);
            }else charStack.add(c);
        }
        while (!charStack.isEmpty()) builder.append(charStack.pop());

        return builder.toString();
    }

}
