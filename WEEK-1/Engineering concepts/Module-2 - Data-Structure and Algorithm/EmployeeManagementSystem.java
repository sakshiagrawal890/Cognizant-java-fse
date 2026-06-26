public class EmployeeManagementSystem {
    private final String[] employeeIds;
    private final String[] employeeNames;
    private final String[] roles;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employeeIds = new String[capacity];
        employeeNames = new String[capacity];
        roles = new String[capacity];
    }

    public void addEmployee(String id, String name, String role) {
        if (size < employeeIds.length) {
            employeeIds[size] = id;
            employeeNames[size] = name;
            roles[size] = role;
            size++;
        } else {
            System.out.println("Employee storage is full");
        }
    }

    public void displayEmployees() {
        System.out.println("Employee Records:");
        for (int i = 0; i < size; i++) {
            System.out.println(employeeIds[i] + " | " + employeeNames[i] + " | " + roles[i]);
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(3);
        system.addEmployee("E101", "Aarav", "Developer");
        system.addEmployee("E102", "Mira", "Analyst");
        system.addEmployee("E103", "Rohan", "Manager");
        system.displayEmployees();
    }
}
