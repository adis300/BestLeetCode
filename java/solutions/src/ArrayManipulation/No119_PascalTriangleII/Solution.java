package ArrayManipulation.No119_PascalTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 1
 11
 121
 1331

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
public class Solution {

    /**
     * Simplest DP problem
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i ++){
            row.add(1);
            for (int j = i-1; j > 0; j --) row.set(j, row.get(j) + row.get(j-1));
        }
        return row;
    }

}
