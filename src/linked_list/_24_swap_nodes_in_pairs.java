package linked_list;

import java.util.LinkedHashMap;

/**
 * @author yangchen
 * @date 2020/4/12 18:25
 */
public class _24_swap_nodes_in_pairs {
    // 递归解法
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }

    //迭代解法
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode first = null, second = null;
        ListNode pre = dummyNode;
        while (head != null && head.next != null) {
            first = head;
            second = head.next;

            pre.next = second;
            first.next = second.next;
            second.next = first;

            pre = first;
            //head 更新出错！！应该是first.next
//            head = second;
            head = first.next;
        }

        return dummyNode.next;
    }
}
