CREATE TABLE franchise
(
    id   BIGSERIAL PRIMARY KEY,          -- ID for franchise
    name VARCHAR(255) NOT NULL           -- Franchise name
);

CREATE TABLE branch
(
    id           BIGSERIAL PRIMARY KEY,                         -- ID for branch
    name         VARCHAR(255) NOT NULL,                          -- Branch name
    franchise_id BIGINT       NOT NULL,                          -- Franchise relationship
    CONSTRAINT fk_franchise
        FOREIGN KEY (franchise_id) REFERENCES franchise(id)    -- Foreign key to franchise table
            ON DELETE CASCADE                                           -- Cascading delete
);

CREATE TABLE product
(
    id        BIGSERIAL PRIMARY KEY,                            -- ID for product
    name      VARCHAR(255) NOT NULL,                             -- Product name
    stock     INT          NOT NULL,                             -- Product stock
    branch_id BIGINT       NOT NULL,                             -- Branch relationship
    CONSTRAINT fk_branch
        FOREIGN KEY (branch_id) REFERENCES branch(id)          -- Foreign key to branch table
            ON DELETE CASCADE                                           -- Cascading delete
);

