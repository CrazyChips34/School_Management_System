// Import required classes for the program
package school_management_sytem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create lists to store teachers and students
        List<Teacher> teacherList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();

        // Create a new School object using the lists of teachers and students
        School school = new School(teacherList, studentList);

        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Print a welcome message to the user
        System.out.println("----------Welcome to the Pinecrest Academy Management System----------");

        int choice;
        do {
            // Display the main menu options
            System.out.println("\nMenu:"
                    + "\n1. Add new Teachers"
                    + "\n2. Add new Students"
                    + "\n3. View all teachers"
                    + "\n4. View all outstanding school fees"
                    + "\n5. Exit");

            // Prompt the user to enter a number from 1 to 5 to select an option
            System.out.println("\nEnter a number 1-5 to select an option");
            String input = scanner.next();

            // Validate input to ensure it's a valid number
            if (input.matches("\\d+")) {
                choice = Integer.parseInt(input);

                // Based on the user's choice, execute the corresponding functionality
                switch (choice) {
                    case 1:
                        addTeachers(teacherList, scanner); // Add new teachers
                        break;
                    case 2:
                        addStudents(studentList, scanner); // Add new students
                        break;
                    case 3:
                        viewAllTeachers(teacherList); // View all teachers' details
                        break;
                    case 4:
                        school.viewOutstandingFees(studentList); // View outstanding school fees for students
                        break;
                    case 5:
                        System.out.println("Exiting the program."); // Exit the program
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number from 1 to 5.");
                choice = 0; // Set an invalid choice to repeat the loop
            }
        } while (choice != 5);
    }

    // Method to add new teachers to the teacherList
    private static void addTeachers(List<Teacher> teacherList, Scanner scanner) {
        System.out.println("\nEnter the number of teachers you want to add:");
        int numTeachers = getValidIntegerInput(scanner); // Validate input as an integer
        for (int i = 0; i < numTeachers; i++) {
            String teacherName;
            do {
                System.out.println("Enter teacher name (should start with a letter and contain only letters):");
                teacherName = scanner.next().trim();
            } while (!isValidName(teacherName)); // Repeat until a valid name is provided

            System.out.println("Enter teacher salary:");
            double teacherSalary = getValidDoubleInput(scanner); // Validate input as a double

            // Create a new Teacher object and add it to the teacherList
            Teacher teacher = new Teacher(teacherName, teacherSalary);
            teacherList.add(teacher);
        }
        System.out.println("Teachers added successfully!");
    }

    // Method to add new students to the studentList
    private static void addStudents(List<Student> studentList, Scanner scanner) {
        System.out.println("\nEnter the number of students you want to add:");
        int numStudents = getValidIntegerInput(scanner); // Validate input as an integer
        for (int i = 0; i < numStudents; i++) {
            String studentName;
            do {
                System.out.println("Enter student name (should start with a letter and contain only letters):");
                studentName = scanner.next().trim();
            } while (!isValidName(studentName)); // Repeat until a valid name is provided

            System.out.println("Enter student grade:");
            int studentGrade = getValidIntegerInput(scanner); // Validate input as an integer

            // Create a new Student object and add it to the studentList
            Student student = new Student(studentName, studentGrade);
            studentList.add(student);
        }
        System.out.println("Students added successfully!");
    }

    private static boolean isValidName(String name) {
        // Regular expression to check if the name contains only alphabetic characters and doesn't start with a number
        return name.matches("^[a-zA-Z][a-zA-Z]*$");
    }

    // Method to view details of all teachers
    private static void viewAllTeachers(List<Teacher> teacherList) {
        if (teacherList.isEmpty()) {
            System.out.println("No teachers found.");
        } else {
            System.out.println("Teachers:");
            for (Teacher teacher : teacherList) {
                System.out.println(teacher.toString());
            }
        }
    }

    // Method to validate integer input from the user
    private static int getValidIntegerInput(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.next().trim(); // Read and trim input to remove leading/trailing spaces
                int value = Integer.parseInt(input); // Parse the integer value
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer value.");
            }
        }
    }

    // Method to validate double input from the user
    private static double getValidDoubleInput(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.next().trim(); // Read and trim input to remove leading/trailing spaces
                double value = Double.parseDouble(input); // Parse the double value
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid floating-point value.");
            }
        }
    }
}
