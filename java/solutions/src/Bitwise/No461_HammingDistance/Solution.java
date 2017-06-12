package Bitwise.No461_HammingDistance;

/**
 * public int hammingDistance(int x, int y) {
 * int xor = x ^ y, count = 0;
 * for (int i=0;i<32;i++) count += (xor >> i) & 1;
 *    return count;
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
