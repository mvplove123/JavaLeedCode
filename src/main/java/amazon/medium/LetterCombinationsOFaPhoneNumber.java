package amazon.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 17 Created by admin on 2018/2/6.
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p/>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOFaPhoneNumber {

    /**
     * 映射mapping
     */
    String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        //边界判断
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(res, digits, "", 0);

        return res;
    }

    private void helper(List<String> res, String digits, String s, int index) {
        //index为digits的索引，如果索引的长度等于数字的长度
        if (index == digits.length()) {
            res.add(s);
            return;
        }

        //获取数字对应的键盘字母串 eg:2对应abc
        String letters = mapping[digits.charAt(index) - '0'];
        //对字符串abc进行循环
        for (int i = 0; i < letters.length(); i++) {
            helper(res, digits, s + letters.charAt(i), index + 1);
        }


    }


    public List<String> letterCombinations1(String digits) {
        LinkedList<String> res = new LinkedList<>();
        //边界判断
        if (digits == null || digits.length() == 0) {
            return res;
        }
        res.add("");
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {

            //获取第i位数字
            int num = digits.charAt(i) - '0';
            //字符串的长度等于数字的索引
            while (res.peek().length() == i) {
                //移除当前字符用于拼接新字符串
                String t = res.remove();
                //对每个数字对应的字符串进行枚举
                for (char s : mapping[num].toCharArray()) {
                    res.add(t + s);
                }
            }


        }


        return res;
    }


}
