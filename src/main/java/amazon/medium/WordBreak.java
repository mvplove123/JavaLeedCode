package amazon.medium;

import java.util.List;

/**
 * Created by admin on 2018/3/5.
 * 139 Word Break
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 * <p/>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p/>
 * Return true because "leetcode" can be segmented as "leet code".
 * <p/>
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 * l e e t c o d e
 */

public class WordBreak {
    //��̬�滮
    public boolean wordBreak(String s, List<String> wordDict) {
        //����Boolean�������飬��1�ǿ���substring��������
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //���ַ�������ѭ��
        for (int i = 1; i <= s.length(); i++) {
            //һ������ȡ
            for (int j = 0; j < i; j++) {
                //�жϽ�ȡ���Ӵ��Ƿ���list������
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        //���list��������ô���һ���ַ��϶�Ϊtrue
        return dp[s.length()];
    }


}
