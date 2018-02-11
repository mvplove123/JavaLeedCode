package amazon.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 127 Created by admin on 2018/2/8.
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p/>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 * <p/>
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p/>
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * UPDATE (2017/1/20):
 * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

 采用BFS算法（通常用队列实现）

 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //list 转set并移除beginWord
        HashSet<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        //定义队列
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        //放入beginword
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            //弹出队列里的word
            String word = queue.poll();
            curNum--;
            //对word的每个字符进行循环
            for (int i = 0; i < word.length(); i++) {

                char[] wordUnit = word.toCharArray();
                //对每个元素进行替换
                for (char j = 'a'; j < 'z'; j++) {
                    wordUnit[i] = j;
                    //生成临时新字符
                    String temp = new String(wordUnit);
                    //如果set包含字符串并且匹配上endword，返回level+1
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) {
                            return level + 1;
                        }
                    }

                    nextNum++;
                    queue.offer(temp);
                    set.remove(temp);
                }
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }

        }

        return 0;
    }
}
