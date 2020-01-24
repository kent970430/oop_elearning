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
public class Admin extends Staff{
    private String adminName;
    private String adminEmail;
    
    Admin(){
        
    }

    Admin(String adminName, String adminEmail, String StaffID, String StaffUsername, String StaffPsw) {
        super(StaffID, StaffUsername, StaffPsw);
        this.adminName = adminName;
        this.adminEmail = adminEmail;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
    
    
}
