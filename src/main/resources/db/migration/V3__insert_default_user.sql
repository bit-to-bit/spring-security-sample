SET SCHEMA MAIN;
INSERT INTO users (username, password, enabled, account_non_expired, account_non_locked, credentials_non_expired, authorities)
VALUES('user', '$2a$10$k4iKlQJKVq0a9xim2M7fOe3JkWvgivk5rSYTQUe3l2xFFjNlI5Fb2', true, true, true, true, null);