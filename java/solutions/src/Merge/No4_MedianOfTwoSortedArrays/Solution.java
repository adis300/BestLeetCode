package Merge.No4_MedianOfTwoSortedArrays;

import java.util.ArrayList;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */
public class Solution {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0, j = 0;
        int N = nums1.length + nums2.length;
        int isEven = (N + 1) % 2;
        int sortedSize = (N + 1) / 2 + isEven;
        int count = 0;

        int[] max = new int[]{0, 0};

        while (i < nums1.length && j < nums2.length && count < sortedSize) {
            if (nums1[i] < nums2[j]) max[count % 2] = nums1[i++];
            else max[count % 2] = nums2[j++];
            ++count;
        }

        while (i < nums1.length && count < sortedSize) max[count++ % 2] = nums1[i++];
        while (j < nums2.length && count < sortedSize) max[count++ % 2] = nums2[j++];

        if (isEven > 0) return (double) (max[0] + max[1]) / 2;
        return (double) max[(count + 1) % 2];
    }

    ArrayList<Integer> sorted = new ArrayList<>();
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int i = 0, j = 0;
        int N = nums1.length + nums2.length;
        int isEven = (N + 1)%2;
        int sortedSize = N/2 + isEven;

        while (i < nums1.length && j < nums2.length && sorted.size() <= sortedSize){
            if (nums1[i] < nums2[j]) sorted.add(nums1[i++]);
            else sorted.add(nums2[j++]);
        }

        while (i < nums1.length && sorted.size() <= sortedSize) sorted.add(nums1[i ++]);
        while (j < nums2.length && sorted.size() <= sortedSize) sorted.add(nums2[j ++]);

        return ((double)sorted.get(N/2 - isEven)  + (double) sorted.get(N/2)) / 2.0;
    }


    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        int i = 0, j = 0, k = 0;
        int N = nums1.length + nums2.length;
        int[] merged = new int[N];

        int isEven = (N + 1)%2;

        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }

        while (i < nums1.length) merged[k++] = nums1[i++];
        while (j < nums2.length) merged[k++] = nums2[j++];

        return ((double)merged[N/2 - isEven]  + (double) merged[N/2]) / 2.0;
    }


    public static void main(String[] args){
        new Solution().findMedianSortedArrays(new int[]{}, new int[]{1,2,3,4,5});
    }
}
