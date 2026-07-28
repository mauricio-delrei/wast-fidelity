CREATE TABLE member_movements (

    id UUID PRIMARY KEY,

    member_id UUID NOT NULL,

    type VARCHAR(50) NOT NULL,

    movement_date TIMESTAMP NOT NULL,

    description VARCHAR(255),

    CONSTRAINT fk_member_movements_member
        FOREIGN KEY (member_id)
        REFERENCES members(id)
        ON DELETE CASCADE

);


CREATE INDEX idx_member_movements_member
    ON member_movements(member_id);


CREATE INDEX idx_member_movements_type
    ON member_movements(type);


CREATE INDEX idx_member_movements_date
    ON member_movements(movement_date);