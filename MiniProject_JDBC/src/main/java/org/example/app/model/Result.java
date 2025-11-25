package org.example.app.model;

public class Result {
    private int studentId;
    private int marks;
    private String grade;

    public Result(int studentId, int marks, String grade) {
        this.studentId = studentId;
        this.marks = marks;
        this.grade = grade;
    }

    public int getStudentId() { return studentId; }
    public int getMarks() { return marks; }
    public String getGrade() { return grade; }
}
