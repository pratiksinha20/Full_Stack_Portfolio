package com.ee.dto;

public class ProductDto {
    private Long id;
    private String name;
    private String platform;
    private Double price;
    private Double rating;
    private String reviewText;
    private String imageUrl;
    private String category;
    private Double sentimentScore;
    private String productUrl;
    private Boolean inStock;

    public ProductDto() {}

    public ProductDto(Long id, String name, String platform, Double price, Double rating,
                      String reviewText, String imageUrl, String category,
                      Double sentimentScore, String productUrl, Boolean inStock) {
        this.id = id;
        this.name = name;
        this.platform = platform;
        this.price = price;
        this.rating = rating;
        this.reviewText = reviewText;
        this.imageUrl = imageUrl;
        this.category = category;
        this.sentimentScore = sentimentScore;
        this.productUrl = productUrl;
        this.inStock = inStock;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
    public String getReviewText() { return reviewText; }
    public void setReviewText(String reviewText) { this.reviewText = reviewText; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Double getSentimentScore() { return sentimentScore; }
    public void setSentimentScore(Double sentimentScore) { this.sentimentScore = sentimentScore; }
    public String getProductUrl() { return productUrl; }
    public void setProductUrl(String productUrl) { this.productUrl = productUrl; }
    public Boolean getInStock() { return inStock; }
    public void setInStock(Boolean inStock) { this.inStock = inStock; }
}
