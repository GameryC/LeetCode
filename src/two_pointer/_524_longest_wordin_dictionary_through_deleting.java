package two_pointer;

import java.util.List;

/**524
 * @author yangchen
 * @date 2020/4/3 9:30 -9.55
 * 524. 通过删除字母匹配到字典里最长单词
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1:
 *
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * 输出:
 * "apple"
 * 示例 2:
 *
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * 输出:
 * "a"
 * 说明:
 *
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 */
public class _524_longest_wordin_dictionary_through_deleting {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String target : d) {
            int l1 = longest.length();
            int l2 = target.length();
            if (l1 > l2 || (l1 == l2 && target.compareTo(longest) > 0)) {
                continue;
            }
            if (isSubStr(target, s)) {
                longest = target;
            }
        }
        return  longest;
    }
    //判断子序列的方法
    private boolean isSubStr(String target, String s) {
        if (s.length() < target.length()) return false;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        //这么判断是不对的！！应该让两个下表都有效才能判断
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == target.charAt(j)) {
//                j++;
//            }
//        }
        return j == target.length();
    }


}
