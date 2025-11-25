package org.example.app.Crudecode;

import org.example.app.model.Result;
import org.example.app.util.DBConnection;

import java.sql.*;

public class ResultDAO {

    Connection con = DBConnection.getConnection();

    public void addResult(Result r) throws Exception {
        String q = "INSERT INTO result VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setInt(1, r.getStudentId());
        ps.setInt(2, r.getMarks());
        ps.setString(3, r.getGrade());
        ps.executeUpdate();
    }

    public Result getResult(int id) throws Exception {
        String q = "SELECT * FROM result WHERE studentId=?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Result(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3)
            );
        }
        return null;
    }
}
