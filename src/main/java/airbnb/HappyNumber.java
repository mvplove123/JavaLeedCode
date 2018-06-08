package airbnb;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p/>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p/>
 * Example:
 * <p/>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {

    public boolean isHappy1(int n){
        Set<Integer> set = new HashSet<>();
        int squreSum,remain;
        while(set.add(n)){
            squreSum=0;
            while(n>0){
                remain = n%10;
                squreSum=remain*remain;
                n=n/10;
            }
            if(squreSum==1){
                return true;
            }else{
                n=squreSum;
            }
        }
        return false;






    }




    public boolean isHappy(int n) {
        int orgNum = n;
        int curNum = n;
        while (curNum > 1) {
            int sum = getSumDigit(curNum);
            if (sum == 1) {
                return true;
            } else if (sum == orgNum) {
                return false;
            } else {
                curNum = sum;
            }
        }
        return true;

    }

    private int getSumDigit(int n) {

        int sum = 0;

        while (n > 0) {
            int x = n % 10;
            sum += x * x;
            n = n / 10;
        }

        return sum;


    }

}