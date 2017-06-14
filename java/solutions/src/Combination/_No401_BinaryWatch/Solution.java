package Combination._No401_BinaryWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11),
 * and the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 *
 *
 Given a non-negative integer n which represents the number of LEDs that are currently on,
 return all possible times the watch could represent.

 Example:

 Input: n = 1
 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 Note:
 The order of output does not matter.
 The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 */
public class Solution {

    private String formatTime(int time){
        Integer hr =  (time & 0b00000000000000000000001111000000) >> 6;
        Integer min = time & 63;
        if(hr < 12 && min < 60){
            String hrStr = hr > 0 ? hr.toString(): "0";
            return min >9 ? hrStr + ":" + min : hrStr + ":0" + min;
        }
        return null;
    }

    private void backtrack(int startIndex, int level, Integer branch, List<String> results, int targetNum){
        String result;
        for(int i = startIndex; i < 10; i ++){
            int bit = 1 << i;
            branch |= bit;
            if (level + 1 == targetNum) {
                result = formatTime(branch);
                if(result != null) results.add(result);
            }else{
                backtrack(i + 1, level + 1, branch, results, targetNum);
            }
            branch &= ~bit;
        }
    }

    public List<String> readBinaryWatch(int num) {
        List<String> results = new ArrayList<>();

        if(num == 0)
            results.add("0:00");
        else
            backtrack(0, 0, 0, results, num);

        return results;
    }

    public static void main(String[] args){

        new Solution().readBinaryWatch(5);
    }

}
