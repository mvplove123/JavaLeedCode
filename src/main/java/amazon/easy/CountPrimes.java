package amazon.easy;

/**
 * Created by admin on 2018/1/29.
 * Description:����ѧ�����������̬�滮�ȵ��ۺ�Ӧ�á������ĸ������ֻ��1���������
 * <p/>
 * 204 Count the number of prime numbers less than a non-negative number, n.
 * <p/>
 * ����˼·��������ɸѡ��,�ȶ���boolean�������飬�����к�������ֵtrue�������������Ķ���
 */
public class CountPrimes {

    public int countPrimes(int n) {

        boolean[] notPrimes = new boolean[n];

        int count = 0;
        for (int i = 2; i < n; i++) {

            //�Ǻ�����ִ��
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
