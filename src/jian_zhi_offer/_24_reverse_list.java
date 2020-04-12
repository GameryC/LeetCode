package jian_zhi_offer;

/**
 * @author yangchen
 * @date 2020/4/12 16:10
 */
public class _24_reverse_list {
    // 迭代解法，双100
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 递归解法 也是双百
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newList = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newList;
    }

    // 很骚气的方法 双百
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (head.next != null) {
            ListNode tmp = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = tmp;
        }
        return cur;
    }


        private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}

