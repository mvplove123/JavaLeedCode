package amazon.medium;

import java.util.PriorityQueue;

/**
 * 215 Created by admin on 2018/3/7.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p/>
 * Note:
 * You may assume k is always valid, 1 �� k �� array's length.
 * �����㷨�ǳ���Ҫ
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
     * ���ȶ���
     * time :O(nlogk)
     * space:O(n)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {

        //�߽��ж�
        if (nums == null || nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //ѭ�������
        for (Integer num : nums) {
            minHeap.offer(num);
            //���г��ȴ���k����poll���������Сֵ
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        //���poll������Сֵ���ǵ�K���ֵ
        return minHeap.poll();

    }

}
