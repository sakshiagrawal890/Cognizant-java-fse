-- Stored Procedure to process monthly interest for all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    v_updated_rows NUMBER := 0;
BEGIN
    -- Update all savings accounts by adding 1% interest
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastUpdate = SYSDATE
    WHERE AccountType = 'Savings';
    
    v_updated_rows := SQL%ROWCOUNT;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest process completed.');
    DBMS_OUTPUT.PUT_LINE('Total Savings Accounts updated: ' || v_updated_rows);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
        RAISE;
END;
/

-- Test execution code block (commented out by default)
/*
SET SERVEROUTPUT ON;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Before Processing Monthly Interest ---');
    FOR r IN (SELECT AccountID, CustomerID, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
        DBMS_OUTPUT.PUT_LINE('Account: ' || r.AccountID || ' | Balance: $' || r.Balance);
    END LOOP;
    
    -- Execute procedure
    ProcessMonthlyInterest;
    
    DBMS_OUTPUT.PUT_LINE('--- After Processing Monthly Interest ---');
    FOR r IN (SELECT AccountID, CustomerID, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
        DBMS_OUTPUT.PUT_LINE('Account: ' || r.AccountID || ' | New Balance: $' || r.Balance);
    END LOOP;
END;
/
*/
