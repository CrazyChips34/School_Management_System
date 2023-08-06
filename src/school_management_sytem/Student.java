package school_management_sytem;
/*
*
* Keeping track of students fees, name and grade
*
*/

public class Student {
    private int id;
    private String name;
    private int grade;
    private double feesPaid;
    private double feesTotal;

    /*Constructor
    * To create a new student by initializing
    * Fees is R30 000 per year
    * fees paid initial 0
    * */
    public Student(int id, String name, int grade){
        feesPaid = 0;
        feesTotal = 30000;
        this.id=id;
        this.name=name;
        this.grade=grade;

    }

    //not altering the id and name so no need to set it

    //Getters & Setters


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //updates students grade
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
    //Adding fees as it is paid to feesPaid
    public void payFees(double fees) {
        feesPaid += fees;
        School.updateTotalMoneyEarned(feesPaid);
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    /*might add later on that with each grade the fees get higher
    public void setFeesTotal(double feesTotal) {
        this.feesTotal = feesTotal;
    }*/

    public double getFeesTotal() {
        return feesTotal;
    }

   public double getRemainingFees(){
        return feesTotal-feesPaid;
   }

    @Override
    public String toString() {
        return "Student's name: " + name
                + "\nTotal fees paid so far R" + feesPaid;

    }
}








