public class TaskManagementSystem {
    private static class Node {
        String task;
        Node next;

        Node(String task) {
            this.task = task;
        }
    }

    private Node head;

    public void addTask(String task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
    }

    public void deleteTask(String task) {
        if (head == null) {
            return;
        }

        if (head.task.equals(task)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.equals(task)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void traverseTasks() {
        Node current = head;
        System.out.println("Tasks:");
        while (current != null) {
            System.out.println("- " + current.task);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        system.addTask("Write report");
        system.addTask("Review code");
        system.addTask("Attend meeting");
        system.traverseTasks();

        system.deleteTask("Review code");
        System.out.println("After deletion:");
        system.traverseTasks();
    }
}
