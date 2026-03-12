package com.ee.comparison;

import com.ee.dto.ComparisonResultDto;
import com.ee.dto.ProductDto;
import com.ee.product.ProductService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComparisonService {

    private final ProductService productService;

    public ComparisonService(ProductService productService) {
        this.productService = productService;
    }

    public ComparisonResultDto compareProducts(String keyword) {
        List<ProductDto> allProducts = productService.searchProducts(keyword);

        List<ProductDto> amazonProducts = allProducts.stream()
                .filter(p -> "AMAZON".equalsIgnoreCase(p.getPlatform()))
                .collect(Collectors.toList());

        List<ProductDto> flipkartProducts = allProducts.stream()
                .filter(p -> "FLIPKART".equalsIgnoreCase(p.getPlatform()))
                .collect(Collectors.toList());

        ComparisonResultDto result = new ComparisonResultDto();
        result.setKeyword(keyword);
        result.setTotalResults(allProducts.size());
        result.setAmazonProducts(amazonProducts);
        result.setFlipkartProducts(flipkartProducts);

        // Find best price
        allProducts.stream()
                .min(Comparator.comparingDouble(ProductDto::getPrice))
                .ifPresent(result::setBestPrice);

        // Find best rating
        allProducts.stream()
                .filter(p -> p.getRating() != null)
                .max(Comparator.comparingDouble(ProductDto::getRating))
                .ifPresent(result::setBestRating);

        // Find best value (highest rating/price ratio)
        allProducts.stream()
                .filter(p -> p.getRating() != null && p.getPrice() > 0)
                .max(Comparator.comparingDouble(p -> p.getRating() / p.getPrice() * 10000))
                .ifPresent(result::setBestValue);

        return result;
    }
}
