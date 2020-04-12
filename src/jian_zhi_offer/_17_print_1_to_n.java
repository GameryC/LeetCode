package jian_zhi_offer;

/**
 * @author yangchen
 * @date 2020/4/7 11:27
 */
public class _17_print_1_to_n {
    public int[] printNumbers(int n) {
        int max = myPow(10, n) - 1;
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    private int myPow(int num, int index) {
        long b = index;
        long res = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                res *= num;
            }
            num *= num;
            b >>= 1;
        }
        return (int)res;
    }


}
