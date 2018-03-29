package amazon.medium;

import java.util.*;

/**
 * 692. Top K Frequent Words
 * Created by admin on 2018/3/28.
 * Given a non-empty list of words, return the k most frequent elements.
 * <p/>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the
 * word with the lower alphabetical order comes first.
 * <p/>
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 * <p/>
 * 运用hashmap+priorityQueue
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        List<String> res = new ArrayList<>();
        //统计各个word的数量
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 1) + 1);
        }
        //定义优先队列比较格式，值相等，则比较key否则比较值
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        //循环map设入到优先队列里
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            //如果长度大于k，则意味着后面的元素都弹出去
            if (pq.size() > k) {
                pq.poll();
            }
        }
        //循环队列
        while (!pq.isEmpty()) {
            //pop出去并插入到list中
            res.add(0, pq.poll().getKey());
        }
        return res;


    }
}
