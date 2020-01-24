/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_assignment1;

/**
 *
 * @author DELL
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import javax.swing.*;

public class Login {

    private String user;

    Login() {

    }

    Login(String username) {
        this.user = username;
    }

    public int loginn(String username, String password, String cmb) {
        Database database = new Database();
        database.getAllData();
        switch (cmb) {
            case "Student":
                try {
                    ArrayList<Student> studList = database.getStudent();
                    int size = studList.size();
                    for (int i = 0; i < studList.size(); i++) {
                        if (studList.get(i).getStudentUsername().compareTo(username) == 0 && studList.get(i).getStudentPassword().compareTo(password) == 0) {
                            //new Frame_Student_Profile(studList.get(i).getStudentID(),studList.get(i).getStudentName(),studList.get(i).getStudentIC(),studList.get(i).getStudentPhone(),studList.get(i).getStudentAddress(),studList.get(i).getStudentEmail()).setVisible(true);                           
                            try {
                                String statt = "student";
                                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                                Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
                                String insert = "INSERT INTO USERS(USERNAME,STATUS) values (?,?)";
                                PreparedStatement Stmt = Conn.prepareStatement(insert);
                                Stmt.setString(1, username);
                                Stmt.setString(2, statt);
                                Stmt.executeBatch();
                                Stmt.executeUpdate();
                                Conn.close();
                                Stmt.close();
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Insert Error, " + e);
                            }
                            return 1;
                        }
                    }
                    return 4;

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Login Error, " + e);
                }
                break;

            case "Tutor":
                try {
                    ArrayList<Academic_staff> tutorList = database.getTutor();
                    int size = tutorList.size();
                    for (int i = 0; i < size; i++) {
                        String tutorUser = tutorList.get(i).getStaffUsername();
                        String tutorPsw = tutorList.get(i).getStaffPsw();
                        if (tutorUser.compareTo(username) == 0 && tutorPsw.compareTo(password) == 0) {
                            try {
                                String statt = "tutor";
                                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                                Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
                                String insert = "INSERT INTO USERS(USERNAME,STATUS) values (?,?)";
                                PreparedStatement Stmt = Conn.prepareStatement(insert);
                                Stmt.setString(1, username);
                                Stmt.setString(2, statt);
                                Stmt.executeBatch();
                                Stmt.executeUpdate();
                                Conn.close();
                                Stmt.close();
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Insert Error, " + e);
                            }
                            return 2;
                        }
                    }
                    return 4;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Login Error, " + e);
                }
                break;
            case "Admin":
                try {
                    ArrayList<Admin> adminList = database.getAdmin();
                    int size = adminList.size();
                    for (int i = 0; i < size; i++) {
                        String adminUser = adminList.get(i).getStaffUsername();
                        String adminPsw = adminList.get(i).getStaffPsw();
                        if (adminUser.compareTo(username) == 0 && adminPsw.compareTo(password) == 0) {
                            try {
                                String statt = "admin";
                                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                                Connection Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
                                String insert = "INSERT INTO USERS(USERNAME,STATUS) values (?,?)";
                                PreparedStatement Stmt = Conn.prepareStatement(insert);
                                Stmt.setString(1, username);
                                Stmt.setString(2, statt);
                                Stmt.executeBatch();
                                Stmt.executeUpdate();
                                Conn.close();
                                Stmt.close();
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Insert Error, " + e);
                            }
                            return 3;
                        }
                    }
                    return 4;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Login Error, " + e);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please select an user type!");
                break;
        }
        return 4;
    }

    public String getUser() {
        return user;
    }
}
