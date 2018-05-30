package amazon.hard;

/**
 * Created by admin on 2018/4/12.
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * time : O(nlogk) where k is the number of linked lists
 * space : O(n)
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        //�жϱ߽�
        if (lists == null || lists.length == 0) {
            return null;
        }
        //�������ȶ��У�����ʽ
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        //����������
        for (ListNode list : lists) {
            if(list !=null){
                queue.add(list);
            }
        }
        //���巵�ؽ��
        ListNode res = new ListNode(0);
        //���嵱ǰ������ʼ��Ϊres,��ͬ������ָ��ͬһ����ַ
        ListNode cur = res;

        while (!queue.isEmpty()) {
            //�������е�һ��������ֵ��cur����һ���ڵ�
            cur.next = queue.poll();
            //����cur�ĵ�ַ����
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return res.next;
    }
}
