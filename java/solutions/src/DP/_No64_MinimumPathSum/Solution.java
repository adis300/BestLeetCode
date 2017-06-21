package DP._No64_MinimumPathSum;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom
 * right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class Solution {

    /**
     * With out using extra space;
     * @param grid
     * @return
     */

    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++) {
                if  (i == 0 && j == 0) continue; // Do nothing because the grid already has the first item sum
                if (i == 0 && j > 0) grid[i][j] += grid[i][j-1];
                else if (j == 0 && i > 0) grid[i][j] += grid[i - 1][j];
                else{// j > 0
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j-1]);
                }
            }
        }
        return grid[m - 1][n-1];
    }

    /**
     * Original thought process using 1D DP
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[n];
        // row[0] = grid[0][0];

        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++) {
                if (j == 0) row[j] += grid[i][j];
                else{// j > 0
                    if(i == 0) row[j] = row[j - 1] + grid[i][j];
                    else row[j] = Math.min(row[j - 1], row[j]) + grid[i][j];
                }
            }
        }
        return row[n-1];
    }
}
