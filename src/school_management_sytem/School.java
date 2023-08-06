package school_management_sytem;
import java.util.List;
//import school.management.system.Student;

/**
 * Many teaches & students
 * ArrayList for teachers and students
 */
public class School {
    private List<Teacher> teachers;
    private List<Student> students;
    private static double totalMoneyEarned;
    private static double totalMoneySpent;

    /**
     * New school object is created.
     * @param teachers list of teachers.
     * @param students list of students.
     */
    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned=0;
        totalMoneySpent=0;
    }

    /**
     * Getters & Setters
     * @return lists of teachers and students
     */

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeachers(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public double getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public static void updateTotalMoneyEarned(double MoneyEarned) {
        totalMoneyEarned += MoneyEarned;
    }

    public double getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public static void updateTotalMoneySpent(double MoneySpent) {
     totalMoneyEarned -= MoneySpent;
    }

    public void viewOutstandingFees(List<Student> studentList) {
        for (Student student : studentList) {
            double outstandingFees = student.getFeesPaid() - student.getFeesTotal();
            if (outstandingFees > 0) {
                System.out.println(student.getName() + " has outstanding fees of R" + outstandingFees);
            } else {
                System.out.println(student.getName() + " has no outstanding fees");
            }
        }
    }
}
