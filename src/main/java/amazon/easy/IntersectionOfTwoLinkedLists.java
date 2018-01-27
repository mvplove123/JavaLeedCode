package amazon.easy;

/**
 * Created by admin on 2018/1/27.
 *
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
                     ↘
                     c1 → c2 → c3
                     ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        //循环链表，知道长度相等
        while(lenA<lenB){
            headB=headB.next;
            lenB--;
        }
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }

        //长度相等的链表，进行值比较，不相等，同时循环下一个
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;

    }

    /**
     * 获取链表的长度
     * @param head
     * @return
     */
    public int getListLength(ListNode head){

        int length=0;

        while(head!=null){
            head=head.next;
            length++;
        }
        return length;

    }


}
