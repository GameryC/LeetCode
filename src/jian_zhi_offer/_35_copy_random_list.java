package jian_zhi_offer;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/7 11:07
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 */
/*
1. 在老节点后插入新节点
2. 给新节点的random赋值
3. 提取新链表
 */
public class _35_copy_random_list {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        // 复制插入新节点
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 给新节点赋值random
        cur = head;
        while (cur != null) {
            Node next = cur.next;
            if (cur.random != null) {
                next.random = cur.random.next;
            }
            cur = next.next;
        }
        //提取新链表
        cur = head;
        Node newHead = cur.next;
        // 这个结束条件，在最后一个的时候就停止复制
        while (cur.next != null) {
            Node next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return newHead;
    }

    // Definition for a Node.
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}


