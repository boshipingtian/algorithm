package io.archie.algorithm.leetcodeClassic;


import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存，最近最少使用缓存
 * <p>
 * 最近最少缓存，get，put方法都是O(1)时间复杂度
 */
public class Code146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));

    }

    /**
     * 我的思路：使用双向链表+hashmap
     * <p>
     * get时，如果此值不在缓存，放回-1，否则返回这个值，并且把它放到双向链表的头
     * <p>
     * put时，如果此值不存在，把值放到双向链表的头部，如果存在，把它移到双向链表头部。
     * 判断是否长度超过了capacity，超过了，就把链表最后一个移除。
     */
    public static class LRUCache {

        private final Map<Integer, LinkedNode> map;

        private final int capacity;

        private final LinkedNode head = new LinkedNode();

        private final LinkedNode tail = new LinkedNode();

        private int length = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            LinkedNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            LinkedNode node = map.get(key);
            if (node == null) {
                // 如果map中不存在key
                LinkedNode newNode = new LinkedNode(key, value);
                // 添加到map
                map.put(key, newNode);
                // 添加到链表头部
                addToHead(newNode);
                length++;
                // 判断长度是否超出
                if (length > capacity) {
                    // 删除最后一个节点数据
                    LinkedNode tailNode = removeTail();
                    // 删除map中的key和value
                    map.remove(tailNode.key);
                    length--;
                }
            } else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.val = value;
                moveToHead(node);
            }
        }

        private void addToHead(LinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(LinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(LinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private LinkedNode removeTail() {
            LinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        public static class LinkedNode {
            public int key;
            public int val;
            public LinkedNode prev;
            public LinkedNode next;

            public LinkedNode() {
            }

            public LinkedNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

    }

}
