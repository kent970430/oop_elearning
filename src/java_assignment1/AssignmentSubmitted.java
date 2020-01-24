/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class AssignmentSubmitted {

    private String assignmentid;
    private String studentid;
    private Date dateSubmitted;
    private String tutor;
    private String content;
    private String comment;
    private int marks;
    private String status;

    public AssignmentSubmitted() {
    }

    public AssignmentSubmitted(String assignmentid, String studentid, Date dateSubmitted, String tutor, String content, String comment, int marks, String status) {
        this.assignmentid = assignmentid;
        this.studentid = studentid;
        this.dateSubmitted = dateSubmitted;
        this.tutor = tutor;
        this.content = content;
        this.comment = comment;
        this.marks = marks;
        this.status = status;
    }

    public String getAssignmentid() {
        return assignmentid;
    }

    public void setAssignmentid(String assignmentid) {
        this.assignmentid = assignmentid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static int submitAssignment(String id, String student, String today, String tutore, String content, String status) {
        String[] sa = new String[]{id, student, today, tutore, content, status};
        String comment = "This assignment does not mark yet!";
        int marks = 100;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String insert = "INSERT INTO ASSIGNMENTSUBMITTED(ASSIGNMENTID, STUDENTID,DATE,TUTOR, CONTENT,COMMENT,MARKS,STATUS) values (?,?,?,?,?,?,?,?)";
            PreparedStatement Stmt = Conn.prepareStatement(insert);
            Stmt.setString(1, sa[0]);
            Stmt.setString(2, sa[1]);
            Stmt.setString(3, sa[2]);
            Stmt.setString(4, sa[3]);
            Stmt.setString(5, sa[4]);
            Stmt.setString(6, comment);
            Stmt.setInt(7, marks);
            Stmt.setString(8, sa[5]);
            Stmt.executeBatch();
            Stmt.executeUpdate();
            Conn.close();
            Stmt.close();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Submit Error, " + e);
        }

        return 2;
    }

    public static int markAssignment(String students, String contents, int markss, String comments) {
        String[] mark = new String[]{students, contents, comments};
        String status = "Marked";
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String update = "UPDATE ASSIGNMENTSUBMITTED SET MARKS = ?, COMMENT = ?, STATUS = ? WHERE STUDENTID = ? AND CONTENT = ?";
            PreparedStatement Stmt = Conn.prepareStatement(update);
            Stmt.setInt(1, markss);
            Stmt.setString(2, mark[2]);
            Stmt.setString(3, status);
            Stmt.setString(4, mark[0]);
            Stmt.setString(5, mark[1]);
            Stmt.executeUpdate();
            Conn.close();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Assign Error, " + e);
        }
        return 2;
    }

}
