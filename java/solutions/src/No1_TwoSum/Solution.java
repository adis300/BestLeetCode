package No1_TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> record = new HashMap<>();

        for(int i = 0; i < nums.length; i ++){
            int num = nums[i];
            Integer checkMatch = record.get(num);
            if(checkMatch == null)
                record.put(target - nums[i], i);
            else
                // The index of checkMatch must be less than i
                return new int[]{checkMatch, i};
        }

        return new int[]{};

    }

    private class Pair implements Comparable{
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        int key;
        int value;

        @Override
        public int compareTo(Object o) {
            if (value < ((Pair)o).value) return -1;
            else if (value > ((Pair)o).value) return 1;
            else return 0;
        }
    }

    public int[] twoSum2(int[] nums, int target) {

        Pair[] sortedNums = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++){
            sortedNums[i] = new Pair(i, nums[i]);
        }
        Arrays.sort(sortedNums);

        int low = 0; int high = nums.length - 1;

        int sum;
        while (low < high){
            sum = sortedNums[low].value + sortedNums[high].value;
            if (sum < target) ++ low;
            else if (sum > target) --high;
            else
                return sortedNums[low].key < sortedNums[high].key?
                        new int[]{sortedNums[low].key, sortedNums[high].key}: new int[]{sortedNums[high].key, sortedNums[low].key};
        }

        return new int[]{};
    }

}
