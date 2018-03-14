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
 * ������ɻ������ڡ�����Ժ�����
 * j����㣬[j, i)�ĳ��Ⱦ�������
 * set.remove(s.charAt(j++));�൱������[j, i)��߽����һ���1����λ
 * set.add(s.charAt(i)); i++; �൱��[j, i)�ұ߽����һ���1����λ�1�3
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        //�߽��ж�
        if (s == null || s.length() == 0) {
            return 0;
        }
        //����set�����ж�
        HashSet<Character> set = new HashSet<>();
        //��󳤶ȳ�ʼ��
        int res = 0;
        //ѭ���ַ�����i������㣬j�����ظ��ַ�λ��,�����ظ���char����i��ֱ��j�ƶ����Ǹ��ظ���char��remove
        for (int i = 0, j = 0; i < s.length(); ) {
            //set �����ַ�����Ѹ��ַ��Ƴ���j��ǰ�ƶ�1λ
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                //set ������������Ӹ��ַ�����ʱ�̱Ƚϵ�ǰ��size�ͳ��ȣ�ȡ���ֵ
                set.add(s.charAt(i++));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }


}
