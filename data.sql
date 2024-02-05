INSERT INTO person (first_name, last_name, date_of_birth) VALUES
('John', 'Doe', '1990-01-15'),
('Jane', 'Smith', '1985-05-20');

INSERT INTO employment (company_name, position, start_date, end_date, person_id) VALUES
('ABC Corp', 'Software Engineer', '2010-01-01', '2015-12-31', 1),
('XYZ Inc', 'Project Manager', '2016-01-01', '2020-06-30', 1),
('123 Ltd', 'Data Analyst', '2015-06-01', '2022-02-28', 2),
('456 Co', 'Designer', '2018-03-15', NULL, 2);