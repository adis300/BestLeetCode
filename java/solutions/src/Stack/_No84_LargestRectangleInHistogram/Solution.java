package Stack._No84_LargestRectangleInHistogram;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.


 */
public class Solution {

    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0, i = 0;
        while(i <= len){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i++);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
            }
        }
        return maxArea;
    }

    /**
     * Brute force solution
     */
    public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        // For each position, try to expand to next
        for (int i = 0; i < heights.length; i ++){
            int minHeight = heights[i];
            int area = heights[i];
            for (int j = i;j < heights.length; j ++){
                minHeight = Math.min(heights[j], minHeight);
                int newArea = (j-i + 1) * minHeight;
                if (newArea > area) area = newArea;
            }
            if (area > maxArea) maxArea = area;
        }
        return maxArea;
    }

    public static void main(String[] args){
        new Solution().largestRectangleArea(new int[]{1,10,5,100});
    }

}
