package api;

public class TwitterAPI {
    public static class TwitterMetrics {
        public int likes;
        public int retweets;
        public int replies;

        public TwitterMetrics(int likes, int retweets, int replies) {
            this.likes = likes;
            this.retweets = retweets;
            this.replies = replies;
        }
    }

    public String tweet(String texto, String imagemUrl) {
        System.out.println("[Twitter API] Tweetando: " + texto);
        return "tw_" + System.currentTimeMillis();
    }

    public boolean deleteTweet(String tweetId) {
        System.out.println("[Twitter API] Deletando tweet: " + tweetId);
        return true;
    }

    public TwitterMetrics getMetrics(String tweetId) {
        return new TwitterMetrics(150, 45, 23);
    }
}
