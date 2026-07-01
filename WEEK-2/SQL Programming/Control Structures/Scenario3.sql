SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to fetch loans due within the next 30 days and their associated customer details
    CURSOR c_due_loans IS
        SELECT c.CustomerID, c.Name, l.LoanID, l.EndDate, l.LoanAmount
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
        -- Note: If loans can be past due and we also want to remind them, 
        -- we could use: l.EndDate BETWEEN (SYSDATE - 365) AND (SYSDATE + 30)
        -- But "due within the next 30 days" typically means BETWEEN SYSDATE AND SYSDATE + 30.
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Sending Loan Due Reminders (Due in next 30 days) ---');
    
    FOR rec IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Dear ' || rec.Name || ' (CustomerID: ' || rec.CustomerID || '), ' ||
                             'this is a reminder that your loan (LoanID: ' || rec.LoanID || ') ' ||
                             'with amount $' || TO_CHAR(rec.LoanAmount, 'FM999,999,990.00') || 
                             ' is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD') || 
                             '. Please arrange for the payment.');
    END LOOP;
END;
/
