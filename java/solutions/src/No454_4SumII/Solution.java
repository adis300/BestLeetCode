package No454_4SumII;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be at most 2^31 - 1.
 */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int N = A.length;
        int count = 0;

        // Sum A,B and then check all CD combinations
        int sum; int sumCount;
        Map<Integer, Integer> ABMap = new HashMap<>();
        for (int a = 0; a < N; a ++) {
            for (int b = 0; b < N; b ++) {
                sum = A[a] + B[b];
                sumCount = ABMap.getOrDefault(sum, 0);
                ABMap.put(sum, sumCount + 1);
            }
        }
        // Check C,D to compute the count
        for (int c = 0; c < N; c ++) {
            for (int d = 0; d < N; d ++) {
                sum = - C[c] - D[d];
                if (ABMap.containsKey(sum)) count += ABMap.get(sum);
            }
        }

        return count;
    }

    /**
     * Brute force solution
     */
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int N = A.length;
        int count = 0;

        /*
        if(N < 1) return count;

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        if(A[0] + B[0] + C[0] + D[0] > 0 || A[N-1] + B[N-1] + C[N-1] + D[N-1] < 0) return count;
        */
        for (int a = 0; a < N; a ++){
            for (int b = 0; b < N; b ++){
                for (int c = 0; c < N; c ++){
                    for (int d = 0; d < N; d ++) {
                        if (A[a] + B[b] + C[c] + D[d] == 0) ++count;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args){

        new Solution().fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2});
    }

    /*

            while (mid < high){
                sum = nums[low] + nums[mid] + nums[high];
                if(sum < 0) ++mid;
                else if (sum > 0) --high;
                else {
                    results.add(Arrays.asList(nums[low], nums[mid], nums[high]));
                    // Jump through repeated elements
                    while(mid + 1 < high && nums[mid + 1] == nums[mid]) ++mid;
                    while(mid < high - 1 && nums[high - 1] == nums[high]) --high;
                    ++mid; --high;
                }
            }
     */
}
