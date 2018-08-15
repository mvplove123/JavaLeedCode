package amazon.medium;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 451. Sort Characters By Frequency
 * Created by admin on 2018/3/27.
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * Example 1:
 * <p/>
 * Input:
 * "tree"
 * <p/>
 * Output:
 * "eert"
 * <p/>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p/>
 * Input:
 * "cccaaa"
 * <p/>
 * Output:
 * "cccaaa"
 * <p/>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p/>
 * Input:
 * "Aabb"
 * <p/>
 * Output:
 * "bbAa"
 * <p/>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * 结合hashmap 和优先队列（用于排序）
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        //边界判断
        if (s == null || s.length() == 0) {
            return "";
        }
        //存入字符，hashmap key:字符，value:重复字符  abcb->(b,bb)
        HashMap<Character, StringBuilder> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, new StringBuilder()).append(c));
        }

        //按照长度定义排序
        PriorityQueue<StringBuilder> pq = new PriorityQueue<>((a, b) -> (b.length() - a.length()));
        //把所有value加入队列里
        pq.addAll(map.values());

        StringBuilder res = new StringBuilder();
        //循环队列poll出来
        while (!pq.isEmpty()) {
            res.append(pq.poll());
        }
        return res.toString();
    }
}
