package amazon.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/2/2.
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p/>
 * For example, given k = 3,
 * Return [1,3,3,1].
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) {
            return list;
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            //首部都为1
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;


    }

}
