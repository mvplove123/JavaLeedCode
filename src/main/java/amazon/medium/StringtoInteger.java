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
 * 考点：边界条件 1、正负号 2、越界 3、字母 " 12v"
 */
public class StringtoInteger {
    public int myAtoi(String str) {

        //边界条件
        if (str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();
        long res = 0;
        int sign = 1;
        int start = 0;
        //正负号首字母
        char firstLetter = str.charAt(0);
        if (firstLetter == '+') {
            sign = 1;
            start++;
        } else if (firstLetter == '-') {
            sign = -1;
            start++;
        }

        //循环每个字符
        for (int i = start; i < str.length(); i++) {
            //字母数字判断
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            //转换数字
            res = res * 10 + str.charAt(i) - '0';
            //越界判断，大于最大值，返回最大值
            if (sign == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            //越界判断，小于最小值，返回最小值
            if (sign == -1 && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }

        }
        //返回结果
        return (int) res * sign;


    }
}
