package amazon.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code
 * Created by admin on 2018/3/16.
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p/>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 * <p/>
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * <p/>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * <p/>
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * <p/>
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * <p/>
 * ������
 * G(i) = i ^ (i/2)
 * time: O(1<<n)/O(n)
 * space:O(1<<n)/O(n)
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {

        List<Integer> res = new ArrayList<>();
        //ѭ����1��n
        for (int i = 0; i < 1 << n; i++) {
            // i/2 == i>>1
            res.add(i ^ i >> 1);
        }
        return res;
    }
}

