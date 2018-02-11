package amazon.medium;

/**
 * 5 Created by admin on 2018/2/8.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p/>
 * Example:
 * <p/>
 * Input: "babad"
 * <p/>
 * Output: "bab"
 * <p/>
 * Note: "aba" is also a valid answer.
 * <p/>
 * <p/>
 * Example:
 * <p/>
 * Input: "cbbd"
 * <p/>
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    String res = "";

    public String longestPalindrome(String s) {

        //循环每一个字符
        for (int i = 0; i < s.length(); i++) {
            //假设是奇数行
            helper(s, i, i);
            //假设是偶数行
            helper(s, i, i + 1);
        }

        return res;

    }

    public void helper(String s, int left, int right) {

        //判断回文首尾位置，左右相等则同时扩大范围，直接左右不相等
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        //获取字符串
        String cur = s.substring(left + 1, right);

        if (cur.length() > res.length()) {
            res = cur;
        }

    }


}
