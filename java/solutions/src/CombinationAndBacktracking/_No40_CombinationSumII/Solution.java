/**
 * KEYNOTE Duplicates is important
 * for(int i = start; i < length; i ++){
 *     if(i > start && nums[i] == nums[i - 1]) continue;
 * }
 */
package CombinationAndBacktracking._No40_CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]

 */
public class Solution {

    List<List<Integer>> results = new LinkedList<List<Integer>>();
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort to improve performance
        Arrays.sort(candidates);

        // Put shared values into property
        this.candidates = candidates;
        this.target = target;

        backtrack(new ArrayList<>(), 0,0);
        return results;
    }

    private void backtrack(List<Integer> result, int currentSum, int start) {

        if(currentSum > target) return; /* no solution */
        else if(currentSum == target) results.add(new ArrayList<>(result));
        else{
            for (int i = start; i < candidates.length; i++) {

                /* skip duplicates */
                if(i > start && candidates[i] == candidates[i-1]) continue;

                result.add(candidates[i]);

                backtrack(result, currentSum + candidates[i], i+1);
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        new Solution().combinationSum2(new int[]{1,2,5,6},8);
    }

    /* More code but very efficient
    List<List<Integer>> results = new LinkedList<>();
    int[] candidates;
    int target;
    public void combine(int start, int currentSum, List<Integer> result){

        int sum;

        for (int i = start; i < candidates.length; i ++){
            // skip duplicates
            if(i > start && candidates[i] == candidates[i-1]) continue;

            sum = currentSum + candidates[i];
            if (sum >= target){
                if (sum == target) {
                    result.add(candidates[i]);
                    results.add(new ArrayList<>(result));
                    result.remove(result.size() - 1);
                }
                return;
            }
            result.add(candidates[i]);
            combine(i+1, sum, result);
            result.remove(result.size() - 1);

        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // Sort to improve performance
        Arrays.sort(candidates);

        // Adding shared values to property
        this.candidates = candidates;
        this.target = target;

        combine(0, 0, new ArrayList<>());

        return results;
    }
    */

}
