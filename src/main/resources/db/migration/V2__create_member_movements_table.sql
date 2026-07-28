ALTER TABLE members
    ADD CONSTRAINT uk_members_email
    UNIQUE(email);


ALTER TABLE members
    ADD CONSTRAINT uk_members_mobile_phone
    UNIQUE(mobile_phone);