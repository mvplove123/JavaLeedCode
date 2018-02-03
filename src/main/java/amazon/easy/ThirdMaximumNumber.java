package amazon.easy;

/**
 * 414 Created by admin on 2018/1/30.
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.

 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        //��ʼ��3����
        Integer max1=null,max2 = null, max3 = null;


        for(Integer n :nums){
            //�����ظ�����
            if(n.equals(max1) || n.equals(max2) || n.equals(max3)){
                continue;
            }
            //max1Ϊnull������£����������ֵ���������������λ
            if( max1==null||n>max1){

                max3 = max2;
                max2 = max1;
                max1 = n;
                //С��max1������£�max2Ϊnull����max2�������ֵ��max2֮�����������λ
            }else if (max2== null || n>max2){
                max3= max2;
                max2 = n;
                //С��max2������£�max3Ϊnull����max3�������ֵ
            }else if (max3 == null || n>max3){
                max3 = n;
            }
        }

        //�Ƚ�max3��max1�����max3Ϊnull���򷵻�max1 ���ֵ�����򷵻ص�����ֵmax3
        return max3 == null? max1:max3;

    }

}
