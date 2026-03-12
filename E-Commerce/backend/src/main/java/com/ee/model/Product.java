package com.ee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String platform; // AMAZON, FLIPKART

    @Column(nullable = false)
    private Double price;

    private Double rating; // 0.0 - 5.0

    @Column(length = 1000)
    private String reviewText;

    private String imageUrl;

    private String category;

    private Double sentimentScore; // -1.0 to 1.0

    private String productUrl;

    private Boolean inStock = true;

    public Product() {}

    public Product(String name, String platform, Double price, Double rating,
                   String reviewText, String imageUrl, String category, String productUrl) {
        this.name = name;
        this.platform = platform;
        this.price = price;
        this.rating = rating;
        this.reviewText = reviewText;
        this.imageUrl = imageUrl;
        this.category = category;
        this.productUrl = productUrl;
        this.inStock = true;
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
