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

        //�����ַ�������
        int l = s.length();
        //����ѭ��
        for (int i = l / 2; i >= 1; i--) {
            //�����������Ӵ���һ���ǳ����ܱ���������
            if (l % i == 0) {
                //����ó���i���Ӵ��ظ��Ĵ���
                int m = l / i;
                //��ȡ�׸��Ӵ�
                String subS = s.substring(0, i);
                StringBuilder sb = new StringBuilder();

                //���ݴ���ƴ�������ַ���
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                //�ַ�����ԭʼ�ַ�����ͬ���򷵻�true
                if (sb.toString().equals(s)) {
                    return true;
                }

            }

        }
        return false;


    }
}
