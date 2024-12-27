CREATE TABLE franchises
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY, -- ID for franchise
    name VARCHAR(255) NOT NULL              -- Franchise name
);

CREATE TABLE branches
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,                         -- ID for branch
    name         VARCHAR(255) NOT NULL,                                     -- Branch name
    franchise_id BIGINT       NOT NULL,                                     -- Franchise relationship
    FOREIGN KEY (franchise_id) REFERENCES franchises (id) ON DELETE CASCADE -- Foreign key to franchises
);

CREATE TABLE products
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,                       -- ID for product
    name      VARCHAR(255) NOT NULL,                                   -- Product name
    stock     INT          NOT NULL,                                   -- Product stock
    branch_id BIGINT       NOT NULL,                                   -- Branch relationship
    FOREIGN KEY (branch_id) REFERENCES branches (id) ON DELETE CASCADE -- Foreign key to branches
);
