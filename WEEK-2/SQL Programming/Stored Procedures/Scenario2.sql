-- Stored Procedure to update employee salary with a bonus percentage in a given department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
    v_updated_rows NUMBER := 0;
    invalid_bonus EXCEPTION;
    empty_department EXCEPTION;
BEGIN
    -- Input validations
    IF p_bonus_percentage < 0 OR p_bonus_percentage IS NULL THEN
        RAISE invalid_bonus;
    END IF;
    
    IF p_department IS NULL OR TRIM(p_department) = '' THEN
        RAISE empty_department;
    END IF;
    
    -- Update salary by adding the bonus percentage
    UPDATE Employees
    SET Salary = Salary * (1 + (p_bonus_percentage / 100))
    WHERE UPPER(Department) = UPPER(p_department);
    
    v_updated_rows := SQL%ROWCOUNT;
    
    IF v_updated_rows = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Warning: No employees found in department: ' || p_department);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Bonus update process completed.');
        DBMS_OUTPUT.PUT_LINE('Total Employees updated in department ' || p_department || ': ' || v_updated_rows);
    END IF;
    
    COMMIT;
EXCEPTION
    WHEN invalid_bonus THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Bonus percentage cannot be negative or null.');
        RAISE_APPLICATION_ERROR(-20004, 'Bonus percentage cannot be negative or null.');
    WHEN empty_department THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Department name cannot be empty.');
        RAISE_APPLICATION_ERROR(-20005, 'Department name cannot be empty.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonus: ' || SQLERRM);
        RAISE;
END;
/

-- Test execution code block (commented out by default)
/*
SET SERVEROUTPUT ON;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Before Employee Bonus Update ---');
    FOR r IN (SELECT EmployeeID, Name, Department, Salary FROM Employees WHERE UPPER(Department) = 'IT') LOOP
        DBMS_OUTPUT.PUT_LINE('Employee: ' || r.Name || ' | Dept: ' || r.Department || ' | Salary: $' || r.Salary);
    END LOOP;
    
    -- Execute procedure with a 10% bonus for IT department
    UpdateEmployeeBonus('IT', 10.00);
    
    DBMS_OUTPUT.PUT_LINE('--- After Employee Bonus Update ---');
    FOR r IN (SELECT EmployeeID, Name, Department, Salary FROM Employees WHERE UPPER(Department) = 'IT') LOOP
        DBMS_OUTPUT.PUT_LINE('Employee: ' || r.Name || ' | Dept: ' || r.Department || ' | New Salary: $' || r.Salary);
    END LOOP;
END;
/
*/
