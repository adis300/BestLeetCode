package Bitwise.No461_HammingDistance;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 231.
 * }
 */
public class Solution {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i=0;i<32;i++) count += (xor >> i) & 1;
        return count;
    }

    public int hammingDistance2(int x, int y) {
        x ^= y;
        int count = 0;

        for(int i = 0; i < 32; i ++){
            if((x & 1) == 1) ++ count;
            x >>= 1;
        }
        return count;
    }

}
