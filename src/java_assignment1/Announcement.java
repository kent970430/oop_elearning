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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Announcement {

    private String announcementID;
    private String announcementTitle;
    private String announcementDescription;
    private String announcementStatus;
    private Date announcementDate;
    private String id;

    Announcement() {
    }

    public Announcement(String announcementID, String announcementTitle, String announcementDescription, String announcementStatus, Date announcementDate, String id) {
        this.announcementID = announcementID;
        this.announcementTitle = announcementTitle;
        this.announcementDescription = announcementDescription;
        this.announcementStatus = announcementStatus;
        this.announcementDate = announcementDate;
        this.id = id;
    }

    public String getAnnouncementID() {
        return announcementID;
    }

    public void setAnnouncementID(String announcementID) {
        this.announcementID = announcementID;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getAnnouncementDescription() {
        return announcementDescription;
    }

    public void setAnnouncementDescription(String announcementDescription) {
        this.announcementDescription = announcementDescription;
    }

    public String getAnnouncementStatus() {
        return announcementStatus;
    }

    public void setAnnouncementStatus(String announcementStatus) {
        this.announcementStatus = announcementStatus;
    }

    public Date getAnnouncementDate() {
        return announcementDate;
    }

    public void setAnnouncementDate(Date announcementDate) {
        this.announcementDate = announcementDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int postAnnouncement(String id, String title, String description, String status, Date today, String audiencee) {
        try {
            Database database = new Database();
            database.getAllData();

            ArrayList<Announcement> annn = database.getAnnouncement();

            Announcement l = new Announcement(id, title, description, status, today, audiencee);
            database.announcement.add(l);
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insert Course Error, " + e);
        }
        return 2;
    }

}
