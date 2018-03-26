package amazon.medium;

import java.util.*;

/**
 * 355 Created by admin on 2018/3/9.
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to
 * see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p/>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed
 * must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to
 * least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 * <p/>
 * Twitter twitter = new Twitter();
 * <p/>
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * <p/>
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * <p/>
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * <p/>
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * <p/>
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * <p/>
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * <p/>
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */

public class DesignTwitter {
    /**
     * Initialize your data structure here.
     */

    private HashMap<Integer, User> userMap;


    public int timeStamp = 0;

    class Tweet {
        public int tweetId;
        public int time;
        public Tweet next;

        public Tweet(int tweetId) {
            this.tweetId = tweetId;
            time = timeStamp++;
            next = null;
        }
    }

    class User {
        public int userId;
        public HashSet<Integer> followed;
        public Tweet tweetHead;

        public User(int userId) {
            this.userId = userId;
            followed = new HashSet<>();
            follow(userId);
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unFollow(int id) {
            followed.remove(id);
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }

    }

    public DesignTwitter() {
        userMap = new HashMap<>();
    }


    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {

        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
     * users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new LinkedList<>();

        if (!userMap.containsKey(userId)) {
            return res;
        }

        HashSet<Integer> users = userMap.get(userId).followed;

        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
        for (int user : users) {
            Tweet tweet = userMap.get(user).tweetHead;
            if (tweet != null) {
                pq.offer(tweet);
            }
        }

        int count = 0;
        while (!pq.isEmpty() && count < 10) {

            Tweet tweet = pq.poll();
            res.add(tweet.tweetId);
            count++;
            if (tweet.next != null) {
                pq.offer(tweet.next);
            }

        }


        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followeeId)) {
            User follower = new User(followerId);
            userMap.put(followeeId, follower);
        }
        if (!userMap.containsKey(followeeId)) {
            User followee = new User(followeeId);
            userMap.put(followeeId, followee);
        }

        userMap.get(followerId).follow(followeeId);


    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {

        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unFollow(followeeId);
    }
}
