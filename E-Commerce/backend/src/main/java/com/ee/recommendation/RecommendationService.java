package com.ee.recommendation;

import com.ee.dto.ProductDto;
import com.ee.product.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    private final ProductService productService;

    public RecommendationService(ProductService productService) {
        this.productService = productService;
    }

    public Map<String, Object> getRecommendations(String keyword) {
        List<ProductDto> allProducts = productService.searchProducts(keyword);
        Map<String, Object> recommendations = new LinkedHashMap<>();

        // Lowest price products (top 5)
        List<ProductDto> lowestPrice = allProducts.stream()
                .sorted(Comparator.comparingDouble(ProductDto::getPrice))
                .limit(5)
                .collect(Collectors.toList());
        recommendations.put("lowestPrice", lowestPrice);

        // Highest rated products (top 5)
        List<ProductDto> highestRated = allProducts.stream()
                .filter(p -> p.getRating() != null)
                .sorted(Comparator.comparingDouble(ProductDto::getRating).reversed())
                .limit(5)
                .collect(Collectors.toList());
        recommendations.put("highestRated", highestRated);

        // Best value score (rating / price ratio, top 5)
        List<ProductDto> bestValue = allProducts.stream()
                .filter(p -> p.getRating() != null && p.getPrice() > 0)
                .sorted(Comparator.comparingDouble((ProductDto p) -> p.getRating() / p.getPrice()).reversed())
                .limit(5)
                .collect(Collectors.toList());
        recommendations.put("bestValue", bestValue);

        // Best sentiment (top 5)
        List<ProductDto> bestSentiment = allProducts.stream()
                .filter(p -> p.getSentimentScore() != null)
                .sorted(Comparator.comparingDouble(ProductDto::getSentimentScore).reversed())
                .limit(5)
                .collect(Collectors.toList());
        recommendations.put("bestReviews", bestSentiment);

        recommendations.put("totalProducts", allProducts.size());
        recommendations.put("keyword", keyword);

        return recommendations;
    }
}
