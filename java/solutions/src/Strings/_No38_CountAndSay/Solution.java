package Strings._No38_CountAndSay;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.


 Example 1:

 Input: 1
 Output: "1"
 Example 2:

 Input: 4
 Output: "1211"

 */
public class Solution {
    /**
     * Make use of string builder
     */

    public String countAndSay(int n) {
        StringBuilder curr=new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i=1;i<n;i++){
            prev=curr;
            curr=new StringBuilder();
            count=1;
            say=prev.charAt(0);

            for (int j=1,len=prev.length();j<len;j++){
                if (prev.charAt(j)!=say){
                    curr.append(count).append(say);
                    count=1;
                    say=prev.charAt(j);
                }
                else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();

    }


    public String countAndSay1(int n) {
        if (n < 2) return String.valueOf(n);
        int count = 0; char digit = 0;
        String num = "1", newNum ="1";
        for(int i = 1; i <= n; i ++){
            num = newNum;
            newNum = "";

            for (int j = 0; j< num.length();j++){
                if(digit != num.charAt(j)){
                    if (count != 0) {
                        newNum += count;
                        newNum += digit;
                    }
                    count = 1;
                    digit = num.charAt(j);
                }else ++ count;
            }
            if (count != 0){
                newNum += count;
                newNum += digit;
                count = 0;
                digit = 0;
            }

        }
        return num;

    }

}
