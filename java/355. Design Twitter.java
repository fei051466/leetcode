public class Twitter {
    class Tweet {
        int autherID;
        int tweetID;

        Tweet(int autherID, int tweetID) {
            this.autherID = autherID;
            this.tweetID = tweetID;
        }
    }

    List<Tweet> tweetList;
    Map<Integer, Set> userRelation;



    /** Initialize your data structure here. */
    public Twitter() {
        tweetList = new ArrayList<Tweet>();
        userRelation = new HashMap<Integer, Set>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userRelation.containsKey(userId)) {
            Set<Integer> follower = new HashSet<Integer>();
            follower.add(userId);
            userRelation.put(userId, follower);
        }
        Tweet newTweet = new Tweet(userId, tweetId);
        tweetList.add(0, newTweet);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        if (!userRelation.containsKey(userId))
            return res;
        Set<Integer> followees = userRelation.get(userId);
        for (Tweet curTweet: tweetList) {
            if (followees.contains(curTweet.autherID))
                res.add(curTweet.tweetID);
            if (res.size() == 10)
                break;
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followee;
        if (!userRelation.containsKey(followerId)) {
            followee = new HashSet<Integer>();
            followee.add(followerId);
            userRelation.put(followerId, followee);
        }
        if (!userRelation.containsKey(followeeId)) {
            followee = new HashSet<Integer>();
            followee.add(followeeId);
            userRelation.put(followeeId, followee);
        }
        if (userRelation.containsKey(followeeId) && userRelation.containsKey(followerId)) {
            userRelation.get(followerId).add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId && userRelation.containsKey(followeeId) && userRelation.containsKey(followerId)) {
            userRelation.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */