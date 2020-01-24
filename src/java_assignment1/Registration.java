/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Registration {

    private String registerID;
    private Date registerDate;
    private int TOTALCREDITHOUR = 0;

    Registration() {

    }

    public Registration(String registerID, Date registerDate) {
        this.registerID = registerID;
        this.registerDate = registerDate;
    }

    public String getRegisterID() {
        return registerID;
    }

    public void setRegisterID(String registerID) {
        this.registerID = registerID;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public int registerUser(String name, String ic, String contact, String email, String address, String username, String password) {
        String[] list = new String[]{name, ic, contact, email, address, username, password};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String studentSql = "SELECT STUDENTID FROM STUDENT";
            PreparedStatement stmt = conn.prepareStatement(studentSql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                registerID = result.getString("STUDENTID");
                registerID = String.valueOf(Integer.parseInt(registerID) + 1);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Student Database Error, " + e);
        }

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String insert = "INSERT INTO STUDENT(STUDENTID, STUDENTNAME,STUDENTIC,STUDENTPHONE,STUDENTADDRESS,STUDENTEMAIL,STUDENTUSERNAME,STUDENTPASSWORD,TOTALCREDITHOUR,REGISTERDATE) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement Stmt = Conn.prepareStatement(insert);
            Stmt.setString(1, registerID);
            Stmt.setString(2, list[0]);
            Stmt.setString(3, list[1]);
            Stmt.setString(4, list[2]);
            Stmt.setString(5, list[4]);
            Stmt.setString(6, list[3]);
            Stmt.setString(7, list[5]);
            Stmt.setString(8, list[6]);
            Stmt.setInt(9, TOTALCREDITHOUR);
            Stmt.setString(10, sdf.format(registerDate));
            Stmt.executeBatch();
            Stmt.executeUpdate();
            Conn.close();
            Stmt.close();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insert User Error, " + e);
        }

        return 2;
    }

    public int registerCourse(String programme, String year, String semester, String course, String day, String time, String user, int credit) {
        String[] courses = new String[]{programme, year, semester, course, day, time, user};
        int amm = calculateTotalCreditHour(user);
        int totalamm = amm * 120;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String insert = "INSERT INTO STUDENTSCHEDULE(PROGRAMMECODE,SEMESTERS,COURSE,DAY,TIME,STUDENTUSER,YEARS,CREDITHOUR) values (?,?,?,?,?,?,?,?)";
            PreparedStatement Stmt = Conn.prepareStatement(insert);
            Stmt.setString(1, courses[0]);

            Stmt.setString(2, courses[2]);
            Stmt.setString(3, courses[3]);
            Stmt.setString(4, courses[4]);
            Stmt.setString(5, courses[5]);
            Stmt.setString(6, courses[6]);
            Stmt.setString(7, courses[1]);
            Stmt.setInt(8, credit);
            Stmt.executeBatch();
            Stmt.executeUpdate();
            Conn.close();
            Stmt.close();
            
            
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection billConn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String billinsert = "INSERT INTO PAYMENT(AMOUNT,DESCRIPTION,PAYMENTDATE,STATUS,STUDENTID) values (?,?,?,?,?)";
            String status = "Pending";
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            String strDate = dateFormat.format(date);
            PreparedStatement billStmt = billConn.prepareStatement(billinsert);
            billStmt.setInt(1, totalamm);
            billStmt.setString(2, courses[3]);
            billStmt.setString(3, strDate);
            billStmt.setString(4, status);
            billStmt.setString(5, courses[6]);
            billStmt.executeBatch();
            billStmt.executeUpdate();
            billConn.close();
            billStmt.close();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insert Course Error, " + e);
        }

        return 2;
    }

    public int calculateTotalCreditHour(String name) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection timeConn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String timeSql = "Select Sum(CREDITHOUR) as TOTAL from STUDENTSCHEDULE where STUDENTUSER = ?";
            PreparedStatement timeStmt = timeConn.prepareStatement(timeSql);
            timeStmt.setString(1, name);
            ResultSet timeResult = timeStmt.executeQuery();
            while (timeResult.next()) {
                TOTALCREDITHOUR = Integer.parseInt(timeResult.getString("TOTAL"));
            }
            timeConn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Time Table Database Error, " + e);
        }
        return TOTALCREDITHOUR;
    }

    public int registerTutor(String id, String name, String email, String type, String username, String password) {
        String list[] = new String[]{id,name,email,type,username,password};
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String insert = "INSERT INTO TUTOR(STAFFID, STAFFNAME,STAFFEMAIL,WORKINGSTATUS, STAFFUSERNAME,STAFFPASSWORD) values (?,?,?,?,?,?)";
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
            JOptionPane.showMessageDialog(null, "Insert Tutor Error, " + e);
        }

        return 2;
    }

    public int updateTutor(String id, String course) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String update = "UPDATE TUTOR SET COURSE = ? WHERE STAFFID = ?";
            PreparedStatement Stmt = Conn.prepareStatement(update);
            Stmt.setString(1, course);
            Stmt.setString(2, id);
            Stmt.executeUpdate();
            Conn.close();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Assign Error, " + e);
        }
        return 2;
    }

}
