package Bitwise._No338_CountingBits;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:

 It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 But can you do it in linear time O(n) /possibly in a single pass?
 Space complexity should be O(n).
 Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 */
public class Solution {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int count, num;
        for (int k = 0; k <= n; k++){
            count = 0; num = k;
            for(int i = 0; i < 32; i++){
                count += (num & 1);
                num >>= 1;
            }
            result[k] = count;
        }


        return result;
    }

    // Solve using dynamic programing with division by 2.
    private Map<Integer, Integer> table = new HashMap<Integer, Integer>();
    public int[] countBits2(int n) {
        int[] result = new int[n + 1];

        for (int k = 0; k <= n; k++)
            result[k] = countBitsHelper(k);

        return result;
    }

    public int countBitsHelper(int k){

        if(k < 2) return k;

        Integer count = table.get(k);
        if(count != null) return count;
        int next = k/2;

        int computed = countBitsHelper(next) + (k - next * 2);
        table.put(k, computed);

        return computed;
    }

    //
    public int countBitsHelper2(int k){

        if(k < 2) return k;
        return countBitsHelper2(k/2) + (k & 1);
    }

    // Most concise solution with bit shift.
    public int[] countBits3(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }


    public static void main(String[] args){
        new Solution().countBits2(8);
    }
}

