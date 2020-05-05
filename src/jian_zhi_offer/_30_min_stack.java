package jian_zhi_offer;

import java.util.Stack;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/5 16:48
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 面试题30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 *
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 */
public class _30_min_stack {
    Stack<Integer> data, help;
    /** initialize your data structure here. */
    public _30_min_stack() {
        data = new Stack<>();
        help = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        // 这里要加 为空的判断！！
        if (help.isEmpty() || help.peek() >= x)
            help.push(x);
    }

    public void pop() {
        if (data.pop().equals(help.peek()))
            help.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return help.peek();
    }
}
//1.借助辅助栈
// class MinStack {
//     Stack<Integer> stack;
//     Stack<Integer> helper;
//     /** initialize your data structure here. */
//     public MinStack() {
//         stack = new Stack<Integer>();
//         helper = new Stack<Integer>();
//     }

//     public void push(int x) {
//         stack.push(x);
//         if(helper.isEmpty() || helper.peek() > x){
//             helper.push(x);
//         }else{
//             helper.push(helper.peek());
//         }
//     }

//     public void pop() {
//         if(stack.isEmpty()){
//             return;
//         }else{
//             stack.pop();
//             helper.pop();
//         }
//     }

//     public int top() {
//         if(!stack.isEmpty()) return stack.peek();
//         return -1;
//     }

//     public int min() {
//         if(!helper.isEmpty()){
//             return helper.peek();
//         }else{
//             return -1;
//         }
//     }
// }


//2.只用一个栈实现
// class MinStack {
//     Stack<Integer> stack;
//     int min = Integer.MAX_VALUE;
//     /** initialize your data structure here. */
//     public MinStack() {
//         stack = new Stack<Integer>();
//     }

//     public void push(int x) {
//         if(x > min){
//             stack.push(x);
//         }else{//等号应该包含在这里
//             //出现新的最小元素，先把上一个min压入栈保存 再压入x
//             stack.push(min);
//             min = x;
//             stack.push(x);
//         }
//     }

//     public void pop() {
//         if(stack.isEmpty()){
//             return;
//         }else{
//             //当前要出栈的元素是最小元素，要把上一个最小元素还原
//             if(stack.peek() == min){
//                 stack.pop();
//                 min = stack.pop();
//             }else{
//                 stack.pop();
//             }
//         }
//     }

//     public int top() {
//         if(!stack.isEmpty()){
//             return stack.peek();
//         }else{
//             return -1;
//         }
//     }

//     public int min() {
//         return min;
//     }
// }

//4.链表
//class MinStack {
//    class Node{
//        int value;
//        int min;
//        Node next;
//
//        Node(int x, int min){
//            this.value = x;
//            this.min = min;
//            next = null;
//        }
//    }
//    Node head;
//    /** initialize your data structure here. */
//    public MinStack() {
//
//    }
//
//    public void push(int x) {
//        if(head == null){
//            head = new Node(x,x);
//        }else{
//            //当前值和之前头结点的最小值较小的做为当前的 min
//            Node n = new Node(x, Math.min(x, head.min));
//            n.next = head;
//            head = n;
//        }
//    }
//
//    public void pop() {
//        if(head != null){
//            head = head.next;
//        }
//    }
//
//    public int top() {
//        if(head != null){
//            return head.value;
//        }
//        return -1;
//    }
//
//    public int min() {
//        if(head != null){
//            return head.min;
//        }
//        return -1;
//    }
//}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */