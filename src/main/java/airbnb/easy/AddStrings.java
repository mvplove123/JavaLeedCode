package airbnb.easy;

/**
 * 415. Add Strings
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p/>
 * Note:
 * <p/>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        //循环的时候，进位要考虑到
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >=
                0 || carry == 1; i--, j--) {
            //获取当前位置的值，如果循环到i<0,或者j<0，则默认值为0
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            //添加当前值
            sb.append((x + y + carry) % 10);
            //获取进位
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}