package CombinationAndBacktracking._No39_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class Solution {

    int[] candidates;
    List<List<Integer>> results = new LinkedList<>();
    int target;

    public void combine(int currentSum, int start, List<Integer> result){
        // Remove the following line because of checking within for loop
        // if(currentSum > target) return;

        result.add(candidates[start]);

        if (currentSum < target) {
            for (int i = start; i < candidates.length; i ++){
                // ADD: the following line with sort to improve performance
                if (currentSum + candidates[i] > target) {
                    result.remove(result.size() - 1);
                    return;
                }
                combine(currentSum + candidates[i], i, result);
            }
        }else results.add(new ArrayList<>(result));
        result.remove(result.size() - 1);

    }

    // Use backtracking for all combinations.
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        this.candidates = candidates;
        // Adding sort to improve performance.
        Arrays.sort(candidates);
        ArrayList<Integer> result = new ArrayList<>();
        this.target = target;
        for (int i = 0; i < candidates.length; i ++){
            // ADD: the following line with sort to improve performance
            if (candidates[i] > target) break;
            combine(candidates[i], i, result);
        }
        return results;
    }

    public static void main(String[] args){
        new Solution().combinationSum(new int[]{2,3,7}, 7);
    }
}


