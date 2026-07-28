CREATE TABLE baptism_records (

    id UUID PRIMARY KEY,

    member_id UUID NOT NULL,

    baptism_date DATE NOT NULL,

    church_name VARCHAR(150) NOT NULL,

    current_church BOOLEAN NOT NULL,

    CONSTRAINT fk_member_baptism
        FOREIGN KEY(member_id)
        REFERENCES members(id)
        ON DELETE CASCADE
);


CREATE INDEX idx_baptism_records_member
    ON baptism_records(member_id);