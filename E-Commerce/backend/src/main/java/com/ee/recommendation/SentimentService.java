package com.ee.recommendation;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SentimentService {

    private static final List<String> POSITIVE_WORDS = Arrays.asList(
            "great", "excellent", "amazing", "awesome", "fantastic", "wonderful",
            "superb", "outstanding", "perfect", "love", "best", "good", "nice",
            "beautiful", "comfortable", "impressive", "brilliant", "reliable",
            "recommend", "value", "quality", "fast", "smooth", "durable",
            "efficient", "stunning", "premium", "worth", "solid");

    private static final List<String> NEGATIVE_WORDS = Arrays.asList(
            "bad", "terrible", "awful", "horrible", "worst", "poor", "disappointing",
            "broken", "defective", "slow", "cheap", "useless", "waste", "overpriced",
            "fragile", "unreliable", "uncomfortable", "mediocre", "boring", "noisy",
            "flimsy", "hate", "avoid", "complaint", "issue", "problem");

    /**
     * Analyzes sentiment of review text.
     * Returns score from -1.0 (very negative) to 1.0 (very positive).
     */
    public double analyzeSentiment(String reviewText) {
        if (reviewText == null || reviewText.isEmpty()) {
            return 0.0;
        }

        String text = reviewText.toLowerCase();
        String[] words = text.split("\\s+");

        int positiveCount = 0;
        int negativeCount = 0;

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (POSITIVE_WORDS.contains(cleanWord)) {
                positiveCount++;
            }
            if (NEGATIVE_WORDS.contains(cleanWord)) {
                negativeCount++;
            }
        }

        int total = positiveCount + negativeCount;
        if (total == 0) {
            return 0.0;
        }

        double score = (double) (positiveCount - negativeCount) / total;
        return Math.round(score * 100.0) / 100.0;
    }

    /**
     * Returns a label for the sentiment score.
     */
    public String getSentimentLabel(double score) {
        if (score >= 0.5)
            return "Very Positive";
        if (score >= 0.2)
            return "Positive";
        if (score >= -0.2)
            return "Neutral";
        if (score >= -0.5)
            return "Negative";
        return "Very Negative";
    }
}
