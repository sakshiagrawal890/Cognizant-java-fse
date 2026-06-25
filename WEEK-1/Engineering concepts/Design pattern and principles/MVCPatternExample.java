public class MVCPatternExample {
    static class Student {
        private String id;
        private String name;

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    static class StudentView {
        public void printStudentDetails(String studentId, String studentName) {
            System.out.println("Student: ");
            System.out.println("ID: " + studentId);
            System.out.println("Name: " + studentName);
        }
    }

    static class StudentController {
        private Student model;
        private final StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model = new Student(model.getId(), name);
        }

        public void updateView() {
            view.printStudentDetails(model.getId(), model.getName());
        }
    }

    public static void main(String[] args) {
        Student model = new Student("S100", "Rahul Sharma");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();
        controller.setStudentName("Anjali Verma");
        controller.updateView();
    }
}