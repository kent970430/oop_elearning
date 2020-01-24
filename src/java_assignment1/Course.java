/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Course {

    private String courseID;
    private String courseName;
    private String courseDescription;
    private int creditHour;
    private String ProgrameCode;

    Course() {

    }

    public Course(String courseID, String courseName, String courseDescription, int creditHour, String ProgrammeCode) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.creditHour = creditHour;
        this.ProgrameCode = ProgrammeCode;
    }

    public String getProgrameCode() {
        return ProgrameCode;
    }

    public void setProgrameCode(String ProgrameCode) {
        this.ProgrameCode = ProgrameCode;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public int addCourse(String programme, String courseID, String courseName, String description, String credit) {
        String[] courses = new String[]{programme, courseID, courseName, description};
        int creditt = Integer.parseInt(credit);
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String insert = "INSERT INTO COURSE(PROGRAMMECODE,COURSEID,COURSENAME,COURSEDESCRIPTION,CREDITHOUR) values (?,?,?,?,?)";
            PreparedStatement Stmt = Conn.prepareStatement(insert);
            Stmt.setString(1, courses[0]);
            Stmt.setString(2, courses[1]);
            Stmt.setString(3, courses[2]);
            Stmt.setString(4, courses[3]);
            Stmt.setInt(5, creditt);
            Stmt.executeBatch();
            Stmt.executeUpdate();
            Conn.close();
            Stmt.close();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insert Course Error, " + e);
        }
        return 2;
    }

    public int deleteCourse(String courseID) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String delete = "DELETE FROM COURSE WHERE COURSEID = ?";
            PreparedStatement Stmt = Conn.prepareStatement(delete);
            Stmt.setString(1, courseID);
            Stmt.execute();
            Conn.close();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Delete Course Error, " + e);
        }
        return 2;
    }

    public int updateCourse(String course, String programme, String courseID, String courseName, String description, String credit) {
        String[] courses = new String[]{programme, courseID, courseName, description};
        int creditt = Integer.parseInt(credit);
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String update = "UPDATE COURSE SET COURSENAME = ?, COURSEDESCRIPTION = ?, CREDITHOUR =?, PROGRAMMECODE =? WHERE COURSEID = ?";
            PreparedStatement Stmt = Conn.prepareStatement(update);
            Stmt.setString(1, courses[2]);
            Stmt.setString(2, courses[3]);
            Stmt.setInt(3, creditt);
            Stmt.setString(4, courses[0]);
            Stmt.setString(5, course);
            Stmt.executeUpdate();
            Conn.close();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Course Error, " + e);
        }
        return 2;
    }

}
