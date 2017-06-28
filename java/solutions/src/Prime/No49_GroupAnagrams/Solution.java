package Prime.No49_GroupAnagrams;

import java.util.*;

/**
 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        Map<Integer, List<String>> results = new HashMap<>();
        int key;
        for (String s: strs){
            key = 1; // Reset the keys
            for (char c: s.toCharArray()) key *= primes[c-'a'];
            if (!results.containsKey(key))results.put(key, new LinkedList<>());
            results.get(key).add(s);
        }
        return new LinkedList<>(results.values());
    }

    //
    public List<List<String>> groupAnagrams1(String[] strs) {
        // Naive hashmap & sorting solution
        return null;
    }
}
