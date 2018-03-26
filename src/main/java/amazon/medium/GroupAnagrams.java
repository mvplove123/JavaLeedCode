package amazon.medium;

import java.util.*;

/**
 * 49. Group Anagrams
 * Created by admin on 2018/3/15.
 * Given an array of strings, group anagrams together.
 * <p/>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p/>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 * 先排序，再用hashmap
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            //排序
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);

            if (map.containsKey(s)) {
                List<String> list = res.get(map.get(s));
                list.add(str);

            } else {
                List<String> list = new ArrayList<>();
                //添加字符串
                list.add(str);
                //放入map里，res.size 记录的是res各个分类的索引，相同的字符串具有相同的索引
                map.put(s, res.size());
                res.add(list);

            }
        }

        return res;
    }
}
