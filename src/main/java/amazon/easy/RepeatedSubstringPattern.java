package amazon.easy;

/**
 * Created by admin on 2018/2/5.
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies
 * of the substring together. You may assume the given string consists of lowercase English letters only and its
 * length will not exceed 10000.
 * Example 1:
 * Input: "abab"
 * <p/>
 * Output: True
 * <p/>
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * <p/>
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * <p/>
 * Output: True
 * <p/>
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {

        //计算字符串长度
        int l = s.length();
        //半数循环
        for (int i = l / 2; i >= 1; i--) {
            //符合条件的子串，一定是长度能被整除的数
            if (l % i == 0) {
                //计算该长度i的子串重复的次数
                int m = l / i;
                //获取首个子串
                String subS = s.substring(0, i);
                StringBuilder sb = new StringBuilder();

                //根据次数拼接整个字符串
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                //字符串和原始字符串相同，则返回true
                if (sb.toString().equals(s)) {
                    return true;
                }

            }

        }
        return false;


    }
}
