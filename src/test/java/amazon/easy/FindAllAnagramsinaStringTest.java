package amazon.easy;

import amazon.easy.FindAllAnagramsinaString;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by admin on 2018/1/18.
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p/>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p/>
 * The order of output does not matter.
 * <p/>
 * Example 1:
 * <p/>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p/>
 * Output:
 * [0, 6]
 * <p/>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p/>
 * Input:
 * s: "abab" p: "ab"
 * <p/>
 * Output:
 * [0, 1, 2]
 * <p/>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsinaStringTest {

    FindAllAnagramsinaString findAllAnagramsinaString = new FindAllAnagramsinaString();
    String s = "cbaebabacd";
    String b = "ab";
    Integer[] expecteds = {0, 6};

    @Test
    public void test1() {
        List<Integer> actuals = findAllAnagramsinaString.findAnagrams1(s,b);
        Assert.assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));

    }

    @Test
    public void test2() {
        List<Integer> actuals = findAllAnagramsinaString.findAnagrams2(s,b);
        Assert.assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));

    }



}
