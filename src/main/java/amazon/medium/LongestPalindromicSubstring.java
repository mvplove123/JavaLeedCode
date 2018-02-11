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

        //ѭ��ÿһ���ַ�
        for (int i = 0; i < s.length(); i++) {
            //������������
            helper(s, i, i);
            //������ż����
            helper(s, i, i + 1);
        }

        return res;

    }

    public void helper(String s, int left, int right) {

        //�жϻ�����βλ�ã����������ͬʱ����Χ��ֱ�����Ҳ����
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        //��ȡ�ַ���
        String cur = s.substring(left + 1, right);

        if (cur.length() > res.length()) {
            res = cur;
        }

    }


}
