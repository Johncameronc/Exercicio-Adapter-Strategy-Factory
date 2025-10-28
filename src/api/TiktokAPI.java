package api;

public class TiktokAPI {
    public static class TikTokAnalytics {
        public int likes;
        public int comments;
        public int shares;
        public int views;

        public TikTokAnalytics(int likes, int comments, int shares, int views) {
            this.likes = likes;
            this.comments = comments;
            this.shares = shares;
            this.views = views;
        }
    }

    public String uploadVideo(String description, String videoUrl) {
        System.out.println("[TikTok API] Fazendo upload: " + description);
        return "tt_" + System.currentTimeMillis();
    }

    public boolean deleteVideo(String videoId) {
        System.out.println("[TikTok API] Deletando vídeo: " + videoId);
        return true;
    }

    public TikTokAnalytics getAnalytics(String videoId) {
        return new TikTokAnalytics(5600, 890, 234, 45000);
    }
}
