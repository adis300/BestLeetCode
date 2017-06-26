package Bitwise._No137_SingleNumberII;

/**
 * Given an array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution {

    // Java bitwise manipulation.
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;

        for (int i = 0; i < nums.length; i++) {
            // twos holds the num that appears twice， (ones 记录到当前变量为止)这点很重要，先用之前的ones 算 twos
            twos |= ones & nums[i];

            // ones holds the num that appears once, 假设之前都是0, 假装算一遍twos.
            ones ^= nums[i];

            // threes holds the num that appears three times
            threes = ones & twos;

            // if num[i] appears three times
            // doing this will clear ones and twos
            ones &= ~threes;
            twos &= ~threes;
        }

        return ones;
    }

    public int singleNumber1(int[] nums) {
        // Solve with map using linear space

        return 0;
    }
    // bit-by-bit construction
    int singleNumber2(int A[], int n)
    {
        int ans = 0;
        for (int i = 0; i < 32; i++)
        {
            int cnt = 0, bit = 1 << i;
            for (int j = 0; j < n; j++)
            {
                if ((A[j] & bit) == 1) cnt++;
            }
            if (cnt % 3 != 0)
                ans |= bit;
        }
        return ans;
    }

}
