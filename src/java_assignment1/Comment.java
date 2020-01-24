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
public class Comment extends Forum {

    private String comments;

    public Comment() {
    }

    public Comment(String course, String subforum, String forumID, String topic, String discussion, String users, String comments) {
        super(course, subforum, forumID, topic, discussion, users);
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int post(String course, String sub, String forumidd, String topicc, String des, String user, String commentt) {
        String list[] = new String[]{course, sub, forumidd, topicc, des, user, commentt};
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String insert = "INSERT INTO COMMENT(COURSE,SUBFORUM,FORUMID,TOPIC,DESCRIPTION,USERS,COMMENTS) values (?,?,?,?,?,?,?)";
            PreparedStatement Stmt = Conn.prepareStatement(insert);
            Stmt.setString(1, list[0]);
            Stmt.setString(2, list[1]);
            Stmt.setString(3, list[2]);
            Stmt.setString(4, list[3]);
            Stmt.setString(5, list[4]);
            Stmt.setString(6, list[5]);
            Stmt.setString(7, list[6]);
            Stmt.executeBatch();
            Stmt.executeUpdate();
            Conn.close();
            Stmt.close();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insert Comment Error, " + e);
        }

        return 2;
    }

    public int edit(String course, String sub, String forumidd, String topicc, String des, String user, String commentt) {
        String[] listt = new String[]{course, sub, forumidd, topicc, des, user, commentt};
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String update = "UPDATE COMMENT SET COMMENTS = ? WHERE USERS = ? AND FORUMID = ? AND TOPIC = ?";
            PreparedStatement Stmt = Conn.prepareStatement(update);
            Stmt.setString(1, listt[6]);
            Stmt.setString(2, listt[5]);
            Stmt.setString(3, listt[2]);
            Stmt.setString(4, listt[3]);
            Stmt.executeUpdate();
            Conn.close();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Comment Error, " + e);
        }
        return 2;
    }

    int delete(String course, String sub, String forumidd, String topicc, String des, String user, String commentt) {
        String[] listt = new String[]{course, sub, forumidd, topicc, des, user, commentt};
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String delete = "DELETE FROM COMMENT WHERE COMMENTS = ? AND USERS = ? AND FORUMID =?";
            PreparedStatement Stmt = Conn.prepareStatement(delete);
            Stmt.setString(1, listt[6]);
            Stmt.setString(2, listt[5]);
            Stmt.setString(3, listt[2]);
            Stmt.execute();
            Conn.close();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Delete Course Error, " + e);
        }
        return 2;
    }

}
