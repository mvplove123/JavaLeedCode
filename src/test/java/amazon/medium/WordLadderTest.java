package amazon.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/2/9.
 */
public class WordLadderTest {
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = new ArrayList<>();



    int expecteds = 5;
    WordLadder  wordLadder = new  WordLadder();

    @Test
    public void test1() {
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        int actuals = wordLadder.ladderLength(beginWord,endWord,wordList);
        Assert.assertEquals(expecteds, actuals);
    }
}
