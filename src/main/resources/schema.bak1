-- Create tables
CREATE TABLE IF NOT EXISTS `customers` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `customer_id` int NOT NULL UNIQUE,  -- Adding UNIQUE constraint to customer_id
    `name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL UNIQUE,
    `phone` VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS `needs` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(255) -- Replacement, Upgrade, Remodel
);

CREATE TABLE IF NOT EXISTS `product_clusters` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) -- Quick Pickers, Storage Solvers, Lasting Comfort
);

CREATE TABLE IF NOT EXISTS `triggers` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(255) -- Price, Time, Season, Event, Retailer, Budget
);

CREATE TABLE IF NOT EXISTS `missions` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(255) -- Solution Seeking, Recreational Shopping
);

CREATE TABLE IF NOT EXISTS `touchpoints` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(255) -- Brand Website, Store, Social Media, Online Stores
);

CREATE TABLE IF NOT EXISTS `journey_phases` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `phase` VARCHAR(255) -- Browsing, Filtering, Comparing, Exploration, Learning, Committing, Completion
);

CREATE TABLE IF NOT EXISTS `places_of_purchase` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(255) -- Store, Online
);

CREATE TABLE IF NOT EXISTS `customer_experiences` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `customer_id` int NOT NULL,
    `need_id` int NOT NULL,
    `mission_id` int NOT NULL,
    `touchpoint_id` int NOT NULL,
    `journey_phase_id` int NOT NULL,
    `place_of_purchase_id` int NOT NULL,
    FOREIGN KEY (`customer_id`) REFERENCES `customers`(`customer_id`),
    FOREIGN KEY (`need_id`) REFERENCES `needs`(`id`),
    FOREIGN KEY (`mission_id`) REFERENCES `missions`(`id`),
    FOREIGN KEY (`touchpoint_id`) REFERENCES `touchpoints`(`id`),
    FOREIGN KEY (`journey_phase_id`) REFERENCES `journey_phases`(`id`),
    FOREIGN KEY (`place_of_purchase_id`) REFERENCES `places_of_purchase`(`id`)
);

CREATE TABLE IF NOT EXISTS `product_insights` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `product_cluster_id` int NOT NULL,
    `trigger_id` int NOT NULL,
    `insight` TEXT,
    FOREIGN KEY (`product_cluster_id`) REFERENCES `product_clusters`(`id`),
    FOREIGN KEY (`trigger_id`) REFERENCES `triggers`(`id`)
);

-- Insert sample data

-- Customers
INSERT INTO `customers` (`customer_id`, `name`, `email`, `phone`) VALUES
(1, 'Alice Johnson', 'alice.johnson@example.com', '9876543210'),
(2, 'Bob Brown', 'bob.brown@example.com', '5678901234'),
(3, 'Emily Davis', 'emily.davis@example.com', '2345678901'),
(4, 'Michael Wilson', 'michael.wilson@example.com', '8901234567'),
(5, 'Sophia Martinez', 'sophia.martinez@example.com', '4567890123'),
(6, 'William Anderson', 'william.anderson@example.com', '6789012345'),
(7, 'Olivia Thomas', 'olivia.thomas@example.com', '3456789012'),
(8, 'James Garcia', 'james.garcia@example.com', '9012345678'),
(9, 'Amelia Rodriguez', 'amelia.rodriguez@example.com', '1234567890'),
(10, 'Ethan Wilson', 'ethan.wilson@example.com', '8901234567');

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

-- Customer Experiences
INSERT INTO `customer_experiences` (`id`, `customer_id`, `need_id`, `mission_id`, `touchpoint_id`, `journey_phase_id`, `place_of_purchase_id`) VALUES
(1, 1, 1, 1, 1, 1, 1),
(2, 2, 2, 2, 2, 2, 2),
(3, 3, 1, 1, 1, 2, 1),
(4, 4, 2, 2, 3, 3, 2),
(5, 5, 3, 1, 4, 4, 1),
(6, 6, 1, 2, 2, 5, 2),
(7, 7, 2, 1, 1, 6, 1),
(8, 8, 3, 2, 3, 7, 2),
(9, 9, 1, 1, 4, 1, 1),
(10, 10, 2, 2, 2, 2, 2);

-- Product Insights
-- Additional Product Insights
INSERT INTO `product_insights` (`product_cluster_id`, `trigger_id`, `insight`) VALUES
(1, 1, 'Insight 1'),
(2, 2, 'Insight 2'),
(3, 3, 'Insight 3'),
(3, 4, 'Insight 4'),
(2, 5, 'Insight 5'),
(1, 6, 'Insight 6');

