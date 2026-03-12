package com.ee.comparison;

import com.ee.dto.ComparisonResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Comparison", description = "Product comparison endpoints")
public class ComparisonController {

    private final ComparisonService comparisonService;

    public ComparisonController(ComparisonService comparisonService) {
        this.comparisonService = comparisonService;
    }

    @GetMapping("/compare")
    @Operation(summary = "Compare products across platforms by keyword")
    public ResponseEntity<ComparisonResultDto> compareProducts(@RequestParam String keyword) {
        return ResponseEntity.ok(comparisonService.compareProducts(keyword));
    }
}
