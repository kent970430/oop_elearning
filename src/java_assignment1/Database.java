/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_assignment1;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Database {

    public ArrayList<Student> studentList;
    public ArrayList<Admin> adminList;
    public ArrayList<Academic_staff> academicStaffList;
    public ArrayList<Programme> programmeList;
    public ArrayList<ProgrammeStructure> programmeStructureList;
    public ArrayList<Course> courseList;
    public static ArrayList<Announcement> announcement;
    public ArrayList<User> userList;
    public ArrayList<timetable> timeList;
    public ArrayList<Assignments> assignList;
    public static ArrayList<Forum> forumList;
    public static ArrayList<Comment> commentList;
    //public static ArrayList<Student> student = new ArrayList<Student>();

    public Student currentUser;
    public String studentID;
    public Student currentStudent;
    public String fullName;

    public void getAllData() {
        //Array has fix length and need to define the size of array whereas ArrayList doesn't need to bother about the length and no need define
        getStudentData();
        getTutorData();
        getAdminData();
        getProgrammeData();
        getProgrammeStructureData();
        getCourseData();
        addNotification();
        getUserData();
        getAssignmentData();
        getForumData();
        getCommentData();
    }

    public void getStudentData() {
        studentList = new ArrayList<Student>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String studentSql = "SELECT * FROM STUDENT";
            PreparedStatement stmt = conn.prepareStatement(studentSql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Student students = new Student(result.getString("STUDENTID"), result.getString("STUDENTNAME"), result.getString("STUDENTIC"), result.getString("STUDENTPHONE"), result.getString("STUDENTADDRESS"), result.getString("STUDENTEMAIL"), result.getString("STUDENTUSERNAME"), result.getString("STUDENTPASSWORD"));
                studentList.add(students);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Student Database Error, " + e);
        }
    }

    public void getTutorData() {
        academicStaffList = new ArrayList<Academic_staff>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection TutorConn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String tutorSql = "SELECT * FROM TUTOR";
            PreparedStatement tutorStmt = TutorConn.prepareStatement(tutorSql);
            ResultSet tutorResult = tutorStmt.executeQuery();
            while (tutorResult.next()) {
                Academic_staff tutors = new Academic_staff(tutorResult.getString("STAFFID"), tutorResult.getString("STAFFNAME"), tutorResult.getString("STAFFEMAIL"), tutorResult.getString("WORKINGSTATUS"), tutorResult.getString("STAFFUSERNAME"), tutorResult.getString("STAFFPASSWORD"), tutorResult.getString("COURSE"));
                academicStaffList.add(tutors);
            }
            TutorConn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tutor Database Error, " + e);
        }
    }

    public void getAdminData() {
        adminList = new ArrayList<Admin>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection AdminConn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String adminSql = "SELECT * FROM ADMIN";
            PreparedStatement adminStmt = AdminConn.prepareStatement(adminSql);
            ResultSet adminResult = adminStmt.executeQuery();
            while (adminResult.next()) {
                Admin admins = new Admin(adminResult.getString("STAFFID"), adminResult.getString("ADMINNAME"), adminResult.getString("ADMINEMAIL"), adminResult.getString("ADMINUSERNAME"), adminResult.getString("ADMINPASSWORD"));
                adminList.add(admins);
            }
            AdminConn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Admin Database Error, " + e);
        }
    }

    public void getProgrammeData() {
        programmeList = new ArrayList<Programme>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection ProgrammeConn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String programmeSql = "SELECT * FROM PROGRAMME";
            PreparedStatement programmeStmt = ProgrammeConn.prepareStatement(programmeSql);
            ResultSet programmeResult = programmeStmt.executeQuery();
            while (programmeResult.next()) {
                Programme programmes = new Programme(programmeResult.getString("PROGRAMMECODE"), programmeResult.getString("PROGRAMMENAME"));
                programmeList.add(programmes);
            }
            ProgrammeConn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Programme Database Error, " + e);
        }
    }

    public void getProgrammeStructureData() {
        programmeStructureList = new ArrayList<ProgrammeStructure>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection ProgrammeSConn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String programmeSSql = "SELECT * FROM PROGRAMMESTRUCTURE";
            PreparedStatement programmeSStmt = ProgrammeSConn.prepareStatement(programmeSSql);
            ResultSet programmeSResult = programmeSStmt.executeQuery();
            while (programmeSResult.next()) {
                ProgrammeStructure programmesS = new ProgrammeStructure(programmeSResult.getString("ACADEMICYEAR"), programmeSResult.getString("SEMESTERS"), programmeSResult.getString("PROGRAMMECODE"));
                programmeStructureList.add(programmesS);
            }
            ProgrammeSConn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Programme Structure Database Error, " + e);
        }
    }

    public void getCourseData() {
        courseList = new ArrayList<Course>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection CourseConn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String courseSql = "SELECT * FROM COURSE";
            PreparedStatement courseStmt = CourseConn.prepareStatement(courseSql);
            ResultSet courseResult = courseStmt.executeQuery();
            while (courseResult.next()) {
                Course course = new Course(courseResult.getString("COURSEID"), courseResult.getString("COURSENAME"), courseResult.getString("COURSEDESCRIPTION"), courseResult.getInt("CREDITHOUR"), courseResult.getString("PROGRAMMECODE"));
                courseList.add(course);
            }
            CourseConn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Course Database Error, " + e);
        }
    }

    public void getUserData() {
        userList = new ArrayList<User>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection userConn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String userSql = "SELECT * FROM USERS WHERE ID = (SELECT MAX(ID) FROM USERS)";
            PreparedStatement userStmt = userConn.prepareStatement(userSql);
            ResultSet userResult = userStmt.executeQuery();
            while (userResult.next()) {

                User userss = new User(userResult.getString("USERNAME"), userResult.getString("STATUS"));
                userList.add(userss);

            }
            userConn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The User Database Error, " + e);
        }

    }

    public void getTimeData() {
        timeList = new ArrayList<timetable>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection timeConn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String timeSql = "SELECT * FROM STUDENTSCHEDULE";
            PreparedStatement timeStmt = timeConn.prepareStatement(timeSql);
            ResultSet timeResult = timeStmt.executeQuery();
            while (timeResult.next()) {
                timetable tt = new timetable(timeResult.getString("PROGRAMMECODE"), timeResult.getString("YEARS"), timeResult.getString("SEMESTERS"), timeResult.getString("COURSE"), timeResult.getString("DAY"), timeResult.getString("TIME"), timeResult.getString("STUDENTUSER"), timeResult.getInt("CREDITHOUR"));
                timeList.add(tt);
            }
            timeConn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Time Table Database Error, " + e);
        }
    }

    public void addNotification() {
        announcement = new ArrayList<Announcement>();
        try {
            Date today = new Date();
            Announcement a = new Announcement("A0001", "Class Cancel", "OS class on friday cancel", "posted", today, "Student");
            Announcement a1 = new Announcement("A0002", "Assignment postpone", "OOP assignment postponed", "posted", today, "Tutor");
            Announcement a2 = new Announcement("A0003", "MERDEKA MALAYSIA", "Holiday on 31th August", "posted", today, "All");
            Announcement a3 = new Announcement("A0004", "CITC", "CITC need maintainence", "posted", today, "Admin");
            Announcement a4 = new Announcement("A0005", "Class Replacement", "OOAD Class replacement on next Monday", "posted", today, "Student");
            Announcement a5 = new Announcement("A0006", "Bar List", "Help the student on bar list", "posted", today, "Tutor");
            Announcement a6 = new Announcement("A0007", "B Block", "B Block is down", "posted", today, "Admin");
            Announcement a7 = new Announcement("A0008", "TARCIAN RUN", "We are having TARCIAN RUN on December", "posted", today, "All");
            Announcement a8 = new Announcement("A0009", "MUET EXAM", "Registration on muet is available now", "posted", today, "All");
            Announcement a9 = new Announcement("A0010", "Exam schedule is out", "Student please check on their exam schedule", "posted", today, "Student");
            announcement.add(a);
            announcement.add(a1);
            announcement.add(a2);
            announcement.add(a3);
            announcement.add(a4);
            announcement.add(a5);
            announcement.add(a6);
            announcement.add(a7);
            announcement.add(a8);
            announcement.add(a9);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Announcement Error");
        }
    }

    public ArrayList<Announcement> getAnnouncement() {
        return announcement;
    }

    public ArrayList<Student> getStudent() {
        return studentList;
    }

    public ArrayList<Academic_staff> getTutor() {
        return academicStaffList;
    }

    public ArrayList<Admin> getAdmin() {
        return adminList;
    }

    public ArrayList<Programme> getProgramme() {
        return programmeList;
    }

    public ArrayList<ProgrammeStructure> getProgrammeStructure() {
        return programmeStructureList;
    }

    public ArrayList<Course> getCourse() {
        return courseList;
    }

    public ArrayList<User> getUser() {
        return userList;
    }

    public ArrayList<timetable> getTimetable() {
        return timeList;
    }

    private void getAssignmentData() {
        assignList = new ArrayList<Assignments>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection assConn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String assSql = "SELECT * FROM ASSIGNMENTS";
            PreparedStatement assStmt = assConn.prepareStatement(assSql);
            ResultSet assResult = assStmt.executeQuery();
            while (assResult.next()) {
                String date = assResult.getString("DEADLINE");
                Date dateeee = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                Assignments ass = new Assignments(assResult.getString("ASSIGNMENTID"),assResult.getString("DESCRIPTION"),dateeee);
                assignList.add(ass);
            }
            assConn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Assignments Database Error, " + e);
        }
    }
    
    public ArrayList<Assignments> getAssignment(){
        return assignList;
    }
    
    private void getForumData() {
        forumList = new ArrayList<Forum>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection forumConn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String forumSql = "SELECT * FROM FORUM";
            PreparedStatement forumStmt = forumConn.prepareStatement(forumSql);
            ResultSet forumResult = forumStmt.executeQuery();
            while (forumResult.next()) {
                Forum forrr = new Forum(forumResult.getString("COURSE"),forumResult.getString("SUBFORUM"),forumResult.getString("FORUMID"),forumResult.getString("TOPIC"),forumResult.getString("DESCRIPTION"),forumResult.getString("USERS"));
                forumList.add(forrr);
            }
            forumConn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FORUM Database Error, " + e);
        }
    }
    
    public ArrayList<Forum> getForum(){
        return forumList;
    }
    
    private void getCommentData() {
        commentList = new ArrayList<Comment>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection commentConn = DriverManager.getConnection("jdbc:derby://localhost:1527/ELearningDatabase", "localhost", "123456");
            String comentSql = "SELECT * FROM COMMENT";
            PreparedStatement comentStmt = commentConn.prepareStatement(comentSql);
            ResultSet comentResult = comentStmt.executeQuery();
            while (comentResult.next()) {
                Comment com = new Comment(comentResult.getString("COURSE"),comentResult.getString("SUBFORUM"),comentResult.getString("FORUMID"),comentResult.getString("TOPIC"),comentResult.getString("DESCRIPTION"),comentResult.getString("USERS"),comentResult.getString("COMMENTS"));
                commentList.add(com);
            }
            commentConn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Comment Database Error, " + e);
        }
    }
    
    public ArrayList<Comment> getComment(){
        return commentList;
    }
}
