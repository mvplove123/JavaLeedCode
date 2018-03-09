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
    //动态规划
    public boolean wordBreak(String s, List<String> wordDict) {
        //定义Boolean类型数组，加1是考虑substring方法上限
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //按字符串长度循环
        for (int i = 1; i <= s.length(); i++) {
            //一个个截取
            for (int j = 0; j < i; j++) {
                //判断截取的子串是否在list集合里
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        //如果list包含，那么最后一个字符肯定为true
        return dp[s.length()];
    }


}
