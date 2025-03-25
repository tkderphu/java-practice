package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class design_twitter {
    static class Twitter {
        class Pair {
            Integer tweetId;
            Date posted;

            public Pair(Integer tweetId, Date posted) {
                this.tweetId = tweetId;
                this.posted = posted;
            }
        }
        private final Map<Integer, PriorityQueue<Pair>> mapNewFeeds = new HashMap<>();
        private final boolean[][] follows = new boolean[501][501];
        public Twitter() {

        }

        public void postTweet(int userId, int tweetId) {
            PriorityQueue<Pair> queue = returnPriorityQueue(userId, tweetId);
            mapNewFeeds.put(userId, queue);

        }

        private PriorityQueue<Pair> returnPriorityQueue(int userId, int tweetId) {
            PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
                return o2.posted.compareTo(o1.posted);
            });
            if(mapNewFeeds.containsKey(userId)) {
                queue = mapNewFeeds.get(userId);
            }
            queue.add(new Pair(tweetId, new Date()));
            return queue;
        }

        public List<Integer> getNewsFeed(int userId) {

            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((s1, s2) -> s1.posted.compareTo(s2.posted));
            if(mapNewFeeds.containsKey(userId)) {
                priorityQueue.addAll(mapNewFeeds.get(userId));
            }
            for(int i = 0; i < follows.length; i++) {
                if(follows[userId][i] && mapNewFeeds.containsKey(i)) {
                    priorityQueue.addAll(mapNewFeeds.get(i));
                }
            }
            ArrayList<Integer> arr = new ArrayList<>(priorityQueue.stream().map(x -> x.tweetId).collect(Collectors.toList()));
            return arr;
        }

        public void follow(int followerId, int followeeId) {
            this.follows[followerId][ followeeId] = true;
        }

        public void unfollow(int followerId, int followeeId) {
            this.follows[followerId][ followeeId] = false;

        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        var list = twitter.getNewsFeed(1);
       for(int x : list) {
           System.out.println(x);
       }
    }

}
