package two_pointer;

/**
 * @author yangchen
 * @date 2020/4/3 10:06
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class _215_find_Kth_largest {
    /**用堆的办法做的 */
    class Solution{
        public int findKthLargest(int[] nums, int k) {
            //前K个元素原地建小顶堆
            buildHeap(nums, k);
            //遍历剩下元素，比堆顶小，跳过；比堆顶大，交换后重新堆化
            for (int i = k; i < nums.length; i++) {
                if (nums[i] < nums[0]) continue;
                swap(nums, i, 0);
                heapify(nums, k, 0);
            }
            //K个元素的小顶堆的堆顶即是第K大元素
            return nums[0];
        }
        /*** 建堆函数
         * 从倒数第一个非叶子节点开始堆化，倒数第一个非叶子节点下标为 K/2-1 */
        public void buildHeap(int[] a, int k) {
            for (int i = k/2 - 1; i >= 0; i--) {
                heapify(a, k, i);
            }
        }
        /**
         * 堆化函数
         * 父节点下标i，左右子节点的下标分别为 2*i+1 和 2*i+2
         */
        public void heapify(int[] a, int k, int i) {
            //临时变量 minPos 用于存储最小值的下标，先假设父节点最小
            int minPos = i;
            while (true) {
                //和左子节点比较
                if (i*2+1 < k && a[i*2+1] < a[i]) minPos = i*2+1;
                //和右子节点比较
                if (i*2+2 < k && a[i*2+2] < a[minPos]) minPos = i*2+2;
                //如果minPos没有发生变化，说明父节点已经是最小了，直接跳出
                if (minPos == i) break;
                //否则交换
                swap(a, i, minPos);
                //父节点下标进行更新，继续堆化
                i = minPos;
            }
        }

        public void swap(int[] a, int n, int m) {
            int tmp = a[n];
            a[n] = a[m];
            a[m] = tmp;
        }

    }

    //用快排的方法做，23ms，40.3MB
    public int findKthLargest(int[] nums, int k) {
        //一波操作，把第k大的数变成了小的数，正序排列即可。
        k = nums.length - k;
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int j = partation(nums, l, h);
            if (j == k){
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partation(int[] nums, int l, int h) {
        int i = l;
        int j = h + 1;
        while (true) {
            while (nums[++i] < nums[l] && i < h);
            while (nums[--j] > nums[l] && j > l);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}
