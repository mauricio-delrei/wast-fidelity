CREATE TABLE addresses (
    id BIGSERIAL PRIMARY KEY,
    street_name VARCHAR(255),
    house_number VARCHAR(50),
    complement VARCHAR(255),
    city VARCHAR(255),
    county VARCHAR(255),
    postcode VARCHAR(20)
);

CREATE TABLE members (
    id BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    date_of_birth DATE,
    email VARCHAR(255),
    mobile_phone VARCHAR(50),
    baptism_date DATE,
    status VARCHAR(20),
    address_id BIGINT,
    CONSTRAINT fk_address
        FOREIGN KEY (address_id)
        REFERENCES addresses(id)
);