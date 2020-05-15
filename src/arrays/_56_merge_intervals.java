package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangchen
 * @date 2020/4/16 14:49 - 15.12
 */
public class _56_merge_intervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        int len = intervals.length;
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) { //重合了，把前边的整合到后边去
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
            } else { // 没有重合，直接把当前的加入结果
                list.add(intervals[i]);
            }
        }
        // 最后一个要记得加进去
        list.add(intervals[len - 1]);

        // list.toArray() 方法！！
        return list.toArray(new int[list.size()][2]);
    }
}
