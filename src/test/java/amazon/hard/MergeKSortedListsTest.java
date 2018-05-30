package amazon.hard;

import amazon.medium.WordLadder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/4/12.
 */
public class MergeKSortedListsTest {


    int expecteds = 5;
    MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

    @Test
    public void test1() {


        ListNode[] lists = new ListNode[3];
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(10);
        a.next = b;
        b.next = c;

        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(6);
        e.next = f;
        f.next = g;

        ListNode h = new ListNode(7);
        ListNode i = new ListNode(8);
        ListNode j = new ListNode(9);
        h.next = i;
        i.next = j;

        lists[0] = a;
        lists[1] = h;
        lists[2] = e;


        ListNode actuals = mergeKSortedLists.mergeKLists(lists);
        Assert.assertEquals(expecteds, actuals);
    }

}
