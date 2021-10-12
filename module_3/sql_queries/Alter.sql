ALTER TABLE accounts
ADD CONSTRAINT accounts_to_users FOREIGN KEY ([user_id]) REFERENCES users (id);

ALTER TABLE operations
ADD CONSTRAINT operation_to_account FOREIGN KEY ([account_id]) REFERENCES accounts (id);

ALTER TABLE operations
ADD CONSTRAINT operations_to_categories FOREIGN KEY (category_id) REFERENCES categories (id);

ALTER TABLE operations ALTER COLUMN [time] datetime;