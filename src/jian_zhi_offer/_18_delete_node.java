package jian_zhi_offer;

/**
 * @author yangchen
 * @date 2020/4/7 11:36
 */
public class _18_delete_node {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode pre = head;
        ListNode cur = head.next;
//        while (cur != null && cur.val != val) {
        while (cur != null) {
            if (cur.val == val) break;
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */