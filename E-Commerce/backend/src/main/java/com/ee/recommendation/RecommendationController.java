package com.ee.recommendation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@Tag(name = "Recommendations", description = "Product recommendation endpoints")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/recommendations")
    @Operation(summary = "Get product recommendations ranked by price, rating, and value")
    public ResponseEntity<Map<String, Object>> getRecommendations(@RequestParam String keyword) {
        return ResponseEntity.ok(recommendationService.getRecommendations(keyword));
    }
}
