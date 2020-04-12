package linked_list;

/**
 * @author yangchen
 * @date 2020/4/12 17:37 -17.40
 */
public class _19_remove_Nth_from_end {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        n = n + 1;
        ListNode ptr = dummyNode, pre = dummyNode;
        while (n > 0) {
            ptr = ptr.next;
            //忘记n--,死循环next 空指针异常！！
            n--;
        }
        while (ptr != null) {
            ptr = ptr.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        //不能直接返回head，因为head有可能是要删除的那个！！
        return dummyNode.next;
    }

}
