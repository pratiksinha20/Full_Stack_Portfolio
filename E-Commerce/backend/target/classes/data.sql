-- ============================================
-- Easy-Ecommerce Seed Data
-- ============================================

-- Admin user (password: admin123)
INSERT INTO users (username, email, password, role, created_at) VALUES
('admin', 'admin@easyecommerce.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'ADMIN', CURRENT_TIMESTAMP);

-- Demo user (password: user123)
INSERT INTO users (username, email, password, role, created_at) VALUES
('demo', 'demo@easyecommerce.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'USER', CURRENT_TIMESTAMP);

-- ========== SMARTPHONES ==========
INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('Samsung Galaxy S24 Ultra', 'AMAZON', 129999.00, 4.5, 'Amazing camera quality and display. Best Samsung phone ever. Performance is outstanding with Snapdragon 8 Gen 3.', 'https://via.placeholder.com/300x300?text=Galaxy+S24', 'Smartphones', 0.8, 'https://amazon.in/galaxy-s24', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('Samsung Galaxy S24 Ultra', 'FLIPKART', 124999.00, 4.3, 'Great phone with wonderful features. Good value for money. Camera is superb.', 'https://via.placeholder.com/300x300?text=Galaxy+S24', 'Smartphones', 0.9, 'https://flipkart.com/galaxy-s24', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('iPhone 15 Pro Max', 'AMAZON', 159900.00, 4.7, 'Best iPhone ever made. Brilliant display, excellent camera system. Premium build quality.', 'https://via.placeholder.com/300x300?text=iPhone+15', 'Smartphones', 1.0, 'https://amazon.in/iphone-15-pro', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('iPhone 15 Pro Max', 'FLIPKART', 156900.00, 4.6, 'Amazing phone but overpriced. Camera quality is stunning. Fast performance.', 'https://via.placeholder.com/300x300?text=iPhone+15', 'Smartphones', 0.5, 'https://flipkart.com/iphone-15-pro', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('OnePlus 12', 'AMAZON', 64999.00, 4.4, 'Excellent value for money. Fast charging is impressive. Smooth display.', 'https://via.placeholder.com/300x300?text=OnePlus+12', 'Smartphones', 0.8, 'https://amazon.in/oneplus-12', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('OnePlus 12', 'FLIPKART', 61999.00, 4.5, 'Great phone! Love the display and performance. Best in this price range. Recommend!', 'https://via.placeholder.com/300x300?text=OnePlus+12', 'Smartphones', 1.0, 'https://flipkart.com/oneplus-12', true);

-- ========== LAPTOPS ==========
INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('MacBook Air M3', 'AMAZON', 114900.00, 4.8, 'Perfect laptop for students and professionals. Beautiful display, outstanding battery life.', 'https://via.placeholder.com/300x300?text=MacBook+Air', 'Laptops', 1.0, 'https://amazon.in/macbook-air-m3', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('MacBook Air M3', 'FLIPKART', 112900.00, 4.7, 'Excellent build quality and performance. Solid laptop. Love the silent operation.', 'https://via.placeholder.com/300x300?text=MacBook+Air', 'Laptops', 1.0, 'https://flipkart.com/macbook-air-m3', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('Dell XPS 15', 'AMAZON', 149990.00, 4.3, 'Good performance but gets hot under load. Display quality is nice. Problem with fan noise.', 'https://via.placeholder.com/300x300?text=Dell+XPS+15', 'Laptops', 0.2, 'https://amazon.in/dell-xps-15', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('Dell XPS 15', 'FLIPKART', 145990.00, 4.1, 'Average laptop. Mediocre battery life. Build quality is good but issues with heating.', 'https://via.placeholder.com/300x300?text=Dell+XPS+15', 'Laptops', -0.3, 'https://flipkart.com/dell-xps-15', true);

-- ========== HEADPHONES ==========
INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('Sony WH-1000XM5', 'AMAZON', 29990.00, 4.6, 'Excellent noise cancellation. Comfortable for long hours. Sound quality is amazing.', 'https://via.placeholder.com/300x300?text=Sony+XM5', 'Headphones', 1.0, 'https://amazon.in/sony-xm5', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('Sony WH-1000XM5', 'FLIPKART', 27990.00, 4.5, 'Great headphones! Love the sound and comfort. Best ANC in this range. Recommend to everyone.', 'https://via.placeholder.com/300x300?text=Sony+XM5', 'Headphones', 1.0, 'https://flipkart.com/sony-xm5', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('JBL Tune 770NC', 'AMAZON', 4999.00, 4.1, 'Good value for the price. Decent sound quality. ANC could be better. Nice comfortable fit.', 'https://via.placeholder.com/300x300?text=JBL+770NC', 'Headphones', 0.5, 'https://amazon.in/jbl-770nc', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('JBL Tune 770NC', 'FLIPKART', 4499.00, 4.2, 'Comfortable headphones with good bass. Worth the price. Solid build quality.', 'https://via.placeholder.com/300x300?text=JBL+770NC', 'Headphones', 0.8, 'https://flipkart.com/jbl-770nc', true);

-- ========== SMARTWATCHES ==========
INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('Apple Watch Series 9', 'AMAZON', 41900.00, 4.5, 'Premium smartwatch with excellent health tracking. Beautiful display. Reliable and fast.', 'https://via.placeholder.com/300x300?text=Apple+Watch', 'Smartwatches', 1.0, 'https://amazon.in/apple-watch-9', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('Apple Watch Series 9', 'FLIPKART', 40900.00, 4.4, 'Amazing watch! Love the fitness features. Battery could be better but overall worth it.', 'https://via.placeholder.com/300x300?text=Apple+Watch', 'Smartwatches', 0.6, 'https://flipkart.com/apple-watch-9', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('Samsung Galaxy Watch 6', 'AMAZON', 26999.00, 4.2, 'Good smartwatch with nice features. Comfortable fit. Smooth performance.', 'https://via.placeholder.com/300x300?text=Galaxy+Watch', 'Smartwatches', 0.8, 'https://amazon.in/galaxy-watch-6', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('Samsung Galaxy Watch 6', 'FLIPKART', 24999.00, 4.3, 'Great value for features offered. Reliable health tracking. Recommend for Android users.', 'https://via.placeholder.com/300x300?text=Galaxy+Watch', 'Smartwatches', 1.0, 'https://flipkart.com/galaxy-watch-6', true);

-- ========== TABLETS ==========
INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('iPad Air M2', 'AMAZON', 59900.00, 4.6, 'Perfect tablet for productivity. Excellent display and performance. Love it!', 'https://via.placeholder.com/300x300?text=iPad+Air', 'Tablets', 1.0, 'https://amazon.in/ipad-air-m2', true);

INSERT INTO products (name, platform, price, rating, review_text, image_url, category, sentiment_score, product_url, in_stock) VALUES
('iPad Air M2', 'FLIPKART', 57900.00, 4.5, 'Outstanding tablet. Fast and smooth. Great for drawing and note-taking. Brilliant screen.', 'https://via.placeholder.com/300x300?text=iPad+Air', 'Tablets', 1.0, 'https://flipkart.com/ipad-air-m2', true);

-- Price History
INSERT INTO price_history (product_id, price, recorded_at) VALUES (1, 134999.00, DATEADD('DAY', -30, CURRENT_TIMESTAMP));
INSERT INTO price_history (product_id, price, recorded_at) VALUES (1, 131999.00, DATEADD('DAY', -15, CURRENT_TIMESTAMP));
INSERT INTO price_history (product_id, price, recorded_at) VALUES (1, 129999.00, CURRENT_TIMESTAMP);
INSERT INTO price_history (product_id, price, recorded_at) VALUES (2, 129999.00, DATEADD('DAY', -30, CURRENT_TIMESTAMP));
INSERT INTO price_history (product_id, price, recorded_at) VALUES (2, 126999.00, DATEADD('DAY', -15, CURRENT_TIMESTAMP));
INSERT INTO price_history (product_id, price, recorded_at) VALUES (2, 124999.00, CURRENT_TIMESTAMP);
INSERT INTO price_history (product_id, price, recorded_at) VALUES (3, 164900.00, DATEADD('DAY', -30, CURRENT_TIMESTAMP));
INSERT INTO price_history (product_id, price, recorded_at) VALUES (3, 161900.00, DATEADD('DAY', -15, CURRENT_TIMESTAMP));
INSERT INTO price_history (product_id, price, recorded_at) VALUES (3, 159900.00, CURRENT_TIMESTAMP);
