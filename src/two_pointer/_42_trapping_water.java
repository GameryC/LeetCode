package two_pointer;

/**
 * @author yangchen
 * @date 2020/4/4 7:40
 */
public class _42_trapping_water {
    public int trap(int[] height) {
        int sum = 0;
        if (height == null || height.length == 0) return sum;
        int len = height.length;
        int i = 1;
        int j = len - 2;
        int l_max = 0;
        int r_max = 0;
        for (int k = 1; k < len - 1; k++) {
            if (height[i - 1] < height[j + 1]) {
                l_max = Math.max(l_max, height[i - 1]);
                //错误！！不和k比，k只是记个次数，和left、right比！！
//                if (l_max > height[k]) {
//                    sum += l_max - height[k];
//                }
                if (l_max > height[i]) {
                    sum += l_max - height[i];
                }
                i++;
            } else {
                r_max = Math.max(r_max, height[j + 1]);
                if (r_max > height[j]) {
                    sum += r_max - height[j];
                }
                j--;
            }
        }
        return sum;
    }
}
