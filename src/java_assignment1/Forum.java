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
public class Forum {

    private String course;
    private String subforum;
    private String forumID;
    private String topic;
    private String discussion;
    private String users;

    public Forum() {
    }

    public Forum(String course, String subforum, String forumID, String topic, String discussion, String users) {
        this.course = course;
        this.subforum = subforum;
        this.forumID = forumID;
        this.topic = topic;
        this.discussion = discussion;
        this.users = users;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSubforum() {
        return subforum;
    }

    public void setSubforum(String subforum) {
        this.subforum = subforum;
    }

    public String getForumID() {
        return forumID;
    }

    public void setForumID(String forumID) {
        this.forumID = forumID;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDiscussion() {
        return discussion;
    }

    public void setDiscussion(String discussion) {
        this.discussion = discussion;
    }

    public int post(String course, String subforum, String forumidd, String topicc, String dess,String user) {
        String list[] = new String[]{course, subforum, forumidd, topicc, dess, user};
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String insert = "INSERT INTO FORUM(COURSE,SUBFORUM,FORUMID,TOPIC,DESCRIPTION,USERS) values (?,?,?,?,?,?)";
            PreparedStatement Stmt = Conn.prepareStatement(insert);
            Stmt.setString(1, list[0]);
            Stmt.setString(2, list[1]);
            Stmt.setString(3, list[2]);
            Stmt.setString(4, list[3]);
            Stmt.setString(5, list[4]);
            Stmt.setString(6, list[5]);
            Stmt.executeBatch();
            Stmt.executeUpdate();
            Conn.close();
            Stmt.close();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insert Forum Error, " + e);
        }

        return 2;
    }

}
