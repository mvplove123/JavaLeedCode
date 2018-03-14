package amazon.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/1/27.
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.
 * <p/>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1
 * must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p/>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p/>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSumIIinputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {


        int begin = 0;
        int end = numbers.length - 1;


        while (begin < end) {
            //比较首尾两值的和大于目标值，则尾值--
            if (numbers[begin] + numbers[end] > target) {
                end--;
                //比较首尾两值的和大于目标值，则首值++

            } else if (numbers[begin] + numbers[end] < target) {
                begin--;

                //两值相等，则跳出循环
            } else {
                break;
            }
        }
        return new int[]{begin + 1, end + 1};


    }

}
