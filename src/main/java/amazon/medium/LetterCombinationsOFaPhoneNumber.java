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
     * ӳ��mapping
     */
    String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        //�߽��ж�
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(res, digits, "", 0);

        return res;
    }

    private void helper(List<String> res, String digits, String s, int index) {
        //indexΪdigits����������������ĳ��ȵ������ֵĳ���
        if (index == digits.length()) {
            res.add(s);
            return;
        }

        //��ȡ���ֶ�Ӧ�ļ�����ĸ�� eg:2��Ӧabc
        String letters = mapping[digits.charAt(index) - '0'];
        //���ַ���abc����ѭ��
        for (int i = 0; i < letters.length(); i++) {
            helper(res, digits, s + letters.charAt(i), index + 1);
        }


    }


    public List<String> letterCombinations1(String digits) {
        LinkedList<String> res = new LinkedList<>();
        //�߽��ж�
        if (digits == null || digits.length() == 0) {
            return res;
        }
        res.add("");
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {

            //��ȡ��iλ����
            int num = digits.charAt(i) - '0';
            //�ַ����ĳ��ȵ������ֵ�����
            while (res.peek().length() == i) {
                //�Ƴ���ǰ�ַ�����ƴ�����ַ���
                String t = res.remove();
                //��ÿ�����ֶ�Ӧ���ַ�������ö��
                for (char s : mapping[num].toCharArray()) {
                    res.add(t + s);
                }
            }


        }


        return res;
    }


}
