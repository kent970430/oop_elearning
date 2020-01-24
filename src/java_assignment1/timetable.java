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
public class timetable {
    private String Programme;
    private String Years;
    private String Semester;
    private String Course;
    private String Day;
    private String Time;
    private String user;
    private int credit;

    public timetable() {
    }

    public timetable(String Programme, String Years, String Semester, String Course, String Day, String Time, String user, int credit) {
        this.Programme = Programme;
        this.Years = Years;
        this.Semester = Semester;
        this.Course = Course;
        this.Day = Day;
        this.Time = Time;
        this.user = user;
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getProgramme() {
        return Programme;
    }

    public void setProgramme(String Programme) {
        this.Programme = Programme;
    }

    public String getYears() {
        return Years;
    }

    public void setYears(String Years) {
        this.Years = Years;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
}
