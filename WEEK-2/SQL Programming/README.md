# Week 2: SQL Programming

This directory contains database scripts for Oracle SQL, focused on Control Structures and Stored Procedures.

## Directory Structure

*   **`schema.sql`**: Setup script containing tables (`Customers`, `Loans`, `SavingsAccounts`, `Employees`, `Accounts`) and sample data.
*   **`Control Structures/`**
    *   `Scenario1.sql`: Seniors discount logic (updates loan interest rate for customers aged > 60).
    *   `Scenario2.sql`: VIP status promotion logic (sets `IsVIP = 'Y'` for customers with balance > 10,000).
    *   `Scenario3.sql`: Loan due reminders logic.
*   **`Stored Procedures/`**
    *   `Scenario1.sql`: `ProcessMonthlyInterest` procedure to apply 1% interest to all savings accounts.
    *   `Scenario2.sql`: `UpdateEmployeeBonus` procedure to apply a bonus percentage to employees in a specific department.
    *   `Scenario3.sql`: `TransferFunds` procedure to safely transfer money between accounts with balance checks.

## How to Run

1. Run the `schema.sql` first to initialize tables and insert seed data.
2. Execute the PL/SQL blocks or create procedures in your SQL client (e.g., SQL*Plus, SQL Developer) to test the scenarios.
