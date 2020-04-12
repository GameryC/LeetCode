package string;

/**
 * @author yangchen
 * @date 2020/4/10 14:52
 */
public class _151_reverse_word_in_string {
    //3ms 71%
    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == ' ') left++;
        while (right > left && s.charAt(right) == ' ') right--;
        StringBuilder sb = new StringBuilder();
        int i = right;
        int j = right;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            String word = s.substring(i + 1, j + 1);
            sb.append(word + " ");
            // 这里要判断 i 的有效性，避免越界！！
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }

    // 1ms 100%
    public String reverseWords2(String s) {
        String[] strs = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0 ; i--) {
            System.out.println(strs[i] + "i: " + i);
            // 这里是"", 中间没有空格，" "是带空格的字符串，""是空字符串！！
            if ("".equals(strs[i])) {
                continue;
            }
            //这里也会损耗时间 结果2ms
//            sb.append(strs[i] + " ");
            //这样比把字符串操作好了要快！！ 结果1ms
            sb.append(strs[i]).append(" ");
        }
        String res = sb.toString();
        //这里要判断，不然""字符串截取-1的话会报错！！
        if ("".equals(res)) return res;
        res = res.substring(0, res.length() - 1);
        return res;
    }



        public static void main(String[] args) {
        _151_reverse_word_in_string solution = new _151_reverse_word_in_string();
        String s = "  Hello   world!";
        System.out.println(solution.reverseWords2(" "));
    }
}
