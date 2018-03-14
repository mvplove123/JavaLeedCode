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
 * 插入：1，不存在 -> capacity -> 1,head = null 2,head != null
 * 2，存在
 * 取出：1，不存在
 * 2，存在
 * => 排序
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

            //节点为头节点
            if (node == head) {
                //原头结点向前移动
                head = head.next;
            } else {
                //更新该节点的前后节点连接
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            //原尾节点指向新节点
            tail.next = node;
            //新节点指向原尾节点
            node.pre = tail;
            //新节点设置null
            node.next = null;
            //替换原尾节点
            tail = node;

        }
        return node.value;


    }

    public void put(int key, int value) {

        Node node = map.get(key);

        //节点不为空
        if (node != null) {
            //节点更新值
            node.value = value;
            //判断是否尾节点
            if (node != tail) {
                //节点为头节点
                if (node == head) {
                    //原头结点向前移动
                    head = head.next;
                } else {
                    //更新该节点的前后节点连接
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                //原尾节点指向新节点
                tail.next = node;
                //新节点指向原尾节点
                node.pre = tail;
                //新节点设置null
                node.next = null;
                //替换原尾节点
                tail = node;
            }
        } else {
            //创建新节点
            Node newNode = new Node(key, value);
            //无容量，移除一个旧元素
            if (capacity == 0) {
                //获取头部元素
                Node temp = head;
                //头部元素前移
                head = head.next;
                //移除旧的头元素
                map.remove(temp.key);
                //空间加1
                capacity++;
            }
            //初始时，直接更新头元素
            if (head == null && tail == null) {
                head = newNode;
            } else {
                //原尾部元素next指向新元素
                tail.next = newNode;
                //新元素pre指向原尾部元素
                newNode.pre = tail;
                //新元素next指向空
                newNode.next = null;

            }
            //更新替换尾部元素
            tail = newNode;
            map.put(key, newNode);
            //空间减1
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
