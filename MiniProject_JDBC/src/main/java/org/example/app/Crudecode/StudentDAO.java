package org.example.app.Crudecode;

import org.example.app.model.Student;
import org.example.app.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

    Connection con = DBConnection.getConnection();

    public void addStudent(Student s) throws Exception {
        String q = "INSERT INTO student VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setInt(1, s.getStudentId());
        ps.setString(2, s.getName());
        ps.setString(3, s.getCourse());
        ps.executeUpdate();
    }

    public ArrayList<Student> getAllStudents() throws Exception {
        ArrayList<Student> list = new ArrayList<>();
        String q = "SELECT * FROM student";
        PreparedStatement ps = con.prepareStatement(q);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Student(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
            ));
        }
        return list;
    }
}
