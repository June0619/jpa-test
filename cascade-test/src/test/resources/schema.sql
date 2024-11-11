drop table if exists Parent CASCADE;
CREATE TABLE Parent
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);
drop table if exists Child CASCADE;
CREATE TABLE Child
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    parent_id BIGINT,
    name      VARCHAR(255)
);