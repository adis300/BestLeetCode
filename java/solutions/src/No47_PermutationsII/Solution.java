package No47_PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 */
public class Solution {

    ArrayList<Integer> numArray = new ArrayList<>();

    List<List<Integer>> results = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // Initialize all properties
        Arrays.sort(nums);
        for (int num: nums) numArray.add(num);
        permute(0);
        return results;
    }

    public void permute(int start){
        if (start == numArray.size())
            results.add(new ArrayList<>(numArray));
            // return

        for (int i = start; i < numArray.size(); i ++){
            if (i > start && numArray.get(i).equals(numArray.get(i - 1))) continue;
            swap(start, i);
            permute(start + 1);
            swap(start, i);
        }
    }

    void swap(int i, int j){
        int temp = numArray.get(i);
        numArray.set(i, numArray.get(j));
        numArray.set(j, temp);
    }

}
