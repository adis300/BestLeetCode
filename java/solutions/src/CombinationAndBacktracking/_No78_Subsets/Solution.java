package CombinationAndBacktracking._No78_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 */
public class Solution {

    // Smart way to compose subsets
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        if (nums.length == 0) return results;

        List<List<Integer>> copy;
        for (int num : nums) {
            copy = new ArrayList<>();
            for (List<Integer> result : results) {
                copy.add(new ArrayList<>(result));
                result.add(num);
            }
            results.addAll(copy);
        }

        return results;
    }


    // Use backtracking
    private List<Integer> copy(List<Integer> original){
        return new ArrayList<>(original);
    }
    public void backtrack(int[] nums, int startIndex, List<Integer> branch, List<List<Integer>> results){
        for(int i = startIndex; i< nums.length; i ++){
            branch.add(nums[i]);
            results.add(copy(branch));
            backtrack(nums, i+1, branch, results);
            branch.remove(branch.size() - 1);
        }
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> branch = new ArrayList<>();
        results.add(copy(branch));

        backtrack(nums, 0, branch, results);

        return results;
    }


    public static void main(String[] args){
        new Solution().subsets1(new int[]{1,2,3});
    }
}
