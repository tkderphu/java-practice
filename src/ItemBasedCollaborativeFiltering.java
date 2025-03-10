import java.util.*;
import java.util.stream.Collectors;

public class ItemBasedCollaborativeFiltering {

    // Data structure to hold user ratings (user_id -> item_id -> rating)
    private Map<Integer, Map<Integer, Double>> userRatings;

    // Data structure to hold item similarity matrix (item_id -> item_id -> similarity)
    private Map<Integer, Map<Integer, Double>> itemSimilarity;

    public ItemBasedCollaborativeFiltering(Map<Integer, Map<Integer, Double>> userRatings) {
        this.userRatings = userRatings;
        this.itemSimilarity = new HashMap<>();
    }

    // Calculate similarity between items using cosine similarity
    private double calculateCosineSimilarity(Map<Integer, Double> ratingsA, Map<Integer, Double> ratingsB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        for (Integer userId : ratingsA.keySet()) {
            if (ratingsB.containsKey(userId)) {
                dotProduct += ratingsA.get(userId) * ratingsB.get(userId);
            }
            normA += Math.pow(ratingsA.get(userId), 2);
        }

        for (Double rating : ratingsB.values()) {
            normB += Math.pow(rating, 2);
        }

        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    // Calculate item similarity matrix
    public void calculateItemSimilarity() {
        Set<Integer> items = new HashSet<>();
        userRatings.values().forEach(itemsMap -> items.addAll(itemsMap.keySet()));

        for (Integer itemA : items) {
            itemSimilarity.putIfAbsent(itemA, new HashMap<>());
            for (Integer itemB : items) {
                if (!itemA.equals(itemB)) {
                    double similarity = calculateCosineSimilarity(
                        getItemRatings(itemA), getItemRatings(itemB));
                    System.out.println(String.format("%s - %s -> %s", itemA, itemB, similarity));
                    itemSimilarity.get(itemA).put(itemB, similarity);
                }
            }
        }
    }

    // Get ratings for a specific item
    private Map<Integer, Double> getItemRatings(Integer itemId) {
        return userRatings.entrySet().stream()
            .filter(entry -> entry.getValue().containsKey(itemId))
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get(itemId)));
    }

    // Recommend items for a user based on item similarity
    public List<Integer> recommendItems(Integer userId, int numRecommendations) {
        Map<Integer, Double> userItems = userRatings.getOrDefault(userId, Collections.emptyMap());
        Map<Integer, Double> recommendedItems = new HashMap<>();

        for (Map.Entry<Integer, Double> entry : userItems.entrySet()) {
            Integer item = entry.getKey();
            Double rating = entry.getValue();

            itemSimilarity.getOrDefault(item, Collections.emptyMap()).forEach((similarItem, similarity) -> {
                if (!userItems.containsKey(similarItem)) {
                    recommendedItems.put(similarItem, recommendedItems.getOrDefault(similarItem, 0.0) + similarity * rating);
                }
            });
        }

        return recommendedItems.entrySet().stream()
            .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
            .limit(numRecommendations)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Sample data
        Map<Integer, Map<Integer, Double>> userRatings = new HashMap<>();
        userRatings.put(1, Map.of(101, 5.0, 102, 3.0, 105, 4.0));
        userRatings.put(2, Map.of(101, 4.0, 103, 2.0, 104, 1.0));
        userRatings.put(3, Map.of(102, 1.0, 104, 4.0, 103, 3.0));
        userRatings.put(4, Map.of(101, 2.0, 104, 5.0, 106, 2.0));

        ItemBasedCollaborativeFiltering recommender = new ItemBasedCollaborativeFiltering(userRatings);
        recommender.calculateItemSimilarity();

        List<Integer> recommendations = recommender.recommendItems(2, 4);
        System.out.println("Recommended items for user 1: " + recommendations);
    }
}
