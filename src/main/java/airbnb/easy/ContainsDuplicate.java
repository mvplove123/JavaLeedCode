package airbnb.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates.
 * <p/>
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p/>
 * Example 1:
 * <p/>
 * Input: [1,2,3,1]
 * Output: true
 * <p/>
 * Example 2:
 * <p/>
 * Input: [1,2,3,4]
 * Output: false
 * <p/>
 * Example 3:
 * <p/>
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        int len=nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if(set.size()!=len){
            return true;
        }
        return false;



    }
}