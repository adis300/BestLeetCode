package DP._No62_UniquePath;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * Note: m and n will be at most 100.
 */
public class Solution {


    /**
     * Much simplified DP
     */

    public int uniquePaths(int m, int n){
        int[] row = new int[m];
        row[0] = 1; // Set boundary condition

        for (int i = 0; i < n; i++){ // Compute for each row, so start from zero.
            for (int j = 1; j < m; j++){ // Compute only the connections
                row[j] += row[j-1];
            }
        }

        return row[m - 1];
    }

    /**
     * Use DP
     */
    public int uniquePaths1(int m, int n) {
        int[][] path = new int[m][n];
        for (int j = 0; j < path[0].length; j ++)
            path[0][j] = 1;
        for (int i = 1; i < m; i ++){
            path[i][0] = 1; // Set boundary condition
        }

        for (int i =1; i < m; i ++){ // Path is the bridge connecting two squares.
            for (int j = 1; j < n; j ++){
                path[i][j] = path[i - 1][j] + path[i][j-1];
            }
        }
        return path[m-1][n-1];

    }

    /**
     * Stupid recursive call
     */
    int resultCount = 0;
    int m,n;

    public int uniquePaths2(int m, int n) {
        this.m = m;
        this.n = n;

        traverse(1, 1);
        return resultCount;
    }

    public void traverse(int x, int y){
        if ( x == m && n == y) {
            ++ resultCount;
            return;
        }
        if (x < m) traverse(x + 1, y);
        if (y < n) traverse(x, y + 1);
    }

}
