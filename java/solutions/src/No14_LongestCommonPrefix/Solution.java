package No14_LongestCommonPrefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution {


    // Sort the strings.
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs != null && strs.length > 0) {

            Arrays.sort(strs);

            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();

            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    result.append(b[i]);
                } else {
                    return result.toString();
                }
            }
        }
        return result.toString();
    }

    public String longestCommonPrefix1(String[] strs) {
        String chars = "";
        if (strs.length == 0) return chars;
        Character c = null; int i = 0; boolean stop = false;

        while (true){
            for(String s: strs){
                if (s.length() == i) {
                    stop = true;
                    break;
                }
                if (c == null) c = s.charAt(i);
                if (!c.equals(s.charAt(i))){
                    stop = true;
                    break;
                }
            }
            if (stop) break;
            else chars += c;

            c = null;
            i++;
        }
        return chars;
    }

}
