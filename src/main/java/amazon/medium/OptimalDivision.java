package amazon.medium;

/**
 * 553. Optimal Division
 * Created by admin on 2018/3/28.
 * <p/>
 * Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] ->
 * 2 / 3 / 4.
 * <p/>
 * However, you can add any number of parenthesis at any position to change the priority of operations. You should
 * find out how to add parenthesis to get the maximum result, and return the corresponding expression in string
 * format. Your expression should NOT contain redundant parenthesis.
 * <p/>
 * Example:
 * Input: [1000,100,10,2]
 * Output: "1000/(100/10/2)"
 * Explanation:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 * since they don't influence the operation priority. So you should return "1000/(100/10/2)".
 * <p/>
 * Other cases:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 * Note:
 * <p/>
 * The length of the input array is [1, 10].
 * Elements in the given array will be in range [2, 1000].
 * There is only one optimal division for each test case.
 * <p/>
 * ���⿼����ѧ�� a/(b/c) =a/b*c
 * ������n�����֣�����������ž��ǣ�
 * <p/>
 * x1 / x2 / x3 / ... / xn
 * <p/>
 * ��ô������μ�����ʹ����ֵ����أ���ô���ǽ�x2����ĳ�������ɳ���������ֻ���������ֵ���� a / b / c����������ں��������ϼ������� a / (b / c)��ʵ���Ͼ���a / b *
 * c������b��Զֻ�ܵ�������aҲ��Զֻ�ܵ���������ͬ��x1ֻ�ܵ���������x2ֻ�ܵ�����������x3֮�������ֻҪ���Ƕ������Ϊ��������ô�õ���ֵ�϶������ģ����Ծ�ֻ��һ�ּ����ŵķ�ʽ����:
 * <p/>
 * x1 / (x2 / x3 / ... / xn)
 * <p/>
 * �����Ļ�����ȫ���õݹ��ˣ������ͱ����һ�����򵥵��ַ�����������Ŀ�ˣ�
 */
public class OptimalDivision {
    public String optimalDivision(int[] nums) {

        //�߽������ж�
        String res = "";
        if (nums == null || nums.length == 0) {
            return res;
        }
        //����һ������ʱ
        if (nums.length == 1) {
            return res + nums[0];
        }
        //����2������ʱ
        if (nums.length == 2) {
            return res + nums[0] + "/" + nums[1];
        }
        //����2������ʱ��ƴ���ַ�
        res = res + nums[0] + "/(" + nums[1];
        for (int i = 2; i < nums.length; i++) {
            res = res + "/" + nums[i];
        }

        res = res + ")";
        return res;


    }
}
