package amazon.medium;

/**
 * 2 Created by admin on 2018/3/14.
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p/>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p/>
 * Example
 * <p/>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //��ʼ��
        ListNode dummy = new ListNode(0);
        int sum = 0;
        //���¸�ֵ
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        //ѭ��
        while (p1 != null || p2 != null) {
            //�ۼ�p1��ֵ������p1ָ����һ���ڵ�
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            //�ۼ�p2��ֵ������p2ָ����һ���ڵ�
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            //��ʼ����һ���ڵ�
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            //��һ���ڵ���µ�ǰ�ڵ�
            cur = cur.next;
        }
        //û�нڵ�ʱ��������һ��Ϊ��λ�������һ����ֵ
        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
