import java.util.*;

class Student {
    private String studentID;
    private String name;
    private double totalFees;
    private double paidFees;

    public Student(String studentID, String name, double totalFees) {
        this.studentID = studentID;
        this.name = name;
        this.totalFees = totalFees;
        this.paidFees = 0.0;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public double getPaidFees() {
        return paidFees;
    }

    public void makePayment(double amt) {
        if (amt > 0) {
            paidFees += amt;
        }
    }

    public double getRemainingFees() {
        return totalFees - paidFees;
    }
}

public class FeeManagementSystem {
    private Map<String, Student> studentDatabase;

    public FeeManagementSystem() {
        studentDatabase = new HashMap<>();
    }

    public void addStudent(String studentID, String name, double totalFees) {
        Student student = new Student(studentID, name, totalFees);
        studentDatabase.put(studentID, student);
    }

    public void makePayment(String studentID, double amt) {
        if (studentDatabase.containsKey(studentID)) {
            Student student = studentDatabase.get(studentID);
            student.makePayment(amt);
            System.out.println("Payment of" + amt + " made for " + student.getName());
        } else {
            System.out.println("not found.");
        }
    }

    public void displayStudentInfo(String studentID) {
        if (studentDatabase.containsKey(studentID)) {
            Student student = studentDatabase.get(studentID);
            System.out.println("ID: " + student.getStudentID());
            System.out.println("Name: " + student.getName());
            System.out.println("Total Fees:" + student.getTotalFees());
            System.out.println("Paid Fees:" + student.getPaidFees());
            System.out.println("Remaining Fees:" + student.getRemainingFees());
        } else {
            System.out.println("not found.");
        }
    }

    public static void main(String[] args) {
        FeeManagementSystem feeSystem = new FeeManagementSystem();
        feeSystem.addStudent("1", "Hasini",10000);
        feeSystem.addStudent("2", "Siddu",4000);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Make Payment");
            System.out.println("2. Student Info");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Student ID: ");
                String studentID = sc.next();
                System.out.print("Enter Payment Amount:");
                double amount = sc.nextDouble();
                feeSystem.makePayment(studentID, amount);
            } else if (choice == 2) {
                System.out.print("Enter Student ID: ");
                String studentID = sc.next();
                feeSystem.displayStudentInfo(studentID);
            } else if (choice == 3) {
                System.out.println("Exiting");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
