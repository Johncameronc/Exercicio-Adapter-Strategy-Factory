package api;

public class LinkedinAPI {
    public static class LinkedInStats {
        public int reactions;
        public int comments;
        public int shares;
        public int impressions;

        public LinkedInStats(int reactions, int comments, int shares, int impressions) {
            this.reactions = reactions;
            this.comments = comments;
            this.shares = shares;
            this.impressions = impressions;
        }
    }

    public String share(String content, String imageUrl) {
        System.out.println("[LinkedIn API] Compartilhando: " + content);
        return "li_" + System.currentTimeMillis();
    }

    public boolean delete(String shareId) {
        System.out.println("[LinkedIn API] Deletando: " + shareId);
        return true;
    }

    public LinkedInStats getStats(String shareId) {
        return new LinkedInStats(95, 12, 8, 450);
    }
}
