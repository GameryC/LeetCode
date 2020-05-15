package two_pointer;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/4/30 11:14
 * https://leetcode-cn.com/problems/happy-number/
 */
public class _202_happy_number {
    public boolean isHappy(int n) {
        int slow = getSquareSum(n);
        int fast = getSquareSum(slow);
        while (slow != fast) {
            slow = getSquareSum(slow);
            fast = getSquareSum(fast);
            fast = getSquareSum(fast);
        }
        return slow == 1;
    }

    private int getSquareSum (int n) {
        int sum = 0;
        while (n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n /= 10;
        }
        return sum;
    }
}
