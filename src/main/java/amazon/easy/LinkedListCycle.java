package amazon.easy;

/**
 * 141 Created by admin on 2018/1/27.
 * Given a linked list, determine if it has a cycle in it.
 * <p/>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        //边界条件
        if (head == null) {
            return false;
        }
        //走一步
        ListNode walker = head;
        //走两步
        ListNode runner = head;

        //都不为null的条件下
        while (runner.next != null && runner.next.next != null) {

            //一直走步
            walker = walker.next;
            runner = runner.next.next;
            //如果相遇，意味着走两步的又追上走一步的，则有环
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }
}
