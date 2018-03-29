package amazon.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 2018/3/27.
 */
public class ComplexNumberMultiplicationTest {
    int expecteds = 5;
    ComplexNumberMultiplication  complexNumberMultiplication= new  ComplexNumberMultiplication();
    @Test
    public void test1() {

        String actuals = complexNumberMultiplication.complexNumberMultiply("1+1i","1+1i");
        Assert.assertEquals(expecteds, actuals);
    }
}
