package amazon.medium;

import java.util.HashSet;

/**
 * 3 Created by admin on 2018/3/14.
 * Given a string, find the length of the longest substring without repeating characters.
 * <p/>
 * Examples:
 * <p/>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p/>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p/>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * Given "aab", the answer is "ab", with the length of 2.
 * <p/>
 * “抽象成滑动窗口”就相对好理解多
 * j是起点，[j, i)的长度就是所求
 * set.remove(s.charAt(j++));相当于区间[j, i)左边界向右滑动1个单位
 * set.add(s.charAt(i)); i++; 相当于[j, i)右边界向右滑动1个单位﻿
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        //边界判断
        if (s == null || s.length() == 0) {
            return 0;
        }
        //运用set进行判断
        HashSet<Character> set = new HashSet<>();
        //最大长度初始化
        int res = 0;
        //循环字符串，i代表起点，j代表重复字符位置,遇到重复的char不动i，直到j移动到那个重复到char并remove
        for (int i = 0, j = 0; i < s.length(); ) {
            //set 包含字符，则把该字符移除，j向前移动1位
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                //set 不包含，则添加该字符，并时刻比较当前的size和长度，取最大值
                set.add(s.charAt(i++));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }


}
