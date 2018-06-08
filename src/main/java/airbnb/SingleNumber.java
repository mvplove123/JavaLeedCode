package airbnb;

/**
 * 136. Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p/>
 * Note:
 * <p/>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p/>
 * Example 1:
 * <p/>
 * Input: [2,2,1]
 * Output: 1
 * <p/>
 * Example 2:
 * <p/>
 * Input: [4,1,2,1,2]
 * Output: 4
 * 异或思路，相同为0，不同为1
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {

        int res=0;
        for(int i=0;i<nums.length;i++){
            res^=nums[i];
        }
        return res;


    }
}