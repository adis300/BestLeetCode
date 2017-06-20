package PermutationAndBacktracking._No60_PermutationSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"

 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 */

// IDEA: For each digit, find the kth digit in available elements

public class Solution {

    public String getPermutation2(int n, int k) {
        List<Character> candidates = new ArrayList<>();

        int totalSize = 1;
        for (int i = 1; i <= n ; i ++) {
            candidates.add((char)(i + '0'));
            totalSize *= i;
        }

        int counter = n, sectionSize, digit;
        String str = "";
        -- k; // shift k to array index;

        while (counter > 0){
            sectionSize = totalSize/counter;
            digit = k/sectionSize;

            str += candidates.get(digit);
            candidates.remove(digit);

            totalSize /= counter;
            k %= sectionSize;
            -- counter;
        }

        return str;
    }

    public String getPermutation(int n, int k) {

        int totalSize = 1;
        for (int i = 1; i <= n ; i ++) totalSize *= i;

        boolean[] visited = new boolean[n];
        int counter = n;
        String str = "";

        while (counter != 0){ // 2
            int sectionSize = totalSize/counter;  //  1
            int digit = (k-1)/sectionSize + 1; // 1
            int visitedDigitCounter = 0;
            for (int i = 1; i <= n; i ++){
                if (visited[i - 1]) continue;
                ++ visitedDigitCounter; //1
                if (visitedDigitCounter == digit) {
                    visited[i - 1] = true; // mark first true
                    str += String.valueOf(i); // apend 1
                    break;
                }
            }
            totalSize /= counter; // totalSize = 1;
            k = k % sectionSize;
            if (k == 0) k = sectionSize;
            -- counter;
        }

        return str;
    }

    public static void main(String[] args){
        new Solution().getPermutation(3, 1);
    }

}
