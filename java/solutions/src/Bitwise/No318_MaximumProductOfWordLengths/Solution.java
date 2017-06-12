package Bitwise.No318_MaximumProductOfWordLengths;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 *
 *
 Example 1:
 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:
 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.
 */
public class Solution {

    // Instead of using a boolean array, you can use a integer to store everything. Integer has 32 bits!
    public int maxProduct2(String[] words) {
        int max = 0;
        int[] bytes = new int[words.length];
        for(int i=0;i<words.length;i++){
            int val = 0;
            for(int j=0;j<words[i].length();j++){
                val |= 1<<(words[i].charAt(j)-'a');
            }
            bytes[i] = val;
        }
        for(int i=0; i<bytes.length; i++){
            for(int j=i+1; j<bytes.length; j++){
                if((bytes[i] & bytes[j])==0)max = Math.max(max,words[i].length()*words[j].length());
            }
        }
        return max;
    }

    public boolean checkElements(String a, String b){
        boolean[] map = new boolean[26];
        for(char charA: a.toCharArray())
            map[charA - 'a'] = true;
        for (char charB: b.toCharArray()){
            if (map[charB - 'a']) return false;
        }
        return true;
    }

    public int maxProduct(String[] words) {
        int product = 0;

        int temp;
        for (int i = 0; i < words.length; i ++){
            for(int j = i + 1; j < words.length; j ++){
                temp = words[i].length() * words[j].length();
                if(temp <= product) continue;
                if (checkElements(words[i], words[j])) product = temp;
            }
        }
        return product;
    }



    public static void main(String[] args){
        new Solution().maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"});
    }
}
