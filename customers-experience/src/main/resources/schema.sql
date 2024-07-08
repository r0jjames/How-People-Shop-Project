-- Create tables
CREATE TABLE IF NOT EXISTS `customers` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `phone` VARCHAR(20) NOT NULL,
    `age` int,
    `gender` VARCHAR(10),
    `location` VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS `needs` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(50) -- Replacement, Upgrade, Remodel
);

CREATE TABLE IF NOT EXISTS `product_clusters` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) -- Quick Pickers, Storage Solvers, Lasting Comfort
);

CREATE TABLE IF NOT EXISTS `triggers` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(50) -- Price, Time, Season, Event, Retailer, Budget
);

CREATE TABLE IF NOT EXISTS `missions` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(50) -- Solution Seeking, Recreational Shopping
);

CREATE TABLE IF NOT EXISTS `touchpoints` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(50) -- Brand Website, Store, Social Media, Online Stores
);

CREATE TABLE IF NOT EXISTS `journey_phases` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `phase` VARCHAR(50) -- Browsing, Filtering, Comparing, Exploration, Learning, Committing, Completion
);

CREATE TABLE IF NOT EXISTS `places_of_purchase` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(50) -- Store, Online
);

CREATE TABLE IF NOT EXISTS `customer_experiences` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `customer_id` int NOT NULL,
    `need_id` int NOT NULL,
    `mission_id` int NOT NULL,
    `touchpoint_id` int NOT NULL,
    `journey_phase_id` int NOT NULL,
    `place_of_purchase_id` int NOT NULL,
    FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`),
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

CREATE TABLE IF NOT EXISTS `customer_experience_insights` (
    `id` int AUTO_INCREMENT PRIMARY KEY,
    `customer_experience_id` int NOT NULL,
    `insight` TEXT,
    FOREIGN KEY (`customer_experience_id`) REFERENCES `customer_experiences`(`id`)
);

-- Insert sample data

-- Customers
INSERT INTO `customers` (`name`, `email`, `phone`, `age`, `gender`, `location`) VALUES
('Alice Johnson', 'alice.johnson@example.com', '9876543210', 28, 'Female', 'New York'),
('Bob Brown', 'bob.brown@example.com', '5678901234', 35, 'Male', 'Los Angeles'),
('Emily Davis', 'emily.davis@example.com', '2345678901', 22, 'Female', 'Chicago'),
('Michael Wilson', 'michael.wilson@example.com', '8901234567', 40, 'Male', 'Houston'),
('Sophia Martinez', 'sophia.martinez@example.com', '4567890123', 30, 'Female', 'Phoenix'),
('William Anderson', 'william.anderson@example.com', '6789012345', 33, 'Male', 'Philadelphia'),
('Olivia Thomas', 'olivia.thomas@example.com', '3456789012', 27, 'Female', 'San Antonio'),
('James Garcia', 'james.garcia@example.com', '9012345678', 36, 'Male', 'San Diego'),
('Amelia Rodriguez', 'amelia.rodriguez@example.com', '1234567890', 29, 'Female', 'Dallas'),
('Ethan Wilson', 'ethan.wilson@example.com', '8901234567', 31, 'Male', 'San Jose');

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
INSERT INTO `customer_experiences` (`customer_id`, `need_id`, `mission_id`, `touchpoint_id`, `journey_phase_id`, `place_of_purchase_id`) VALUES
(1, 1, 1, 1, 1, 1),
(2, 2, 2, 2, 2, 2),
(3, 1, 1, 1, 2, 1),
(4, 2, 2, 3, 3, 2),
(5, 3, 1, 4, 4, 1),
(6, 1, 2, 2, 5, 2),
(7, 2, 1, 1, 6, 1),
(8, 3, 2, 3, 7, 2),
(9, 1, 1, 4, 1, 1),
(10, 2, 2, 2, 2, 2);

-- Product Insights
INSERT INTO `product_insights` (`product_cluster_id`, `trigger_id`, `insight`) VALUES
(1, 1, 'Quick Pickers are highly influenced by price reductions during sales events.'),
(2, 2, 'Storage Solvers see an increase in demand during the back-to-school season.'),
(3, 3, 'Lasting Comfort products are preferred during the winter season.'),
(3, 4, 'Events like Black Friday significantly boost Lasting Comfort product sales.'),
(2, 5, 'Retailer-specific promotions drive Storage Solvers purchases.'),
(1, 6, 'Budget constraints affect Quick Pickers the most.');

-- Customer Experience Insights
INSERT INTO `customer_experience_insights` (`customer_experience_id`, `insight`) VALUES
(1, 'Customer found the online browsing experience seamless and intuitive.'),
(2, 'Customer felt overwhelmed by too many options at the store.'),
(3, 'Comparing products on the brand website was easy and helpful.'),
(4, 'Customer experienced long wait times during the committing phase at the store.'),
(5, 'Customer appreciated the learning phase videos on social media.'),
(6, 'Customer found the product descriptions during the exploration phase very detailed and informative.'),
(7, 'Customer experienced issues with the checkout process online.'),
(8, 'Customer found the exploration phase in-store very interactive.'),
(9, 'Customer had a smooth completion phase with quick delivery online.'),
(10, 'Customer appreciated the helpful staff during the store visit.');
