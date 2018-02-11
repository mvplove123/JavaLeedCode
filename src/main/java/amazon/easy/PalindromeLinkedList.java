package amazon.easy;

/**
 * Created by admin on 2018/1/26.
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {


    public boolean isPalindrome(ListNode head) {


        if(head ==null || head.next == null){
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){

            fast = fast.next.next;
            slow = slow.next;
        }
        //����ת
        slow = reverse(slow);

        while(head!=null && slow!=null)
        {
            if(head.val!=slow.val){
                return false;
            }
            head= head.next;
            slow=slow.next;
        }
        return true;



    }

    /**
     * ��ת����
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){

        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;

    }


}
