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
public class Payment {

    private int paymentID;
    private int amount;
    private String description;
    private String date;
    private String status;
    private String learnerID;

    public Payment() {
    }

    public Payment(int paymentID, int amount, String description, String date, String status, String learnerID) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.status = status;
        this.learnerID = learnerID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLearnerID() {
        return learnerID;
    }

    public void setLearnerID(String learnerID) {
        this.learnerID = learnerID;
    }

    public int generateBill(int amount, String status, String studentid) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String update = "UPDATE PAYMENT SET AMOUNT = ?, STATUS =? WHERE STUDENTID = ?";
            PreparedStatement Stmt = Conn.prepareStatement(update);
            Stmt.setInt(1, amount);
            Stmt.setString(2, status);
            Stmt.setString(3, studentid);
            Stmt.executeUpdate();
            Conn.close();
            //System.out.println("tst");
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Payment Error, " + e);
        }
        return 2;
    }

}
