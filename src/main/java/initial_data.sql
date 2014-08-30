INSERT INTO roles (roleName) VALUES ("ROLE_ADMIN");
INSERT INTO roles (roleName) VALUES ("ROLE_USER");


INSERT INTO users (userName,userPassword) VALUES ('admin','admin');
INSERT INTO users (userName,userPassword) VALUES ('user','user');
INSERT INTO users_and_roles (USER_ID,ROLE_ID) VALUES (1,1);
INSERT INTO users_and_roles (USER_ID,ROLE_ID) VALUES (2,2);
