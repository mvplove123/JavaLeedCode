package airbnb.special;

import java.util.HashMap;
import java.util.Map;

public class CollatzConjecture {

    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        CollatzConjecture collatzConjecture = new CollatzConjecture();
        int steps = collatzConjecture.getLongSteps(7);
        System.out.println(steps);
    }

    private int getLongSteps(int nums) {
        if (nums < 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums; i++) {
            int t = findSteps(i);
            map.put(i, t);
            res = Math.max(res, t);
        }
        return res;
    }

    private int findSteps(int num) {

        if (num <= 1) {
            return 1;
        }
        if (num % 2 == 0) {
            return 1 + findSteps(num / 2);
        } else {
            return 1 + findSteps(3 * num + 1);
        }

    }


}