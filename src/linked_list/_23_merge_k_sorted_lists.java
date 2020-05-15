package linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yangchen
 * @date 2020/4/13 10:56
 */
public class _23_merge_k_sorted_lists {
    // 优先队列，
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int len = lists.length;
        ListNode dummyNode = new ListNode(-1);
        ListNode tail = dummyNode;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(len, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }

        return dummyNode.next;
    }


        // 分治算法
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
//        这里记得是 length - 1!!最后一个的位置，不然越界！
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int begin, int end) {
        if (begin == end) return lists[begin];
        int mid = (end - begin) / 2 + begin;
        ListNode left = mergeKLists(lists, begin, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return mergeTwoList(lists, left, right);
    }

    private ListNode mergeTwoList(ListNode[] lists, ListNode left, ListNode right) {
        if (left == null || right == null) {
            return left == null ? right : left;
        }
        if (left.val < right.val) {
            left.next = mergeTwoList(lists, left.next, right);
            return left;
        } else {
            right.next = mergeTwoList(lists, left, right.next);
            return right;
        }

    }




}
