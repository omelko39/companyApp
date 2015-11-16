
# --- !Ups

INSERT INTO company(id, name, value, parent) VALUES(1, 'test', 1, true);
INSERT INTO company(id, name, value, parent) VALUES(2, 'childOfTest', 1, false);
INSERT INTO child(id, child, parent) VALUES (nextval('"child_id_seq"'), 2, 1);
INSERT INTO company(id, name, value, parent) VALUES(3, 'childOfChildofTest', 1, false);
INSERT INTO child(id, child, parent) VALUES (nextval('"child_id_seq"'), 3, 2);


# --- !Downs

DELETE FROM company;
DELETE FROM child;