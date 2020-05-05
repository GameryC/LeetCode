package jian_zhi_offer;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/5 10:48
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 面试题22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 */
/*
先走K步，然后同时开始走，到前边指针为空，后边指针即为答案。
 */
public class _22_get_Kth_from_end {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode ptr = head;
        while (k-- > 0) {
            if (ptr == null) return null;
            ptr = ptr.next;
        }
        while (ptr != null) {
            head = head.next;
            ptr = ptr.next;
        }
        return head;
    }

}
