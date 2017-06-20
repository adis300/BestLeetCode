package DP._No63_UniquePathsII;

/**
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.

 */
public class Solution {

    /**
     * More concise java solution
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1; // First position should never be blocked.
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                // If row[j] is blocked, this also includes boundary condition
                if (row[j] == 1) dp[j] = 0;
                    // Otherwise, proceed to dynamic programming of dp table content.
                else if (j > 0) dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] row = new int[n]; // goes down one 1-by-1

        boolean blocked = false;
        for (int i = 0; i < m; i ++){
            // deal with boundary condition for each row
            if (obstacleGrid[i][0] == 0 && !blocked) row[0] = 1;
            else {
                blocked = true;
                row[0] = 0;
            }

            for (int j = 1; j < n; j ++){
                if (obstacleGrid[i][j] == 1){// blocked on the right
                    row[j] = 0;
                }else{
                    row[j] += row[j - 1];
                }
            }
        }

        return row[n - 1];
    }

}
