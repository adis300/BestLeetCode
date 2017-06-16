package ReduceDoubleLoopWithMap.No187_RepeatedDNASequences;

import java.util.*;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * For example,
 *
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *
 * Return:
 *
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 */
public class Solution {

    // Convert everything to bit to save space.
    public List<String> findRepeatedDnaSequences1(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        String sub;
        for (int i = 0; i + 9 < s.length(); i++) {
            sub = s.substring(i, i + 10);
            if (!seen.add(sub)) repeated.add(sub);
        }
        return new ArrayList(repeated);
    }

    // n2 solution
    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> record = new HashSet<>();
        Set<Integer> checkedLocations = new HashSet<Integer>();
        String sub, nextSub;
        for (int i= 0; i <= s.length() - 10;i ++){
            sub = s.substring(i, i + 10);
            if (checkedLocations.contains(i)) continue;
            for (int j = i + 1; j <= s.length() - 10; j ++){
                nextSub = s.substring(j, j + 10);
                if (sub.equals(nextSub)){
                    checkedLocations.add(j);
                    record.add(sub);
                }
            }

        }

        return new ArrayList<>(record);
    }

}
