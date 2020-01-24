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
public class Student {
    private String studentID;
    private String studentName;
    private String studentIC;
    private String studentPhone;
    private String studentAddress;
    private String studentEmail;
    private String studentUsername;
    private String studentPassword;

    Student(){
        
    }
    
    Student(String studentID, String studentName, String studentIC, String studentPhone, String studentAddress, String studentEmail, String studentUsername, String studentPassword) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentIC = studentIC;
        this.studentPhone = studentPhone;
        this.studentAddress = studentAddress;
        this.studentEmail = studentEmail;
        this.studentUsername = studentUsername;
        this.studentPassword = studentPassword;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentIC() {
        return studentIC;
    }

    public void setStudentIC(String studentIC) {
        this.studentIC = studentIC;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }
    
    
}
