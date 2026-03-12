package com.ee.auth;

import com.ee.dto.ProductDto;
import com.ee.dto.UserDto;
import com.ee.exception.ResourceNotFoundException;
import com.ee.model.SavedProduct;
import com.ee.model.User;
import com.ee.product.ProductService;
import com.ee.repository.SavedProductRepository;
import com.ee.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User Dashboard", description = "User-specific endpoints")
public class UserController {

    private final UserRepository userRepository;
    private final SavedProductRepository savedProductRepository;
    private final ProductService productService;

    public UserController(UserRepository userRepository, SavedProductRepository savedProductRepository,
            ProductService productService) {
        this.userRepository = userRepository;
        this.savedProductRepository = savedProductRepository;
        this.productService = productService;
    }

    @GetMapping("/profile")
    @Operation(summary = "Get current user profile")
    public ResponseEntity<UserDto> getProfile(Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return ResponseEntity.ok(new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getRole().name()));
    }

    @GetMapping("/saved-products")
    @Operation(summary = "Get user's saved products")
    public ResponseEntity<List<ProductDto>> getSavedProducts(Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<ProductDto> savedProducts = savedProductRepository.findByUserId(user.getId()).stream()
                .map(sp -> productService.getProductById(sp.getProductId()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(savedProducts);
    }

    @PostMapping("/saved-products/{productId}")
    @Operation(summary = "Save a product to user's list")
    public ResponseEntity<Map<String, String>> saveProduct(@PathVariable Long productId,
            Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Check if already saved
        if (savedProductRepository.findByUserIdAndProductId(user.getId(), productId).isPresent()) {
            return ResponseEntity.ok(Map.of("message", "Product already saved"));
        }

        savedProductRepository.save(new SavedProduct(user.getId(), productId));
        return ResponseEntity.ok(Map.of("message", "Product saved successfully"));
    }

    @DeleteMapping("/saved-products/{productId}")
    @Transactional
    @Operation(summary = "Remove a saved product")
    public ResponseEntity<Map<String, String>> removeSavedProduct(@PathVariable Long productId,
            Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        savedProductRepository.deleteByUserIdAndProductId(user.getId(), productId);
        return ResponseEntity.ok(Map.of("message", "Product removed from saved list"));
    }
}
