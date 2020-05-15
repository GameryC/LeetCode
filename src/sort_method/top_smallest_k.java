package sort_method;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/4/23 1:13
 */
public class top_smallest_k {
    ArrayList arrayList = new ArrayList();
    int[] res;
    public int[] smallestK(int[] input, int k) {
        if (k == 0) return new int[0];
        res = new int[k];
        int left = 0;
        int right = input.length - 1;
//        int mid = partation(input, left, right);
        while (left < right) {
            int mid = partation(input, left, right);
            if (mid == k) break;
            else if (k - 1 < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //变更左右出错！！！
//        while(mid != k - 1) {
//            if (mid > k - 1) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//            mid = partation(input, left, right);
//        }
        for (int i = 0; i < k; i++) {
            res[i] = input[i];
        }
        return res;
    }
    private int partation (int[] input, int start, int end) {
        int pivot = input[start];
        int left = start;
        int right = end;
        while (left < right) {
            while(left < right && input[right] >= pivot) right--;
            while(left < right && input[left] <= pivot) left++;
            if(left < right) {
                int tmp = input[left];
                input[left] = input[right];
                input[right] = tmp;
            }

        }
        input[start] = input[left];
        // input[right] = pivot;
        // return right;
        input[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        top_smallest_k solution = new top_smallest_k();
        int[] arr = new int[]{1,3,5,7,2,4,6,8};
        solution.smallestK(arr, 4);
        Arrays.toString(arr);
    }
}
