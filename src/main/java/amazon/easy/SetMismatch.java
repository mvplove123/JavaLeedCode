package amazon.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 645 Created by admin on 2018/2/2.
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in
 * the set got duplicated to another number in the set, which results in repetition of one number and loss of another
 * number.
 * <p/>
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the
 * number occurs twice and then find the number that is missing. Return them in the form of an array.
 * <p/>
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 * <p/>
 * <p/>
 * [1,2,3,4] 求和 =10
 * [1,2,2,4] 求和 = 9，重复数字2
 * [1,2,4] 的值 = 9-2
 * [3] = 10-(9-2)
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {

        int n = nums.length;
        //正常累计求和
        int sum = n * (n + 1) / 2;
        int duplicatNum = 0;
        Set<Integer> nonDuplicate = new HashSet<>();
        int currentSum = 0;
        //hashset筛选重复数据，同时实际累计求和
        for (int i : nums) {
            if (nonDuplicate.contains(i)) {
                duplicatNum = i;
            }
            currentSum += i;
            nonDuplicate.add(i);
        }
        //非重复数据的和等于实际求和的值减去重复数据的值
        currentSum = currentSum - duplicatNum;
        //缺失值等于正常累计求和-非重复数据的和
        return new int[]{duplicatNum, sum - currentSum};
    }
}
