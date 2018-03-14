package amazon.easy;

/**
 * 189 Created by admin on 2018/1/30.
 * Rotate an array of n elements to the right by k steps.
 * <p/>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p/>
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p/>
 * [show hint]
 * <p/>
 * Related problem: Reverse Words in a String II
 */
public class RotateArray {
    public void rotate1(int[] nums, int k) {

        int temp, previous;
        for (int i = 0; i < k; i++) {

            previous = nums[nums.length - 1];

            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }


        }

    }

    public void rotate2(int[] nums, int k) {


    }

    public void rotate3(int[] nums, int k) {


    }


}
