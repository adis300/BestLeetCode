package CombinationAndBacktracking._No216_CombinationSumIII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *

 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]


 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution {

    private static int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};

    private int target;
    private List<List<Integer>> results = new LinkedList<>();

    private void combine(int currentSum, int startIndex, int counter, List<Integer> result){

        if (currentSum >= target){
            if(currentSum == target && counter == 0) results.add(new ArrayList<>(result));
            return;
        }

        if (counter == 0) return;

        /** Additional code to improve performance*/
        // if (target > currentSum + counter * 9) return;

        for (int i = startIndex; i < candidates.length; i++){

            /** Additional code to improve performance*/
            if (target > currentSum + counter * 9 || target < currentSum + counter || target < currentSum + candidates[i]) break;

            result.add(candidates[i]);
            combine(currentSum + candidates[i], i + 1, counter - 1, result);
            result.remove(result.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        target = n;
        combine(0, 0, k, new ArrayList<>());
        return results;
    }

}
