SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to select all customers
    CURSOR c_customers IS
        SELECT CustomerID, Name, Balance, IsVIP
        FROM Customers;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Processing VIP Status Promotion based on Balance (> $10,000) ---');
    
    FOR rec IN c_customers LOOP
        IF rec.Balance > 10000 THEN
            -- Only update if the flag is not already 'TRUE'
            IF rec.IsVIP != 'TRUE' THEN
                UPDATE Customers
                SET IsVIP = 'TRUE'
                WHERE CustomerID = rec.CustomerID;
                
                DBMS_OUTPUT.PUT_LINE('Promoted Customer: ' || rec.Name || ' (ID: ' || rec.CustomerID || 
                                     ', Balance: $' || TO_CHAR(rec.Balance, 'FM999,999,990.00') || ') to VIP.');
            ELSE
                DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ' (ID: ' || rec.CustomerID || 
                                     ') is already VIP.');
            END IF;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ' (ID: ' || rec.CustomerID || 
                                 ', Balance: $' || TO_CHAR(rec.Balance, 'FM999,999,990.00') || ') does not qualify for VIP.');
        END IF;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transaction committed successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/
