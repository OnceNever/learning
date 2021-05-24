package com.yanglei.leetcode.pkg05.DesignTwitter;

import java.util.*;

/**
 * @ClassName: Twitter
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/5/24 16:54
 * @Version: V1.0
 */
public class Twitter {
    private static int timeStamp = 0;
    Map<Integer, User> userMap = new HashMap<>();

    public static class Tweet {
        private int time;
        private Tweet next;
        private int id;

        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }
    public static class User {
        private int uId;
        //用户关注集合
        private Set<Integer> followed;
        //用户发表的推文头节点
        private Tweet head;

        public User(int uId){
            followed = new HashSet<>();
            this.uId = uId;
            this.head = null;
            //关注一下自己
            follow(uId);
        }

        //关注
        void follow(int uId){
            followed.add(uId);
        }

        //取关
        void unFollow(int uId){
            if (uId != this.uId)
                followed.remove(uId);
        }

        //发布
        void post(int tweetId){
            Tweet twt = new Tweet(tweetId, timeStamp);
            timeStamp++;
            twt.next = head;
            head = twt;
        }
    }

    void postTwitter(int uId, int tweetId){
        if (!userMap.containsKey(uId))
            userMap.put(uId, new User(uId));
        User user = userMap.get(uId);
        user.post(tweetId);
    }

    void follow(int followerId, int followeeId){
        if (!userMap.containsKey(followerId))
            userMap.put(followerId, new User(followerId));
        if (!userMap.containsKey(followeeId))
            userMap.put(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    void unFollow(int followerId, int followeeId){
        if (userMap.containsKey(followerId)){
            User user = userMap.get(followerId);
            user.unFollow(followeeId);
        }
    }

    /**返回该 user 关注的人（包括自己）最新的动态id，最多十条，而且这些动态必须按照从新到旧的时间线排序*/
    public List<Integer> getNewsFeed(int uId){
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(uId))
            return res;
        Set<Integer> users = userMap.get(uId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));

        for (Integer id : users){
            Tweet tweet = userMap.get(id).head;
            if (tweet == null) continue;
            pq.add(tweet);
        }

        while (!pq.isEmpty()){
            if (res.size() == 10)break;
            Tweet twt = pq.poll();
            res.add(twt.id);
            if (twt.next != null){
                pq.add(twt.next);
            }
        }
        return res;
    }
}
