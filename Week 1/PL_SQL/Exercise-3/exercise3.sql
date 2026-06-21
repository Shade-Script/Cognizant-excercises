-- Cleanup (optional if rerunning)
DROP TABLE Accounts CASCADE CONSTRAINTS;
DROP TABLE Employees CASCADE CONSTRAINTS;
-- Accounts Table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100),
    AccountType VARCHAR2(20),
    Balance NUMBER(10,2)
);

-- Employees Table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(100),
    Department VARCHAR2(50),
    Salary NUMBER(10,2)
);

-- Inserting Data
INSERT INTO Accounts VALUES (101,'Aditya','Savings',10000);
INSERT INTO Accounts VALUES (102,'Rahul','Savings',15000);
INSERT INTO Accounts VALUES (103,'Priya','Current',20000);
INSERT INTO Accounts VALUES (104,'Neha','Savings',5000);

INSERT INTO Employees VALUES (1,'Amit','IT',50000);
INSERT INTO Employees VALUES (2,'Sneha','IT',60000);
INSERT INTO Employees VALUES (3,'Raj','HR',45000);

COMMIT;

-- Scenario 1:
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN

    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';

    COMMIT;

END;
/

-- Execution
EXEC ProcessMonthlyInterest;

-- Verification
SELECT * FROM Accounts;

-- Scenario 2:
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
)
AS
BEGIN

    UPDATE Employees
    SET Salary = Salary +
                 (Salary * p_bonus_percent / 100)
    WHERE Department = p_department;

    COMMIT;

END;
/

-- Execution
EXEC UpdateEmployeeBonus('IT',10);

-- Verification
SELECT * FROM Employees;

-- Scenario 3:
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
)
AS
    v_balance NUMBER;
BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance >= p_amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account;

        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE(
            'Transfer Successful'
        );

    ELSE

        DBMS_OUTPUT.PUT_LINE(
            'Insufficient Balance'
        );

    END IF;

END;
/

-- Output
SET SERVEROUTPUT ON;

-- Execution
EXEC TransferFunds(101,102,2000);

-- Verification
SELECT * FROM Accounts;