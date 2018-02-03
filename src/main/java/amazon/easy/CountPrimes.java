package amazon.easy;

/**
 * Created by admin on 2018/1/29.
 * Description:对数学概念、遍历、动态规划等的综合应用。素数的概念，素数只有1和自身的数
 * <p/>
 * 204 Count the number of prime numbers less than a non-negative number, n.
 * <p/>
 * 解题思路：额拉多筛选法,先定义boolean类型数组，对所有合数都赋值true，合数即质数的对立
 */
public class CountPrimes {

    public int countPrimes(int n) {

        boolean[] notPrimes = new boolean[n];

        int count = 0;
        for (int i = 2; i < n; i++) {

            //是合数不执行
            if (notPrimes[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }
        return count;

    }


}
