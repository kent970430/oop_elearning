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
public class Staff {
    private String StaffID;
    private String StaffUsername;
    private String StaffPsw;

    Staff(){
        
    }
    
    Staff(String StaffID, String StaffUsername, String StaffPsw) {
        this.StaffID = StaffID;
        this.StaffUsername = StaffUsername;
        this.StaffPsw = StaffPsw;
    }

    public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public String getStaffUsername() {
        return StaffUsername;
    }

    public void setStaffUsername(String StaffUsername) {
        this.StaffUsername = StaffUsername;
    }

    public String getStaffPsw() {
        return StaffPsw;
    }

    public void setStaffPsw(String StaffPsw) {
        this.StaffPsw = StaffPsw;
    }
    
    
}
