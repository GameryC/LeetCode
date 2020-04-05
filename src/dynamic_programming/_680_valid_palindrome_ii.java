package dynamic_programming;

/**
 * @author yangchen
 * @date 2020/3/30 18:41
 */
public class _680_valid_palindrome_ii {
    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length;
        while (i < j) {
            if (arr[i++] != arr[j--]) {
                return isPali(arr, i, j - 1) || isPali(arr, i + 1, j);
            }
        }
        return true;
    }

    private static boolean isPali(char[] arr, int i, int j) {
        while (i < j) {
            if (arr[i++] != arr[j--]) return false;
        }
        return true;
    }

    public static boolean validPalindrome2(String s) {
        if (s == null || s.length() == 0) return false;
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        boolean canRemove = true;
        while (i < j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else {
                if (canRemove) {
                    if (arr[i + 1] == arr[j]) {
                        i++;
                        canRemove = false;
                    } else if (arr[j - 1] == arr[i]){
                        j--;
                        canRemove = false;
                    } else {
                        return false;
                    }
                } else{
                    return false; //
                }
            }
        }
        return true;
    }
}
