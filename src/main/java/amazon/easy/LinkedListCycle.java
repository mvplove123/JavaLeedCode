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

        //�߽�����
        if (head == null) {
            return false;
        }
        //��һ��
        ListNode walker = head;
        //������
        ListNode runner = head;

        //����Ϊnull��������
        while (runner.next != null && runner.next.next != null) {

            //һֱ�߲�
            walker = walker.next;
            runner = runner.next.next;
            //�����������ζ������������׷����һ���ģ����л�
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }
}
