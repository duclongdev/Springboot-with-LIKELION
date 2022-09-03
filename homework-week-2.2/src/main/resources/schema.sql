CREATE TABLE DEPARTMENT
(
    department_id int primary key NOT NULL AUTO_INCREMENT,
    dept_name NVARCHAR(265),
    description NVARCHAR(256)
);

CREATE TABLE EMPLOYEE
(
    employee_id int primary key not null AUTO_INCREMENT,
    employ_name NVARCHAR(265),
    department_id int not null,
    birth_date DATE,
    gender NVARCHAR(265),
    FOREIGN KEY (department_id) REFERENCES DEPARTMENT(department_id)
);