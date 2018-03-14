package amazon.hard;

import java.util.HashMap;

/**
 * 146 Created by admin on 2018/3/5.
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 * <p/>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p/>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p/>
 * Example:
 * <p/>
 * LRUCache cache = new LRUCache( 2 capacity )
 * <p/>
 * <p/>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * HashMap + Double Linked List
 * ���룺1�������� -> capacity -> 1,head = null 2,head != null
 * 2������
 * ȡ����1��������
 * 2������
 * => ����
 */

public class LRUCache {

    class Node {

        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private HashMap<Integer, Node> map = null;
    private int capacity;
    private Node head;
    private Node tail;


    public LRUCache(int capacity) {

        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;


    }

    public int get(int key) {

        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        if (node != tail) {

            //�ڵ�Ϊͷ�ڵ�
            if (node == head) {
                //ԭͷ�����ǰ�ƶ�
                head = head.next;
            } else {
                //���¸ýڵ��ǰ��ڵ�����
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            //ԭβ�ڵ�ָ���½ڵ�
            tail.next = node;
            //�½ڵ�ָ��ԭβ�ڵ�
            node.pre = tail;
            //�½ڵ�����null
            node.next = null;
            //�滻ԭβ�ڵ�
            tail = node;

        }
        return node.value;


    }

    public void put(int key, int value) {

        Node node = map.get(key);

        //�ڵ㲻Ϊ��
        if (node != null) {
            //�ڵ����ֵ
            node.value = value;
            //�ж��Ƿ�β�ڵ�
            if (node != tail) {
                //�ڵ�Ϊͷ�ڵ�
                if (node == head) {
                    //ԭͷ�����ǰ�ƶ�
                    head = head.next;
                } else {
                    //���¸ýڵ��ǰ��ڵ�����
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                //ԭβ�ڵ�ָ���½ڵ�
                tail.next = node;
                //�½ڵ�ָ��ԭβ�ڵ�
                node.pre = tail;
                //�½ڵ�����null
                node.next = null;
                //�滻ԭβ�ڵ�
                tail = node;
            }
        } else {
            //�����½ڵ�
            Node newNode = new Node(key, value);
            //���������Ƴ�һ����Ԫ��
            if (capacity == 0) {
                //��ȡͷ��Ԫ��
                Node temp = head;
                //ͷ��Ԫ��ǰ��
                head = head.next;
                //�Ƴ��ɵ�ͷԪ��
                map.remove(temp.key);
                //�ռ��1
                capacity++;
            }
            //��ʼʱ��ֱ�Ӹ���ͷԪ��
            if (head == null && tail == null) {
                head = newNode;
            } else {
                //ԭβ��Ԫ��nextָ����Ԫ��
                tail.next = newNode;
                //��Ԫ��preָ��ԭβ��Ԫ��
                newNode.pre = tail;
                //��Ԫ��nextָ���
                newNode.next = null;

            }
            //�����滻β��Ԫ��
            tail = newNode;
            map.put(key, newNode);
            //�ռ��1
            capacity--;


        }


    }

}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
