package jian_zhi_offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/9 10:26
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
/*
快排思想；
    partition 返回的位置m，
        m == k - 1 : 前K个数是最小的数
        m < k: m+1 到最后继续partition
        m > k: 开始到 m 继续partition
堆排思想：
    k个容量大跟堆，堆没满加进去，堆满了，比堆顶大的不管，比堆顶小的弹出堆顶，然后加进去
    时间复杂度 O(nlog(k))
 */
public class _40_get_least_numbers {
    // 快排
    public int[] getLeastNumbers(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int index = partation(arr, 0, end);
        while (index != k - 1) {
            if (index < k - 1) {
                partation(arr, index + 1, end);
            } else {
                partation(arr, start, index - 1);
            }
        }
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    private int partation(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1, j = end;
        while (true) {
            while(start < j && arr[j] >= pivot) j--;
            while(i < end && arr[i] <= pivot) i++;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, start, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 堆排 n * log(k)
    public int[] getLeastNumbers2(int[] arr, int k) {
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int num : arr) {
            if(heap.size() < k) {
                heap.add(num);
            } else if (num < heap.peek()){
                heap.poll();
                heap.offer(num);
            }
        }
        int[] res = heap.stream().mapToInt(Integer::intValue).toArray();
        int i = 0;
        for(Integer n : heap) {
            res[i++] = n;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 1,3};
        _40_get_least_numbers solution = new _40_get_least_numbers();
        System.out.println(Arrays.toString(solution.getLeastNumbers2(arr, 2)));
    }
}
