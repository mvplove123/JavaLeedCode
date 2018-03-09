package amazon.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by admin on 2018/3/8.
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p/>
 */
public class SlidingWindowMaximum {
    /**
     * For example,
     * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
     * <p/>
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * Therefore, return the max sliding window as [3,3,5,5,6,7].
     * <p/>
     * Note:
     * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
     * Deque : 存的是index 从大到小排序
     * time : O(n)
     * space : O(n)
     **/
    public int[] maxSlidingWindow(int[] nums, int k) {

        //判断边界条件
        if (nums == null || nums.length == 0) {
            return new int[]{0};
        }
        //定义deque，存的是index 从大到小排序
        Deque<Integer> deque = new LinkedList<>();
        //定义结果数组，长度为nums.length + 1 - k，
        int[] res = new int[nums.length + 1 - k];
        //循环
        for (int i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && deque.peekFirst() == i - k) {

                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.offerLast(i);

            if (i + 1 >= k) {
                res[i + 1 - k] = nums[deque.peek()];
            }

        }
        return res;

    }
}
