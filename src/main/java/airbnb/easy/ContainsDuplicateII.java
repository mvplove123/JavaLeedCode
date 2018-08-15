package airbnb.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**219. Contains Duplicate II
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * <p/>
 * Example 1:
 * <p/>
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * <p/>
 * Example 2:
 * <p/>
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * <p/>
 * Example 3:
 * <p/>
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        //k 用来限制长度，超过k肯定为false,去掉首部，向前移动
        for(int i=0;i<nums.length;i++){
            if(i>k){
                set.remove(nums[i-k-1]);
            }
            //如果set.add 方法返回false ,意味着存在，前面设置否定则return true
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;

    }
}