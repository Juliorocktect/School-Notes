import java.util.*;

public class VideoRecommender {
    private int[][] ratings; // ratings[i][j] = rating of user i for video j
    private String[] users; // user[i] = name of user i
    private String[] videos; // video[i] = name of video i

    public VideoRecommender(int[][] ratings, String[] users, String[] videos) {
        this.ratings = ratings;
        this.users = users;
        this.videos = videos;
    }

    public Set<String> getRecommendations(String userName) {
        int userId = getUserIndex(userName);

        // Calculate user similarities
        double[] similarities = new double[users.length];
        for (int i = 0; i < users.length; i++) {
            similarities[i] = cosineSimilarity(ratings[userId], ratings[i]);
        }

        // Find most similar users
        int[] similarUsers = getMostSimilarUsers(userId, similarities, 3);

        // Generate recommendations
        Set<String> recommendedVideos = new HashSet<>();
        for (int user : similarUsers) {
            for (int j = 0; j < videos.length; j++) {
                if (ratings[user][j] > 0 && ratings[userId][j] == 0) {
                    recommendedVideos.add(videos[j]);
                }
            }
        }
        return recommendedVideos;
    }

    private int getUserIndex(String userName) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(userName)) {
                return i;
            }
        }
        return -1;
    }

    private double cosineSimilarity(int[] a, int[] b) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < a.length; i++) {
            dotProduct += a[i] * b[i];
            normA += a[i] * a[i];
            normB += b[i] * b[i];
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    private int[] getMostSimilarUsers(int userId, double[] similarities, int k) {
        int[] indices = new int[similarities.length];
        for (int i = 0; i < similarities.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingDouble(i -> -similarities[i]));
        int[] similarUsers = new int[k];
        for (int i = 0; i < k; i++) {
            similarUsers[i] = indices[i];
        }
        return similarUsers;
    }

    public static void main(String[] args) {
        int[][] ratings = {
                {5, 4, 0, 3, 2},
                {0, 4, 5, 0, 2},
                {2, 4, 3, 0, 0},
                {4, 0, 0, 5, 3},
                {0, 3, 4, 0, 5}
        };
        String[] users = {"User1", "User2", "User3", "User4", "User5"};
        String[] videos = {"Video1", "Video2", "Video3", "Video4", "Video5"};
        VideoRecommender recommender = 
