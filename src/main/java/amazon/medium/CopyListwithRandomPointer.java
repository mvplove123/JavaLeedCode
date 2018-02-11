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

        //��hashmap������������
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode cur = head;
        //��ÿһ��Ԫ�ظ��Ƶ�hashmap��
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        //�����Ѿ�ѭ����β��������Ҫ���¸�ֵͷ��
        cur = head;
        //�ٴ�ѭ�����ڹ�����ϵ
        while (cur != null) {
            //��cur��һ���ڵ㸳ֵ��map��cur����һ���ڵ㣬��������
            map.get(cur).next = map.get(cur.next);
            //��cur���������Ӧ��map��Ľڵ㸳ֵ��cur��map�������ڵ�
            map.get(cur).random = map.get(cur.random);
            //curָ����һ���ڵ�
            cur = cur.next;

        }
        //����head���Ǹ��ڵ�
        return map.get(head);


    }

}
