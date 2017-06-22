package ArrayManipulation._No118_PascalsTriangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class Solution {

    /**
     * Code with spirit
     */
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(1);
            for(int j=i - 1;j > 0;j--)
                row.set(j, row.get(j)+row.get(j-1));
            allrows.add(new ArrayList<>(row));
        }
        return allrows;

    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        ArrayList<Integer> row = new ArrayList<>();
        int oldStore, previous = 1;
        for (int i = 0; i < numRows; i ++){
            row.add(1);
            for (int j = 1; j < i ; j ++){
                oldStore = row.get(j);
                row.set(j, row.get(j) + previous);
                previous = oldStore;
            }
            result.add(new ArrayList<>(row));
        }

        return result;
    }

    public static void main(String[] args){
        new Solution().generate(5);
    }
}
