SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to fetch customers and their associated loans
    CURSOR c_customer_loans IS
        SELECT c.CustomerID, c.Name, c.DOB, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;
        
    v_age NUMBER;
    v_discounted_rate NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Processing Loan Interest Discounts for Seniors (>60 years old) ---');
    
    FOR rec IN c_customer_loans LOOP
        -- Calculate age in years
        v_age := MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12;
        
        IF v_age > 60 THEN
            -- Calculate new interest rate (apply 1% discount, i.e., subtract 1.0 from the rate)
            v_discounted_rate := rec.InterestRate - 1;
            
            -- Keep interest rate non-negative
            IF v_discounted_rate < 0 THEN
                v_discounted_rate := 0;
            END IF;
            
            -- Update the loan interest rate
            UPDATE Loans
            SET InterestRate = v_discounted_rate
            WHERE LoanID = rec.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ' (ID: ' || rec.CustomerID || 
                                 ', Age: ' || ROUND(v_age, 1) || ') | ' ||
                                 'Loan ID: ' || rec.LoanID || ' | ' ||
                                 'Old Rate: ' || rec.InterestRate || '% | ' ||
                                 'New Rate: ' || v_discounted_rate || '%');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ' (ID: ' || rec.CustomerID || 
                                 ', Age: ' || ROUND(v_age, 1) || ') | No discount applied.');
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
