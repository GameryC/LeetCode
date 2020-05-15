package binary_search;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/4/27 12:29
 */
public class _153_find_minimum_in_rotated_sorted_array {
    public int findMin(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                //这里不能-1，因为最小值可能就错过了
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
