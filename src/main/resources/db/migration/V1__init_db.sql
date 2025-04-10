CREATE TABLE categories
(
    id   BINARY(16)   NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);



CREATE TABLE jt_mentor
(
    user_id BIGINT NOT NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (user_id)
);

CREATE TABLE jt_student
(
    user_id BIGINT NOT NULL,
    psp DOUBLE NOT NULL,
    attendance DOUBLE NOT NULL,
    CONSTRAINT pk_jt_student PRIMARY KEY (user_id)
);

CREATE TABLE jt_ta
(
    user_id BIGINT NOT NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (user_id)
);

CREATE TABLE jt_user
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE ms_mentor
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_ms_mentor PRIMARY KEY (id)
);

CREATE TABLE ms_student
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    attendance DOUBLE NOT NULL,
    CONSTRAINT pk_ms_student PRIMARY KEY (id)
);

CREATE TABLE ms_ta
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_ms_ta PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id BINARY(16) NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE price
(
    id       BINARY(16)   NOT NULL,
    currency VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    CONSTRAINT pk_price PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BINARY(16)   NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    image         VARCHAR(255) NULL,
    category      BINARY(16)   NULL,
    price_id      BINARY(16)   NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE product_orders
(
    order_id   BINARY(16) NOT NULL,
    product_id BINARY(16) NOT NULL
);

CREATE TABLE st_user
(
    id        BIGINT NOT NULL,
    user_type INT NULL,
    name      VARCHAR(255) NULL,
    email     VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    psp DOUBLE NOT NULL,
    attendance DOUBLE NOT NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE tbc_mentor
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tbc_mentor PRIMARY KEY (id)
);

CREATE TABLE tbc_student
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    attendance DOUBLE NOT NULL,
    CONSTRAINT pk_tbc_student PRIMARY KEY (id)
);

CREATE TABLE tbc_ta
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tbc_ta PRIMARY KEY (id)
);

CREATE TABLE tbc_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tbc_user PRIMARY KEY (id)
);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE jt_student
    ADD CONSTRAINT FK_JT_STUDENT_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category) REFERENCES categories (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PRICE FOREIGN KEY (price_id) REFERENCES price (id);

ALTER TABLE product_orders
    ADD CONSTRAINT fk_proord_on_order FOREIGN KEY (order_id) REFERENCES orders (id);

ALTER TABLE product_orders
    ADD CONSTRAINT fk_proord_on_product FOREIGN KEY (product_id) REFERENCES product (id);