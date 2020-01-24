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
public class ProgrammeStructure {
    private String academicYear;
    private String semesters;
    private String ProgrammeCode;
    
    ProgrammeStructure(){
        
    }

    public ProgrammeStructure(String academicYear, String semesters, String programmeCode) {
        this.academicYear = academicYear;
        this.semesters = semesters;
        this.ProgrammeCode = programmeCode;
    }

    public String getProgrammeCode() {
        return ProgrammeCode;
    }

    public void setProgrammeCode(String ProgrammeCode) {
        this.ProgrammeCode = ProgrammeCode;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSemesters() {
        return semesters;
    }

    public void setSemesters(String semesters) {
        this.semesters = semesters;
    }
    
    
}
