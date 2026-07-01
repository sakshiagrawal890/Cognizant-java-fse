-- Drop tables if they exist to start fresh
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Loans CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Accounts CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Customers CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Employees CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

-- Create Customers Table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100) NOT NULL,
    DOB DATE NOT NULL,
    Balance NUMBER(15, 2) NOT NULL,
    IsVIP VARCHAR2(5) DEFAULT 'FALSE' CHECK (IsVIP IN ('TRUE', 'FALSE'))
);

-- Create Accounts Table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20) NOT NULL,
    Balance NUMBER(15, 2) NOT NULL,
    LastUpdate DATE DEFAULT SYSDATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Create Loans Table
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER(15, 2) NOT NULL,
    InterestRate NUMBER(5, 2) NOT NULL, -- Stored as percentage (e.g. 7.50 for 7.5%)
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL, -- Loan due date
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Create Employees Table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100) NOT NULL,
    Department VARCHAR2(50) NOT NULL,
    Salary NUMBER(15, 2) NOT NULL,
    HireDate DATE DEFAULT SYSDATE
);

-- Seed Customers
INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (1, 'John Doe', TO_DATE('1958-05-15', 'YYYY-MM-DD'), 12000.00, 'FALSE'); -- Age: 68 (> 60), Balance > 10,000

INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (2, 'Jane Smith', TO_DATE('1975-09-20', 'YYYY-MM-DD'), 8500.00, 'FALSE'); -- Age: 50 (< 60), Balance < 10,000

INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (3, 'Alice Brown', TO_DATE('1962-11-10', 'YYYY-MM-DD'), 15000.00, 'FALSE'); -- Age: 63 (> 60), Balance > 10,000

INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (4, 'Bob Johnson', TO_DATE('1988-02-28', 'YYYY-MM-DD'), 500.00, 'FALSE'); -- Age: 38 (< 60), Balance < 10,000

-- Seed Accounts
-- Customer 1 accounts
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (101, 1, 'Savings', 12000.00, SYSDATE - 45);

-- Customer 2 accounts
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (102, 2, 'Savings', 8500.00, SYSDATE - 10);

-- Customer 3 accounts
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (103, 3, 'Checking', 5000.00, SYSDATE - 5);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (104, 3, 'Savings', 10000.00, SYSDATE - 20);

-- Customer 4 accounts
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (105, 4, 'Checking', 500.00, SYSDATE - 12);

-- Seed Loans
-- Customer 1 (John Doe, Age 68, should get discount; loan due in 15 days)
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (201, 1, 50000.00, 8.50, SYSDATE - 180, SYSDATE + 15);

-- Customer 2 (Jane Smith, Age 50, no discount; loan due in 45 days)
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (202, 2, 25000.00, 9.00, SYSDATE - 90, SYSDATE + 45);

-- Customer 3 (Alice Brown, Age 63, should get discount; loan due in 20 days)
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (203, 3, 30000.00, 7.50, SYSDATE - 120, SYSDATE + 20);

-- Customer 4 (Bob Johnson, Age 38, no discount; loan due in 100 days)
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (204, 4, 10000.00, 10.00, SYSDATE - 30, SYSDATE + 100);

-- Seed Employees
INSERT INTO Employees (EmployeeID, Name, Department, Salary, HireDate)
VALUES (1001, 'Robert Miller', 'IT', 60000.00, TO_DATE('2018-04-10', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Department, Salary, HireDate)
VALUES (1002, 'Emily Davis', 'HR', 45000.00, TO_DATE('2020-07-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Department, Salary, HireDate)
VALUES (1003, 'Michael Wilson', 'IT', 75000.00, TO_DATE('2015-03-22', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Department, Salary, HireDate)
VALUES (1004, 'Sarah Connor', 'Finance', 80000.00, TO_DATE('2012-11-05', 'YYYY-MM-DD'));

COMMIT;
/
