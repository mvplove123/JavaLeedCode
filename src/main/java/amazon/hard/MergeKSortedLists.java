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

        //判断边界
        if (lists == null || lists.length == 0) {
            return null;
        }
        //定义优先队列，排序方式
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        //链表加入队列
        for (ListNode list : lists) {
            if(list !=null){
                queue.add(list);
            }
        }
        //定义返回结果
        ListNode res = new ListNode(0);
        //定义当前链表，初始化为res,相同的引用指向同一个地址
        ListNode cur = res;

        while (!queue.isEmpty()) {
            //弹出队列第一个链表并赋值给cur的下一个节点
            cur.next = queue.poll();
            //更新cur的地址引用
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return res.next;
    }
}
