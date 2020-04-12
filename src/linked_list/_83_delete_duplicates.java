package linked_list;

/**
 * @author yangchen
 * @date 2020/4/12 17:30
 */
public class _83_delete_duplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return temp;
    }
}
