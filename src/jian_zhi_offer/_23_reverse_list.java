package jian_zhi_offer;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/5 10:55
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 面试题24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */
/*
两种做法，迭代 && 递归
 */
public class _23_reverse_list {
    // 递归做法 双百
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //迭代做法
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            //这里赋值顺序不能反！！
//            pre = cur;
        }
        return pre;
    }

}
