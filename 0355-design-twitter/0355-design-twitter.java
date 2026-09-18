class Twitter {
    class Tweet implements Comparable<Tweet>{
        int time;
        int tweetId;

        Tweet(int t, int id){
            this.time = t;
            this.tweetId = id;
        }
        public int compareTo(Tweet that){
            return that.time-this.time;
        }
    }

    class User{
        int userId;
        HashSet<Integer> followers;
        List<Tweet> tweets;

        User(int userId){
            this.userId = userId;
            followers = new HashSet<>();
            tweets = new ArrayList<>();
        }

        public void addTweets(Tweet t){
            tweets.add(0, t);
        }

        public void addFollower(int followeeId){
            followers.add(followeeId);
        }

        public void removeFollower(int followeeId){
            followers.remove(followeeId);
        }
    }
    HashMap<Integer, User> map;
    int tc;
    public Twitter() {
        map = new HashMap<>();
        tc = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tc++;
        if(!map.containsKey(userId)){
            map.put(userId, new User(userId));
        }
        User user = map.get(userId);
        user.addTweets(new Tweet(tc, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!map.containsKey(userId)){
            map.put(userId, new User(userId));
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User user = map.get(userId);
        for(int followers:user.followers){
            int count = 0;
            for(Tweet tweet: map.get(followers).tweets){
                pq.offer(tweet);
                count++;
                if(count>=10) break;
            }
        }
        int count = 0;
        for(Tweet tweet:user.tweets){
            pq.offer(tweet);
            count++;
            if(count>=10){
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        while(!pq.isEmpty()&&idx<10){
            res.add(pq.remove().tweetId);
            idx++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!map.containsKey(followerId)){
            map.put(followerId, new User(followerId));
        }
        if(!map.containsKey(followeeId)){
            map.put(followeeId, new User(followeeId));
        }
        User user = map.get(followerId);
        user.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followerId)){
            map.put(followerId, new User(followerId));
        }
        if(!map.containsKey(followeeId)){
            map.put(followeeId, new User(followeeId));
        }
        User user = map.get(followerId);
        user.removeFollower(followeeId);
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