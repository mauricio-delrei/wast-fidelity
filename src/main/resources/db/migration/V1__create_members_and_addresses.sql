CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE TABLE addresses (
    id UUID PRIMARY KEY,
    street VARCHAR(255),
    house_number VARCHAR(50),
    complement VARCHAR(255),
    city VARCHAR(255),
    postcode VARCHAR(20),
    country VARCHAR(100)
);


CREATE TABLE members (
    id UUID PRIMARY KEY,

    full_name VARCHAR(255) NOT NULL,
    date_of_birth DATE,

    email VARCHAR(255) NOT NULL,
    mobile_phone VARCHAR(20),

    baptism_date DATE,

    status VARCHAR(20) NOT NULL,

    address_id UUID,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deactivated_at TIMESTAMP,

    CONSTRAINT fk_member_address
        FOREIGN KEY (address_id)
        REFERENCES addresses(id)
);