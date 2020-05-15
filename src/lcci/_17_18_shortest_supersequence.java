package lcci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/4/28 9:13
 * 没全对！！
 * https://leetcode-cn.com/problems/shortest-supersequence-lcci/
 * 面试题 17.18. 最短超串
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 *
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 * 示例 2:
 *
 * 输入:
 * big = [1,2,3]
 * small = [4]
 * 输出: []
 * 提示：
 *
 * big.length <= 100000
 * 1 <= small.length <= 100000
 */
public class _17_18_shortest_supersequence {
    public int[] shortestSeq(int[] big, int[] small) {
        int sLen = small.length;
        int bLen = big.length;
        if (bLen < sLen) return new int[0];
        int[] res = new int[] {0, bLen - 1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num :small) {
            map.put(num, -1);
        }
        int cnt = sLen;
        boolean exist = false;
        for (int i = 0; i < bLen; i++) {
            if (map.containsKey(big[i])) {
                if (map.get(big[i]) == -1) {
                    map.put(big[i], i);
                    cnt--;
                } else {
                    map.put(big[i], i);
                }
                if (cnt == 0) {
                    exist = true;
                    int min = Integer.MAX_VALUE;
                    int max = Integer.MIN_VALUE;
                    for (int index : map.values()) {
                        if (min > index) min = index;
                        if (max < index) max = index;

                        }
                    int oldLen = res[1] - res[0];
                    int newLen = max - min;
                    // 这里是 < ;不是<=; 因为如果同样长度，取坐标小的数
                    // 反例：输入[1, 2, 1, 2, 1, 2] [1, 2]
                    // 应该输出[0,1], 错误输出[4, 5]
                    if (newLen < oldLen) {
                        res[0] = min;
                        res[1] = max;
                    }
                    cnt = sLen;
                    for(Map.Entry entry : map.entrySet()) {
                        entry.setValue(-1);
                    }
//                    System.out.println(map);
                }
            }
        }
        if (!exist) return new int[0];
        return res;

    }

    public static void main(String[] args) {
        int[] big = new int[]{7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int[] small = new int[]{1,5,9};
        _17_18_shortest_supersequence solution = new _17_18_shortest_supersequence();
        System.out.println(Arrays.toString(solution.shortestSeq(big, small)));

    }
}
