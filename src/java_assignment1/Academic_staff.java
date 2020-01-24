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
public class Academic_staff extends Staff {

    private String tutorName;
    private String tutorEmail;
    private String workingStatus;
    private String course;

    Academic_staff() {

    }

    Academic_staff(String StaffID, String tutorName, String tutorEmail, String workingStatus, String StaffUsername, String StaffPsw, String course) {
        super(StaffID, StaffUsername, StaffPsw);
        this.tutorName = tutorName;
        this.tutorEmail = tutorEmail;
        this.workingStatus = workingStatus;
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getTutorEmail() {
        return tutorEmail;
    }

    public void setTutorEmail(String tutorEmail) {
        this.tutorEmail = tutorEmail;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }
    
    public String showSalary(){
        String Salary ="You have no Salary";
        return Salary;
    }

}
