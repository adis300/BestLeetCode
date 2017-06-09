package LoopAndCarry.No43_MultiplyStrings;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */
public class Solution {

    public String multiply(String num1, String num2) {
        int N1 = num1.length(), N2 = num2.length();

        int[] numList1 = new int[N1];
        int[] numList2 = new int[N2];
        for(int i = 0; i < N1; i ++)
            numList1[N1 -1 - i] = num1.charAt(i) - 48;

        for(int j = 0; j < N2; j ++)
            numList2[N2 -1 - j] = num2.charAt(j) - 48;

        int[] res = new int[N1 + N2 + 2];
        int prod;
        for(int i = 0; i < N1; i ++){
            for(int j = 0; j < N2; j ++){
                prod = numList1[i] * numList2[j];
                res[i+j] += prod;
            }
        }
        // Flatten resulting array
        int leftOver = 0, sum;
        for (int i = 0; i < res.length; i ++){
            sum = leftOver + res[i];
            leftOver = sum/10;
            res[i] = sum % 10;
        }
        StringBuilder builder = new StringBuilder();
        boolean startFlag = false;
        for (int i = res.length - 1; i >= 0; i --){
            if(!startFlag && res[i] == 0) continue;
            startFlag = true;
            builder.append((char)(res[i] + 48));
        }
        return builder.length() > 0? builder.toString(): "0";
    }

    public String multiply2(String num1, String num2) {
        int N1 = num1.length(), N2 = num2.length();
        int[] pos = new int[N1 + N2];

        for(int i = N1 - 1; i >= 0; i--) {
            for(int j = N2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args){
        String res = new Solution().multiply("9", "99");
        System.out.print(res);
    }

}
