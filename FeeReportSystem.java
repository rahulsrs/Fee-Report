import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private String grade;
    private double pendingFees;
    private double paidFees;

    public Student(String name, int id, String grade, double pendingFees, double paidFees) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.pendingFees = pendingFees;
        this.paidFees = paidFees;
    }



    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade +
                ", Pending Fees: Rs " + pendingFees + ", Paid Fees: Rs " + paidFees;
    }
    // Get methods
    public int getId() {
        return id;
    }
    public void payFees(double amount) {
        if (amount > 0) {
            double maxPayment = pendingFees;
            double actualPayment = Math.min(amount, maxPayment);

            paidFees += actualPayment;
            pendingFees -= actualPayment;

            System.out.println("Payment successful. Updated fee status:\n" + this);
        } else {
            System.out.println("Invalid payment amount. Please enter a positive value.");
        }
    }
    public double getPendingFees(){
        return pendingFees;
    }
}




class FeeDatabase {
    private ArrayList<Student> students;

    public FeeDatabase() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Return null if no student with the given ID is found
    }

}

public class FeeReportSystem {
    public static void main(String[] args) {
        FeeDatabase feeDatabase = new FeeDatabase();
        Scanner scanner = new Scanner(System.in);

        // Sample data for testing
        feeDatabase.addStudent(new Student("Rahul Sharma", 101, "Grade 10", 50000.0, 20000.0));
        feeDatabase.addStudent(new Student("Priya Patel", 102, "Grade 11", 70000.0, 30000.0));
        feeDatabase.addStudent(new Student("Aarav Gupta", 103, "Grade 9", 40000.0, 15000.0));
        feeDatabase.addStudent(new Student("Diya Singh", 104, "Grade 12", 80000.0, 35000.0));
        feeDatabase.addStudent(new Student("Vedika Verma", 105, "Grade 11", 60000.0, 25000.0));
        feeDatabase.addStudent(new Student("Arjun Kumar", 106, "Grade 10", 55000.0, 22000.0));
        feeDatabase.addStudent(new Student("Ananya Joshi", 107, "Grade 12", 75000.0, 32000.0));
        feeDatabase.addStudent(new Student("Rohan Kapoor", 108, "Grade 9", 45000.0, 18000.0));
        feeDatabase.addStudent(new Student("Neha Malhotra", 109, "Grade 10", 52000.0, 20000.0));
        feeDatabase.addStudent(new Student("Aryan Singh", 110, "Grade 11", 68000.0, 28000.0));
        feeDatabase.addStudent(new Student("Avani Sharma", 111, "Grade 12", 77000.0, 33000.0));
        feeDatabase.addStudent(new Student("Kabir Verma", 112, "Grade 9", 42000.0, 16000.0));
        feeDatabase.addStudent(new Student("Ishaan Patel", 113, "Grade 11", 63000.0, 26000.0));
        feeDatabase.addStudent(new Student("Aaradhya Kapoor", 114, "Grade 10", 54000.0, 21000.0));
        feeDatabase.addStudent(new Student("Yash Malhotra", 115, "Grade 12", 72000.0, 30000.0));

        while (true) {
            System.out.println("1. Add Student\n2. Display All Students\n3. Search Student by ID\n4. Pay Fees\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character


            switch (choice) {
                case 1 -> {
                    // Adding a new student
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    System.out.print("Enter pending fees: ");
                    double pendingFees = scanner.nextDouble();
                    System.out.print("Enter paid fees: ");
                    double paidFees = scanner.nextDouble();
                    Student newStudent = new Student(name, id, grade, pendingFees, paidFees);
                    feeDatabase.addStudent(newStudent);
                    System.out.println("Student added successfully!");
                }
                case 2 ->
                    // Displaying all students
                        feeDatabase.displayAllStudents();

                case 3 -> {
                    // Searching a student by ID
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Student foundStudent = feeDatabase.findStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found:\n" + foundStudent);
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                }
                case 4 ->{
                    // Paying fees
                    System.out.print("Enter student ID to pay fees: ");
                    int payId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Student payStudent = feeDatabase.findStudentById(payId);

                    if (payStudent != null) {
                        System.out.println("Student found:\n" + payStudent);

                        double maxPayment = payStudent.getPendingFees();
                            System.out.println("Maximum amount you can pay: Rs " + maxPayment);

                        System.out.print("Enter the amount to pay: ");
                        double amountToPay = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character

                        payStudent.payFees(amountToPay);
                    } else {
                        System.out.println("Student with ID " + payId + " not found.");
                    }
                   }
                case 5 -> {
                    // Exiting the program
                    System.out.println("Exiting the Fee Report System. Goodbye!");
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
