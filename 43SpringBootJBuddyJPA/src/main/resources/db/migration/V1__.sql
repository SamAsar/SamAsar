CREATE TABLE customer
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE products
(
    id          BIGINT NOT NULL,
    name        VARCHAR(255) NULL,
    price       BIGINT NULL,
    qty         INT NULL,
    customer_id BIGINT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);