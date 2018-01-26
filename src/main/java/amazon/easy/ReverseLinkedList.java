package amazon.easy;

/**
 * Created by admin on 2018/1/26.
 */


// * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;

        while (head != null) {

            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;

        }

        return newHead;
    }
}
