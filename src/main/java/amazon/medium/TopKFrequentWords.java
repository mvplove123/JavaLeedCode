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
 * You may assume k is always valid, 1 �� k �� number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 * <p/>
 * ����hashmap+priorityQueue
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        List<String> res = new ArrayList<>();
        //ͳ�Ƹ���word������
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 1) + 1);
        }
        //�������ȶ��бȽϸ�ʽ��ֵ��ȣ���Ƚ�key����Ƚ�ֵ
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        //ѭ��map���뵽���ȶ�����
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            //������ȴ���k������ζ�ź����Ԫ�ض�����ȥ
            if (pq.size() > k) {
                pq.poll();
            }
        }
        //ѭ������
        while (!pq.isEmpty()) {
            //pop��ȥ�����뵽list��
            res.add(0, pq.poll().getKey());
        }
        return res;


    }
}
