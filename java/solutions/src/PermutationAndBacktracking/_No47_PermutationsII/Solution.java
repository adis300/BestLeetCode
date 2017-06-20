package PermutationAndBacktracking._No47_PermutationsII;

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

// This code contains lots of continue (redundant looping)
public class Solution {

    ArrayList<Integer> path = new ArrayList<>();
    List<List<Integer>> results = new LinkedList<>();
    int[] nums;
    boolean [] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {

        // For deal with the duplicate solution, we should sort it.
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        this.nums = nums;

        dfs();

        return results;
    }

    public void dfs() {
        if (path.size() == nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 只能连续地选，这样就可以避免生成重复的solution.
            // 例子：1 2 3 4 4 4 5 6 7 8
            // 444这个的选法只能:4, 44, 444连续这三种选法
            if (visited[i] || (i != 0 && !visited[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }

            // 递归以及回溯
            path.add(nums[i]);
            visited[i] = true;
            dfs();
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

}
