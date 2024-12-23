-- Customers Table
CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `phone` VARCHAR(20) NOT NULL,
    `age` INT,
    `gender` VARCHAR(10),
    `location` VARCHAR(100)
--    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Needs Table
CREATE TABLE IF NOT EXISTS `needs` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(50) NOT NULL -- Replacement, Upgrade, Remodel
);

-- Product Clusters Table
CREATE TABLE IF NOT EXISTS `product_clusters` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL -- Quick Pickers, Storage Solvers, Lasting Comfort
);

-- Triggers Table
CREATE TABLE IF NOT EXISTS `triggers` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(50) NOT NULL -- Price, Time, Season, Event, Retailer, Budget
);

-- Missions Table
CREATE TABLE IF NOT EXISTS `missions` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(50) NOT NULL -- Solution Seeking, Recreational Shopping
);

-- Touchpoints Table
CREATE TABLE IF NOT EXISTS `touchpoints` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(50) NOT NULL -- Brand Website, Store, Social Media, Online Stores
);

-- Journey Phases Table
CREATE TABLE IF NOT EXISTS `journey_phases` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `phase` VARCHAR(50) NOT NULL -- Browsing, Filtering, Comparing, Exploration, Learning, Committing, Completion
);

-- Places of Purchase Table
CREATE TABLE IF NOT EXISTS `places_of_purchase` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(50) NOT NULL -- Store, Online
);

-- Customer Experiences Table
CREATE TABLE IF NOT EXISTS `customer_experiences` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `customer_id` INT NOT NULL,
    `need_id` INT NOT NULL,
    `mission_id` INT NOT NULL,
    `touchpoint_id` INT NOT NULL,
    `journey_phase_id` INT NOT NULL,
    `place_of_purchase_id` INT NOT NULL,
--    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`),
    FOREIGN KEY (`need_id`) REFERENCES `needs`(`id`),
    FOREIGN KEY (`mission_id`) REFERENCES `missions`(`id`),
    FOREIGN KEY (`touchpoint_id`) REFERENCES `touchpoints`(`id`),
    FOREIGN KEY (`journey_phase_id`) REFERENCES `journey_phases`(`id`),
    FOREIGN KEY (`place_of_purchase_id`) REFERENCES `places_of_purchase`(`id`)
);

-- Product Insights Table
CREATE TABLE IF NOT EXISTS `product_insights` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `product_cluster_id` INT NOT NULL,
    `trigger_id` INT NOT NULL,
    `insight` TEXT NOT NULL,
--    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`product_cluster_id`) REFERENCES `product_clusters`(`id`),
    FOREIGN KEY (`trigger_id`) REFERENCES `triggers`(`id`)
);

-- Customer Experience Insights Table
CREATE TABLE IF NOT EXISTS `customer_experience_insights` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `customer_experience_id` INT NOT NULL,
    `title` VARCHAR(255) NOT NULL,
    `description` TEXT NOT NULL,
--    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`customer_experience_id`) REFERENCES `customer_experiences`(`id`)
);

-- Sample Data Insertion

-- Needs
INSERT INTO `needs` (`type`) VALUES
('Replacement'),
('Upgrade'),
('Remodel');

-- Product Clusters
INSERT INTO `product_clusters` (`name`) VALUES
('Quick Pickers'),
('Storage Solvers'),
('Lasting Comfort');

-- Triggers
INSERT INTO `triggers` (`type`) VALUES
('Price'),
('Time'),
('Season'),
('Event'),
('Retailer'),
('Budget');

-- Missions
INSERT INTO `missions` (`type`) VALUES
('Solution Seeking'),
('Recreational Shopping');

-- Touchpoints
INSERT INTO `touchpoints` (`type`) VALUES
('Brand Website'),
('Store'),
('Social Media'),
('Online Stores');

-- Journey Phases
INSERT INTO `journey_phases` (`phase`) VALUES
('Browsing'),
('Filtering'),
('Comparing'),
('Exploration'),
('Learning'),
('Committing'),
('Completion');

-- Places of Purchase
INSERT INTO `places_of_purchase` (`type`) VALUES
('Store'),
('Online');

-- Customers
INSERT INTO `customers` (`name`, `email`, `phone`, `age`, `gender`, `location`) VALUES
('Alice Johnson', 'alice.johnson@example.com', '9876543210', 28, 'Female', 'New York'),
('Bob Brown', 'bob.brown@example.com', '5678901234', 35, 'Male', 'Los Angeles'),
('Emily Davis', 'emily.davis@example.com', '2345678901', 22, 'Female', 'Chicago'),
('Michael Wilson', 'michael.wilson@example.com', '8901234567', 40, 'Male', 'Houston'),
('Sophia Martinez', 'sophia.martinez@example.com', '4567890123', 30, 'Female', 'Phoenix');

-- Customer Experiences
INSERT INTO `customer_experiences` (`customer_id`, `need_id`, `mission_id`, `touchpoint_id`, `journey_phase_id`, `place_of_purchase_id`) VALUES
(1, 1, 1, 1, 1, 1),
(2, 2, 2, 2, 2, 2),
(3, 1, 1, 1, 2, 1),
(4, 2, 2, 3, 3, 2),
(5, 3, 1, 4, 4, 1),
(1, 1, 2, 2, 5, 2),
(2, 2, 1, 1, 6, 1),
(3, 1, 2, 3, 7, 2),
(4, 2, 1, 4, 1, 1),
(5, 3, 2, 2, 2, 2);

-- Product Insights
INSERT INTO `product_insights` (`product_cluster_id`, `trigger_id`, `insight`) VALUES
(1, 1, 'Quick Pickers are highly influenced by price reductions during sales events.'),
(2, 2, 'Storage Solvers see an increase in demand during the back-to-school season.'),
(3, 3, 'Lasting Comfort products are preferred during the winter season.'),
(3, 4, 'Events like Black Friday significantly boost Lasting Comfort product sales.'),
(2, 5, 'Retailer-specific promotions drive Storage Solvers purchases.'),
(1, 6, 'Budget constraints affect Quick Pickers the most.');

-- Customer Experience Insights
INSERT INTO `customer_experience_insights` (`customer_experience_id`, `title`, `description`) VALUES
(1, 'Seamless Browsing Experience', 'Customer found the online browsing experience seamless and intuitive.'),
(2, 'Overwhelmed by Options', 'Customer felt overwhelmed by too many options at the store.'),
(3, 'Easy Product Comparison', 'Comparing products on the brand website was easy and helpful.'),
(4, 'Long Wait Times', 'Customer experienced long wait times during the committing phase at the store.'),
(5, 'Engaging Learning Phase', 'Customer appreciated the learning phase videos on social media.'),
(6, 'Detailed Product Descriptions', 'Customer found the product descriptions during the exploration phase very detailed and informative.'),
(7, 'Checkout Issues', 'Customer experienced issues with the checkout process online.'),
(8, 'Interactive Exploration Phase', 'Customer found the exploration phase in-store very interactive.'),
(9, 'Smooth Completion Phase', 'Customer had a smooth completion phase with quick delivery online.'),
(10, 'Helpful Store Staff', 'Customer appreciated the helpful staff during the store visit.');
