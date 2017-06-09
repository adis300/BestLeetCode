package LoopAndCarry.No415_AddStrings;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        String longer, shorter;
        if( num1.length() > num2.length()){
            longer = num1; shorter = num2;
        }else{
            longer = num2; shorter = num1;
        }
        int NLong = longer.length(), NShort = shorter.length();
        int[] res = new int[NLong + 1];

        int sum,carry = 0;
        for(int i = 0; i < NLong; i++){
            if(i < NShort)
                sum = longer.charAt(NLong - 1 - i) - '0' + shorter.charAt(NShort - 1 - i) - '0' + carry;
            else
                sum = longer.charAt(NLong - 1 - i) - '0' + carry;
            carry = sum / 10;
            res[NLong - i] = sum % 10;
        }
        if(carry > 0) res[0] = 1;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i ++){
            if(builder.length() == 0 && res[i] == 0) continue;
            builder.append((char)(res[i] + '0'));
        }

        return builder.length() > 0? builder.toString(): "0";

    }

    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int a = i >= 0 ? (num1Array[i--] - '0') : 0;
            int b = j >= 0 ? (num2Array[j--] - '0') : 0;
            int sum = a + b + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        return sb.toString();
    }

}
