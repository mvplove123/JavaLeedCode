package amazon.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2018/1/26.
 */
public class BaseballGameTest {

    BaseballGame baseballGame = new  BaseballGame();

    @Test
    public void test1() {

        String [] sdb = {"5","2","C","D","+"};
        int action = baseballGame.calPoints(sdb);
        Assert.assertEquals(30, action);

    }

}
