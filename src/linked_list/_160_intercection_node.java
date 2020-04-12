package linked_list;


import jian_zhi_offer._24_reverse_list;

/**
 * @author yangchen
 * @date 2020/4/12 16:53
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class _160_intercection_node {

    // 不能直接用 这两个头结点，因为要更新时候用！！
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 带着第一行，2ms, 不带1ms
        if (headA == null && headB == null) return null;
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l2;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
