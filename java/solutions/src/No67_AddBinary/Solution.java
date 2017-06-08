package No67_AddBinary;

/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class Solution {
    public String addBinary(String a, String b) {
        String longer, shorter;
        if(a.length() > b.length()){
            longer = a; shorter = b;
        }else{
            longer = b; shorter = a;
        }

        int NLong = longer.length(), NShort = shorter.length();
        int NDiff = NLong - NShort;

        StringBuilder builder = new StringBuilder();

        int roundToNext = 0, sum;
        int[] res = new int[NLong + 1];

        for(int i = NLong - 1; i >= 0; i --){
            sum = i - NDiff >= 0? longer.charAt(i) - '0' + shorter.charAt(i - NDiff) - '0' + res[i+1]: longer.charAt(i)  - '0' + res[i+1];
            res[i + 1] = sum % 2;
            res[i] = sum/2;
        }

        for(int digit: res) {
            if(digit == 0 && builder.length() == 0) continue;
            builder.append((char)(digit + '0'));
        }
        return builder.length() > 0? builder.toString(): "0";
    }

    public static void main(String[] args){
        String res = new Solution().addBinary("11", "1");
    }
}
