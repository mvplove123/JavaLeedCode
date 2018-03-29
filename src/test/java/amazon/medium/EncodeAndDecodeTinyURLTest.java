package amazon.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by admin on 2018/3/27.
 */
public class EncodeAndDecodeTinyURLTest {

    int expecteds = 5;
    EncodeAndDecodeTinyURL  encodeAndDecodeTinyURL= new  EncodeAndDecodeTinyURL();
    String url = "https://leetcode.com/problems/design-tinyurl";
    @Test
    public void test1() {

        String actuals = encodeAndDecodeTinyURL.encode(url);
        Assert.assertEquals(expecteds, actuals);
    }

}
