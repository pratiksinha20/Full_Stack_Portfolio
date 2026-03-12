package com.ee.product;

import com.ee.dto.ProductDto;
import com.ee.exception.ResourceNotFoundException;
import com.ee.model.Product;
import com.ee.repository.ProductRepository;
import com.ee.recommendation.SentimentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SentimentService sentimentService;

    public ProductService(ProductRepository productRepository, SentimentService sentimentService) {
        this.productRepository = productRepository;
        this.sentimentService = sentimentService;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return toDto(product);
    }

    public List<ProductDto> searchProducts(String keyword) {
        return productRepository.searchByKeyword(keyword).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> getAmazonProducts() {
        return productRepository.findByPlatform("AMAZON").stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> getFlipkartProducts() {
        return productRepository.findByPlatform("FLIPKART").stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> filterProducts(String keyword, String platform,
            Double minPrice, Double maxPrice, Double minRating) {
        List<Product> products;

        if (keyword != null && !keyword.isEmpty()) {
            if (platform != null && !platform.isEmpty()) {
                products = productRepository.searchByKeywordAndPlatform(keyword, platform.toUpperCase());
            } else {
                products = productRepository.searchByKeyword(keyword);
            }
        } else if (platform != null && !platform.isEmpty()) {
            products = productRepository.findByPlatform(platform.toUpperCase());
        } else {
            products = productRepository.findAll();
        }

        return products.stream()
                .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
                .filter(p -> minRating == null || (p.getRating() != null && p.getRating() >= minRating))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto saveProduct(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPlatform(dto.getPlatform());
        product.setPrice(dto.getPrice());
        product.setRating(dto.getRating());
        product.setReviewText(dto.getReviewText());
        product.setImageUrl(dto.getImageUrl());
        product.setCategory(dto.getCategory());
        product.setProductUrl(dto.getProductUrl());
        product.setInStock(dto.getInStock() != null ? dto.getInStock() : true);

        // Calculate sentiment
        if (dto.getReviewText() != null) {
            product.setSentimentScore(sentimentService.analyzeSentiment(dto.getReviewText()));
        }

        product = productRepository.save(product);
        return toDto(product);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    public ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPlatform(),
                product.getPrice(),
                product.getRating(),
                product.getReviewText(),
                product.getImageUrl(),
                product.getCategory(),
                product.getSentimentScore(),
                product.getProductUrl(),
                product.getInStock());
    }
}
