package amazon.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/1/19.
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p/>
 * Examples:
 * <p/>
 * s = "leetcode"
 * return 0.
 * <p/>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {

        int[] freq = new int[26];

        //��ÿ���ַ�����Ƶ�μ���
        for (int i = 0; i < s.length(); i++) {

            freq[s.charAt(i) - 'a']++;
        }
        //����Ƶ��Ϊ1�ķ���
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

}