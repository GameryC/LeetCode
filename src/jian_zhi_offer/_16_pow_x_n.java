package jian_zhi_offer;

/**
 * @author yangchen
 * @date 2020/4/7 10:02
 */

public class _16_pow_x_n {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        // 当 n == -2147483648时，转为整数超出了int 的范围！！
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        double res = 1; //错的点！！类型不能用 int , 用double
        while (b > 0) {
            if ((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = -2147483648;
        System.out.println(n);
//        n = -n;
        System.out.println(-n);
        int one = 1;
        System.out.println(one);
        System.out.println(-one);
        int big = 2147483647;
        System.out.println(big);
        System.out.println(big + 1);
        System.out.printf("%64s",Integer.toBinaryString(big));
        System.out.format("%64s", Integer.toBinaryString(big));
//        Integer ibig = 2147483647;
//        System.out.println();
    }
}
