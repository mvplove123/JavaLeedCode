package amazon.easy;

/**
 * Created by admin on 2018/1/27.
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p/>
 * Example:
 * <p/>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    /**
     * �ݹ�ϲ�
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode newlist;

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            newlist = l1;
            newlist.next = mergeTwoLists(l1.next, l2);

        } else {
            newlist = l2;
            newlist.next = mergeTwoLists(l1, l2.next);
        }

        return newlist;


    }

}