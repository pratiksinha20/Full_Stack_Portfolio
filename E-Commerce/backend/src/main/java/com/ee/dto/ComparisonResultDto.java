package com.ee.dto;

import java.util.List;

public class ComparisonResultDto {
    private String keyword;
    private int totalResults;
    private List<ProductDto> amazonProducts;
    private List<ProductDto> flipkartProducts;
    private ProductDto bestPrice;
    private ProductDto bestRating;
    private ProductDto bestValue;

    public ComparisonResultDto() {}

    // Getters and Setters
    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }
    public int getTotalResults() { return totalResults; }
    public void setTotalResults(int totalResults) { this.totalResults = totalResults; }
    public List<ProductDto> getAmazonProducts() { return amazonProducts; }
    public void setAmazonProducts(List<ProductDto> amazonProducts) { this.amazonProducts = amazonProducts; }
    public List<ProductDto> getFlipkartProducts() { return flipkartProducts; }
    public void setFlipkartProducts(List<ProductDto> flipkartProducts) { this.flipkartProducts = flipkartProducts; }
    public ProductDto getBestPrice() { return bestPrice; }
    public void setBestPrice(ProductDto bestPrice) { this.bestPrice = bestPrice; }
    public ProductDto getBestRating() { return bestRating; }
    public void setBestRating(ProductDto bestRating) { this.bestRating = bestRating; }
    public ProductDto getBestValue() { return bestValue; }
    public void setBestValue(ProductDto bestValue) { this.bestValue = bestValue; }
}
