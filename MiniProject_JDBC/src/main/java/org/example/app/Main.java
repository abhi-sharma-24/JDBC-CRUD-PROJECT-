package org.example.app;

import org.example.app.Crudecode.*;
import org.example.app.model.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        StudentDAO sdao = new StudentDAO();
        ResultDAO rdao = new ResultDAO();

        while (true) {
            System.out.println(" Student Result Management ");
            System.out.println("1. Add Student");
            System.out.println("2. Show Students");
            System.out.println("3. Add Result");
            System.out.println("4. Show Result");
            System.out.println("5. Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter ID, Name, Course:");
                    Student s = new Student(sc.nextInt(), sc.next(), sc.next());
                    sdao.addStudent(s);
                    break;

                case 2:
                    var list = sdao.getAllStudents();
                    for (Student st : list) {
                        System.out.println(st.getStudentId() + " " + st.getName() + " " + st.getCourse());
                    }
                    break;

                case 3:
                    System.out.println("Enter StudentId, Marks, Grade:");
                    Result r = new Result(sc.nextInt(), sc.nextInt(), sc.next());
                    rdao.addResult(r);
                    break;

                case 4:
                    System.out.println("Enter StudentId:");
                    Result res = rdao.getResult(sc.nextInt());
                    if (res != null)
                        System.out.println(res.getStudentId() + " " + res.getMarks() + " " + res.getGrade());
                    else
                        System.out.println("No Result Found");
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
