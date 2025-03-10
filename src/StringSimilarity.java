import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringSimilarity {

    // Method to calculate Levenshtein distance

    // Method to calculate term frequency vector for a string
    private static Map<String, Integer> termFrequency(String text) {
        Map<String, Integer> termFreq = new HashMap<>();
        for(int i = 0; i < text.length(); i++) {
            termFreq.put(String.valueOf(text.charAt(i)), termFreq.getOrDefault(String.valueOf(text.charAt(i)), 0) + 1);
        }
        return termFreq;
    }

    // Method to calculate cosine similarity between two strings
    public static double cosineSimilarity(String text1, String text2) {
        Map<String, Integer> tf1 = termFrequency(text1);
        Map<String, Integer> tf2 = termFrequency(text2);

        // Create a set of all unique words in both texts
        Set<String> allWords = new HashSet<>();
        allWords.addAll(tf1.keySet());
        allWords.addAll(tf2.keySet());

        // Calculate dot product and magnitudes of vectors
        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;

        for (String word : allWords) {
            int freq1 = tf1.getOrDefault(word, 0);
            int freq2 = tf2.getOrDefault(word, 0);

            dotProduct += freq1 * freq2;
            magnitude1 += Math.pow(freq1, 2);
            magnitude2 += Math.pow(freq2, 2);
        }

        // Calculate cosine similarity
        if (magnitude1 == 0.0 || magnitude2 == 0.0) {
            return 0.0; // Avoid division by zero; implies no words in common
        }
        return dotProduct / (Math.sqrt(magnitude1) * Math.sqrt(magnitude2));
    }
    public static int levenshteinDistance(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        // Create a distance matrix
        int[][] dp = new int[len1 + 1][len2 + 1];

        // Initialize the matrix
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // Fill the matrix
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(
                    Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                    dp[i - 1][j - 1] + cost
                );
            }
        }

        // The distance is the value in the bottom right corner of the matrix
        return dp[len1][len2];
    }

    // Method to calculate similarity percentage
    public static double similarity(String s1, String s2) {
        int maxLength = Math.max(s1.length(), s2.length());
        if (maxLength == 0) {
            return 1.0; // Both strings are empty
        }
        return (1.0 - (double) levenshteinDistance(s1, s2) / maxLength);
    }

    public static void main(String[] args) {
        String s1 = "ao the thao man united";
        String s2 = "ao the thao barca jean";
        System.out.println(similarity(s1, s2));

    }
}
