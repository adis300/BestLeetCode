package PermutationAndBacktracking._No46_Permutations;

import java.util.*;

/**
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 */
public class Solution {

    ArrayList<Integer> numArray = new ArrayList<>();

    List<List<Integer>> results = new LinkedList<>();

    // Each position has all choices. use back tracking
    public List<List<Integer>> permute(int[] nums) {
        for (int num : nums) numArray.add(num);
        permute(0);
        return results;
    }

    public void permute(int start){

        if (start == numArray.size()) {
            results.add(new ArrayList<>(numArray));
        }

        for (int i = start; i < numArray.size(); i++){
            swap(start, i); // Permute the first item in remaining sequence with all rest of the items including item itself.
            permute(start + 1); //Recursively calling permute function to avoid the first item.
            swap(start, i);  // Swap back to original order for backtracking.
        }

    }

    void swap(int i, int j){
        int temp = numArray.get(i);
        numArray.set(i, numArray.get(j));
        numArray.set(j, temp);
    }

}
