package Stack._No85_MaximalRectangle;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 Return 6.

 */
public class Solution {

    public int maximalRectangle(char[][] matrix) {

        int[] heights = new int[matrix[0].length];

        int maxArea = 0;

        for (int i = 0; i< matrix.length; i++){

            for (int j = 0; j < heights.length; j ++){
                if (matrix[i][j] == '1') // Count the height from the previous row
                    heights[j] = heights[j] + 1;
                else // Reset the height
                    heights[j] = 0;
            }

            maxArea = Math.max(maxArea, computeMaxHeight(heights));
        }
        return maxArea;
    }


    public int computeMaxHeight(int[] heights){

        Stack<Integer> locations = new Stack<>();

        int maxArea = 0, i = 0;
        while (i <= heights.length){
            int height = i == heights.length? 0: heights[i];
            if (locations.isEmpty() || height >= heights[locations.peek()])
                locations.push(i++);
            else{
                int previousHeight = heights[locations.pop()];
                maxArea = Math.max(maxArea, previousHeight * (locations.isEmpty()? i: i -1 - locations.peek()));
            }
        }
        return maxArea;
    }

}
