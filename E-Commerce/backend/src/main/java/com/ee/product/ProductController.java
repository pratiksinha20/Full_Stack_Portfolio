package com.ee.product;

import com.ee.dto.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Products", description = "Product aggregation endpoints")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    @Operation(summary = "Get all products with optional filters")
    public ResponseEntity<List<ProductDto>> getProducts(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String platform,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Double minRating) {
        return ResponseEntity.ok(productService.filterProducts(keyword, platform, minPrice, maxPrice, minRating));
    }

    @GetMapping("/products/{id}")
    @Operation(summary = "Get product by ID")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/amazon/products")
    @Operation(summary = "Get Amazon products")
    public ResponseEntity<List<ProductDto>> getAmazonProducts() {
        return ResponseEntity.ok(productService.getAmazonProducts());
    }

    @GetMapping("/flipkart/products")
    @Operation(summary = "Get Flipkart products")
    public ResponseEntity<List<ProductDto>> getFlipkartProducts() {
        return ResponseEntity.ok(productService.getFlipkartProducts());
    }

    @GetMapping("/products/search")
    @Operation(summary = "Search products by keyword")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam String keyword) {
        return ResponseEntity.ok(productService.searchProducts(keyword));
    }

    @PostMapping("/admin/products")
    @Operation(summary = "Add a new product (Admin only)")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }

    @DeleteMapping("/admin/products/{id}")
    @Operation(summary = "Delete a product (Admin only)")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
