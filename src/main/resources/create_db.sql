--- DROP TABLES

DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS answers;

--- questions table
CREATE TABLE questions (
    question_id SMALLINT NOT NULL,
    title TEXT NOT NULL,
    body TEXT NOT NULL,
    number_of_likes INT,
    created_at DATE NOT NULL
);

--- answers table
CREATE TABLE answers (
    answer_id SMALLINT NOT NULL,
    body TEXT NOT NULL,
    number_of_likes INT,
    question_id INT,
    created_at DATE NOT NULL
);

INSERT INTO questions VALUES (1, 'Help me', 'I am lost', 3, '1990-03-31');
INSERT INTO questions VALUES (2, 'Dummy question', 'Or is it?', 5, '2020-01-01');
INSERT INTO questions VALUES (3, 'Java', 'SAMPLE TEXT', 0, '2021-01-01');

INSERT INTO answers VALUES (1, 'Answering Help me', 3, 1, '2021-03-01');
INSERT INTO answers VALUES (2, 'Answering Help me', 3, 1, '2021-07-02');
INSERT INTO answers VALUES (3, 'Answering Dummy question', 3, 2, '2021-07-01');
INSERT INTO answers VALUES (4, 'Answering Dummy question', 3, 2, '2021-07-02');
INSERT INTO answers VALUES (5, 'Answering Java', 3, 3, '2021-07-01');
INSERT INTO answers VALUES (6, 'Answering Java', 3, 3, '2021-07-02');
INSERT INTO answers VALUES (7, 'Answering Java', 3, 3, '2021-07-03');