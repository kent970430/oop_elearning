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
public class PartTime extends Academic_staff {
    private static final String TOTALAMOUNT = "RM 3000.00";

    public PartTime() {
    }

    public PartTime(String StaffID, String tutorName, String tutorEmail, String workingStatus, String StaffUsername, String StaffPsw, String course) {
        super(StaffID, tutorName, tutorEmail, workingStatus, StaffUsername, StaffPsw, course);
    }
    
    @Override
    public String showSalary(){
        String Salary = TOTALAMOUNT;
        return Salary;
    }
    
}
