package CombinationAndBacktracking.No77_Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 */
public class Solution {

    List<List<Integer>> results = new LinkedList<>();
    int n;

    public void backtrack(int start, int counter, List<Integer> result){

        if (counter == 0){
            results.add(new ArrayList<>(result));
            return;
        }

        for (int i = start; i <= n; i ++){
            result.add(i);
            backtrack(i + 1, counter - 1, result);
            result.remove(result.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        backtrack(1, k, new ArrayList<>());
        return results;
    }
}
