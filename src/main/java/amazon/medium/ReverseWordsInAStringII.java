package amazon.medium;

/**
 * Created by admin on 2018/3/6.
 * <p/>
 * 186. Reverse Words in a String II
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the"
 */
public class ReverseWordsInAStringII {

    public void reverseWords(char[] s) {
        //全部颠倒
        reverse(s, 0, s.length - 1);
        int r = 0;

        while (r < s.length) {
            int l = r;
            //截取空格
            while (r < s.length && s[r] != ' ') {
                r++;
            }
            reverse(s, l, r - 1);
            r++;
        }


    }

    /***
     * 字符串颠倒  the sky-> yks eht
     *
     * @param s
     * @param i
     * @param j
     */
    private void reverse(char[] s, int i, int j) {

        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }


}
