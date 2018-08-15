package airbnb.easy;

import org.junit.*;

public class AddStringsTest {

    AddStrings addStrings = new  AddStrings();
    String nums1 = "35";
    String nums2 = "78";

    @org.junit.Test
    public void test1() {

        String action =addStrings.addStrings(nums1,nums2);
        Assert.assertEquals("113", action);

    }

}