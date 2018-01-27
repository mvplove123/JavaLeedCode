package amazon.easy;

/**
 * Created by admin on 2018/1/27.
 * Given a linked list, determine if it has a cycle in it.
 * <p/>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {


        if (head == null) {
            return false;
        }

        ListNode walker = head.next;
        ListNode runner = head.next.next;

        while (runner.next != null && runner.next.next != null) {

            walker = walker.next;
            runner = runner.next.next;

            if (walker == runner) {
                return true;
            }
        }
        return false;


    }
}
