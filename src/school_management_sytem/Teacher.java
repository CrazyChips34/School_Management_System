package school_management_sytem;

/**
 * keeps track of teachers information name, id & salary
 */
public class Teacher {
    private int teacherId;
    private static int nextTeacherId = 1;
    private String name;
    private double salary;
    private double salaryEarned;

    /**
     * Creates a teacher object
     *
     * @param name   of the teacher
     * @param salary of the teacher
     */
    public Teacher(String name, double salary){
        this.teacherId = nextTeacherId;
        nextTeacherId++;
        this.name = name;
        this.salary = salary;
        this.salaryEarned = 0;
    }

    /**
     * Getters because it's going to be changed
     * @return the id,name
     */
    public int getId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    /**
     * Setting the salary
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Adds to salaryEarned
     * Removes from the total money earned by the  school
     * @param salary
     */
    public void receiveSalary(double salary){
        salaryEarned += salary;
        School.updateTotalMoneyEarned(salary);
    }
    /**/
    @Override
    public String toString() {
        return "Name of the Teacher: "+ name
                +"\nTotal salary earned so far R" + salaryEarned;
    }
}
