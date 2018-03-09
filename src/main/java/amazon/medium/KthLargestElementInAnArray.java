package amazon.medium;

import java.util.PriorityQueue;

/**
 * 215 Created by admin on 2018/3/7.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p/>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 两种算法非常重要
 */
public class KthLargestElementInAnArray {
    /**
     * quick select
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

            return 0;



    }

    /**
     * 优先队列
     * time :O(nlogk)
     * space:O(n)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {

        //边界判断
        if (nums == null || nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //循环入队列
        for (Integer num : nums) {
            minHeap.offer(num);
            //队列长度大于k，则poll出里面的最小值
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        //最后poll出的最小值就是第K大的值
        return minHeap.poll();

    }

}
