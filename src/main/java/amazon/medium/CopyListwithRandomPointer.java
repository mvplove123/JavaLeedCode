package amazon.medium;

/**
 * 138 Created by admin on 2018/2/6.
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p/>
 * Return a deep copy of the list.
 */


import java.util.HashMap;
import java.util.Random;

/**
 * Definition for singly-linked list with a random pointer.
 */

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {

        //用hashmap进行链表连接
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode cur = head;
        //把每一个元素复制到hashmap里
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        //由于已经循环到尾部，所以要重新赋值头部
        cur = head;
        //再次循环用于关联关系
        while (cur != null) {
            //把cur下一个节点赋值给map里cur的下一个节点，连接起来
            map.get(cur).next = map.get(cur.next);
            //把cur的随机数对应的map里的节点赋值给cur在map里的随机节点
            map.get(cur).random = map.get(cur.random);
            //cur指向下一个节点
            cur = cur.next;

        }
        //返回head的那个节点
        return map.get(head);


    }

}
