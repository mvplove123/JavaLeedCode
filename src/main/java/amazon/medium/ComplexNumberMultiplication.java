package amazon.medium;

import java.util.stream.Stream;

/**
 * 537. Complex Number Multiplication
 * Created by admin on 2018/3/27.
 * Given two strings representing two complex numbers.
 * <p/>
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * <p/>
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * <p/>
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of
 * [-100, 100]. And the output should be also in this form.
 * <p/>
 * This solution relies on the fact that (a+bi)(c+di) = (ac - bd) + (ad+bc)i.
 */
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {

        //按照+和i 进行切分，然后流形式转换int，最后合并成数组
        int[] coefs1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        int[] coefs2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();

        return coefs1[0] * coefs2[0] - coefs1[1] * coefs2[1] + "+" + (coefs1[0] * coefs2[1] + coefs1[1] * coefs2[0]) + "i";


    }
}
