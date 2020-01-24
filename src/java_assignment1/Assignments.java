/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_assignment1;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Assignments {
    private String assignmentID;
    private String assignmentDescription;
    private Date deadline;

    public Assignments(String assignmentID, String assignmentDescription, Date deadline) {
        this.assignmentID = assignmentID;
        this.assignmentDescription = assignmentDescription;
        this.deadline = deadline;
    }

    public Assignments() {
    }

    public String getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(String assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    
}
