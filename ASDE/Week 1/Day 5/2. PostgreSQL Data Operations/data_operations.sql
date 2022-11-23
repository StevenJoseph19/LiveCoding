-- Scenario I
--Subtask 1 : Change name of the actor from Cuba to Jacob
-- Using SELECT Clause

SELECT * FROM actor
WHERE first_name = 'Cuba';

UPDATE actor SET first_name = 'Jacob'
WHERE first_name = 'Cuba';

SELECT * FROM actor
WHERE first_name = 'Jacob';
-------------------------------
--Subtask 2 : Insert a new row table with actor name Robert Johnson

INSERT INTO actor(first_name,last_name)
VALUES ('Robert', 'Johnson');

--   Select Data

SELECT * FROM actor
WHERE first_name = 'Robert';

-- Scenario II
--Subtask 1 : Delete all rows where first name of actor is Robert

-- Select Data
SELECT * FROM actor
WHERE first_name = 'Robert';

-- Delete Data
DELETE FROM actor
WHERE first_name = 'Robert';





