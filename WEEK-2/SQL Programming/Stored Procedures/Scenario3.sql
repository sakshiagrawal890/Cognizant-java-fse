-- Stored Procedure to transfer funds between accounts with balance validation and locking
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id IN NUMBER,
    p_target_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_source_balance NUMBER;
    v_target_exists NUMBER;
    insufficient_funds EXCEPTION;
    invalid_amount EXCEPTION;
    account_not_found EXCEPTION;
    self_transfer EXCEPTION;
BEGIN
    -- 1. Validate that the amount is positive
    IF p_amount <= 0 OR p_amount IS NULL THEN
        RAISE invalid_amount;
    END IF;
    
    -- 2. Prevent self-transfers
    IF p_source_account_id = p_target_account_id THEN
        RAISE self_transfer;
    END IF;
    
    -- 3. Check if source account exists and fetch its balance with a row-level lock
    BEGIN
        SELECT Balance INTO v_source_balance
        FROM Accounts
        WHERE AccountID = p_source_account_id
        FOR UPDATE;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE account_not_found;
    END;
    
    -- 4. Check if target account exists
    SELECT COUNT(*) INTO v_target_exists
    FROM Accounts
    WHERE AccountID = p_target_account_id;
    
    IF v_target_exists = 0 THEN
        RAISE account_not_found;
    END IF;
    
    -- 5. Validate sufficient balance
    IF v_source_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;
    
    -- 6. Perform the debit and credit operations
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastUpdate = SYSDATE
    WHERE AccountID = p_source_account_id;
    
    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastUpdate = SYSDATE
    WHERE AccountID = p_target_account_id;
    
    -- Commit the transaction
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Transfer successful!');
    DBMS_OUTPUT.PUT_LINE('Transferred $' || TO_CHAR(p_amount, 'FM999,999,990.00') || 
                         ' from Account ' || p_source_account_id || 
                         ' to Account ' || p_target_account_id || '.');
                         
EXCEPTION
    WHEN invalid_amount THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Transfer amount must be positive.');
        RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be positive.');
        
    WHEN self_transfer THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Source and target accounts cannot be the same.');
        RAISE_APPLICATION_ERROR(-20002, 'Source and target accounts cannot be the same.');
        
    WHEN account_not_found THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: One or both accounts do not exist.');
        RAISE_APPLICATION_ERROR(-20003, 'One or both accounts do not exist.');
        
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance. Account ID ' || p_source_account_id || 
                             ' has $' || TO_CHAR(v_source_balance, 'FM999,999,990.00') || 
                             ', which is less than requested $' || TO_CHAR(p_amount, 'FM999,999,990.00') || '.');
        RAISE_APPLICATION_ERROR(-20006, 'Insufficient balance for the transfer.');
        
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Transfer failed: ' || SQLERRM);
        RAISE;
END;
/

-- Test execution code block (commented out by default)
/*
SET SERVEROUTPUT ON;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Before Transfer ---');
    FOR r IN (SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (101, 102)) LOOP
        DBMS_OUTPUT.PUT_LINE('Account: ' || r.AccountID || ' | Balance: $' || r.Balance);
    END LOOP;
    
    -- Perform successful transfer of $1000 from 101 to 102
    TransferFunds(101, 102, 1000.00);
    
    DBMS_OUTPUT.PUT_LINE('--- After Transfer ---');
    FOR r IN (SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (101, 102)) LOOP
        DBMS_OUTPUT.PUT_LINE('Account: ' || r.AccountID || ' | Balance: $' || r.Balance);
    END LOOP;
    
    -- Attempt transfer with insufficient balance (should fail)
    DBMS_OUTPUT.PUT_LINE('--- Attempting Insufficient Balance Transfer ---');
    TransferFunds(101, 102, 50000.00);
END;
/
*/
