INSERT into USERS(username, password, enabled) values('charlie', '$2a$10$2HLXIjd3D2/WKFX7WXPzieuxgRvFpiUEAIXXHwH0Lb4UNxJ/Kh5zu', true);
INSERT into USERS(username, password, enabled) values('admin', '$2a$10$wFDd0o1ULkhQGBf6G5B6leN5lFfUa3Lcr5bC.j1w5TzoD.1TVhJgu', true);
INSERT into AUTHORITIES(username,authority) values('charlie', 'USER');
INSERT into AUTHORITIES(username,authority) values('admin', 'ADMIN');
