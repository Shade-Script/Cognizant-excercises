-- Step 1: Create Tables
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Age NUMBER,
    Balance NUMBER,
    IsVIP VARCHAR2(5)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER,
    DueDate DATE,
    FOREIGN KEY (CustomerID)
        REFERENCES Customers(CustomerID)
);

-- Step 2: Insert Data
INSERT INTO Customers VALUES (1,'Aditya',65,15000,'FALSE');
INSERT INTO Customers VALUES (2,'Rahul',45,8000,'FALSE');
INSERT INTO Customers VALUES (3,'Priya',70,20000,'FALSE');

INSERT INTO Loans VALUES (101,1,8.5,SYSDATE+20);
INSERT INTO Loans VALUES (102,2,9.0,SYSDATE+50);
INSERT INTO Loans VALUES (103,3,7.5,SYSDATE+10);

COMMIT;

-- Step 3: Scenario 1
BEGIN
    FOR cust IN (
        SELECT CustomerID
        FROM Customers
        WHERE Age > 60
    )
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = cust.CustomerID;
    END LOOP;
    COMMIT;
END;
/

-- Step 4: Scenario 2
BEGIN
    FOR cust IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    )
    LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = cust.CustomerID;
    END LOOP;
    COMMIT;
END;
/

-- Step 5: Scenario 3
SET SERVEROUTPUT ON;

BEGIN
    FOR loan_rec IN (
        SELECT c.Name, l.LoanID, l.DueDate
        FROM Customers c
        JOIN Loans l
          ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' ||
            loan_rec.Name ||
            ', Loan ' ||
            loan_rec.LoanID ||
            ' is due on ' ||
            TO_CHAR(loan_rec.DueDate,'DD-MON-YYYY')
        );
    END LOOP;
END;
/

-- Step 6: Verify Results
SELECT * FROM Customers;
SELECT * FROM Loans;