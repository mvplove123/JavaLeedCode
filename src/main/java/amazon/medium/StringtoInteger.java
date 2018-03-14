package amazon.medium;

/**
 * 8. String to Integer (atoi)
 * Created by admin on 2018/3/14.
 * Implement atoi to convert a string to an integer.
 * <p/>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask
 * yourself what are the possible input cases.
 * <p/>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to
 * gather all the input requirements up front.
 * <p/>
 * <p/>
 * <p/>
 * Requirements for atoi:
 * <p/>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is
 * found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * <p/>
 * The string can contain additional characters after those that form the integral number, which are ignored and have
 * no effect on the behavior of this function.
 * <p/>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
 * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p/>
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of
 * representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */

/**
 * ���㣺�߽����� 1�������� 2��Խ�� 3����ĸ " 12v"
 */
public class StringtoInteger {
    public int myAtoi(String str) {

        //�߽�����
        if (str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();
        long res = 0;
        int sign = 1;
        int start = 0;
        //����������ĸ
        char firstLetter = str.charAt(0);
        if (firstLetter == '+') {
            sign = 1;
            start++;
        } else if (firstLetter == '-') {
            sign = -1;
            start++;
        }

        //ѭ��ÿ���ַ�
        for (int i = start; i < str.length(); i++) {
            //��ĸ�����ж�
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            //ת������
            res = res * 10 + str.charAt(i) - '0';
            //Խ���жϣ��������ֵ���������ֵ
            if (sign == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            //Խ���жϣ�С����Сֵ��������Сֵ
            if (sign == -1 && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }

        }
        //���ؽ��
        return (int) res * sign;


    }
}
