package school_management_sytem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Teacher meagan = new Teacher(1,"Meagan", 15000);
        Teacher jack = new Teacher(2,"Jack", 18000);
        Teacher lily = new Teacher(3,"Lily", 20000);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(meagan);
        teacherList.add(jack);
        teacherList.add(lily);

        Student johnny = new Student(1,"Johnny", 4);
        Student mark = new Student(2,"Mark", 12);
        Student lizzy = new Student(3,"Lizzy", 8);

        List<Student> studentList = new ArrayList<>();
        studentList.add(johnny);
        studentList.add(mark);
        studentList.add(lizzy);

        /*Pinecrest Academy*/
        School pca = new School(teacherList, studentList);

        Teacher kelly = new Teacher(6,"Kelly",18000);
        pca.addTeachers(kelly);

        johnny.payFees(8000);
        mark.payFees(17000);
        System.out.println("Pinecrest Academy has earned R" + pca.getTotalMoneyEarned());
        lizzy.payFees(10000);
        System.out.println("Pinecrest Academy has earned R" + pca.getTotalMoneyEarned());

        System.out.println("----------Making PCA PAY SALARY----------");
        meagan.receiveSalary(meagan.getSalary());
        System.out.println("PCA has spent for salary to "+ meagan.getName()
                + " and now has R" + pca.getTotalMoneyEarned());

        jack.receiveSalary(jack.getSalary());
        System.out.println("PCA has spent for salary to "+ jack.getName()
                + " and now has R" + pca.getTotalMoneyEarned());

        lily.receiveSalary(jack.getSalary());
        System.out.println("PCA has spent for salary to "+ lily.getName()
                + " and now has R" + pca.getTotalMoneyEarned());

        System.out.println(meagan);
        System.out.println(lizzy);
    }
}