package api;

public class InstagramAPI {
    public static class InstagramInsights {
        public int likes;
        public int comments;
        public int reach;

        public InstagramInsights(int likes, int comments, int reach) {
            this.likes = likes;
            this.comments = comments;
            this.reach = reach;
        }
    }

    public String createPost(String caption, String mediaUrl) {
        System.out.println("[Instagram API] Postando: " + caption);
        return "ig_" + System.currentTimeMillis();
    }

    public boolean removePost(String postId) {
        System.out.println("[Instagram API] Removendo post: " + postId);
        return true;
    }

    public InstagramInsights getInsights(String postId) {
        return new InstagramInsights(320, 89, 1200);
    }
}
