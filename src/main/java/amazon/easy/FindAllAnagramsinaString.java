package amazon.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2018/1/18.
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p/>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than
 * 20,100.
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
public class FindAllAnagramsinaString {


    public List<Integer> findAnagrams1(String s, String p) {

        int pLength = p.length();
        List<Integer> indices = new ArrayList<>();

        char[] pchars = p.toCharArray();
        Arrays.sort(pchars);
        String sortedp = new String(pchars);

        for (int i = 0; i < s.length(); i++) {
            if (i + pLength > s.length()) {
                break;
            }
            String subs = s.substring(i, i + pLength);
            char[] chars = subs.toCharArray();
            Arrays.sort(chars);
            String sortedsubs = new String(chars);

            if (sortedp.equals(sortedsubs)) {
                indices.add(i);
            }
        }
        return indices;
    }


    public List<Integer> findAnagrams2(String s, String p) {


        List<Integer> list = new ArrayList<>();

        if (s.length() == 0 || s == null || p.length() == 0 || p == null) {
            return list;
        }
        //把p里的每一个字符都记录在hash数组里
        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //两个指针，初始化count 为p的长度
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {

            //如果字符在hash里存在，则count减1，同时right加1，当前值减1
            if (hash[(s.charAt(right++))]-- >= 1) {
                count--;
            }
            //当count为0的时候，意味着找到了子串，添加到list里
            if (count == 0) {
                list.add(left);
            }
            //如果发现right-left 的间隔等于一个p的长度时，则left
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                count++;
            }

        }
        return list;
    }

}
