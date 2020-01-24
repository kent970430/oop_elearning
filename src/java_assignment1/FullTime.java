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
public class FullTime extends Academic_staff {
    private static final String SALARYY = "RM 6000.00";

    public FullTime() {
    }

    public FullTime(String StaffID, String tutorName, String tutorEmail, String workingStatus, String StaffUsername, String StaffPsw, String course) {
        super(StaffID, tutorName, tutorEmail, workingStatus, StaffUsername, StaffPsw, course);
    }
    
    @Override
    public String showSalary(){
        String Salary = SALARYY;
        return Salary;
    }
    
    
    
}
