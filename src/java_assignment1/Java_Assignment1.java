/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_assignment1;

import java.util.*;

/**
 *
 * @author DELL
 */
public class Java_Assignment1 {

    /**
     * @param args the command line arguments
     */
    //private static Database database;

    public static void main(String[] args) {
        //database.getStudentData();
        Database database = new Database();
        database.getAllData();
        //ArrayList<Student> list = database.getStudent();
        //System.out.println(list.get(0).getStudentName());
        //System.out.println(list.get(1).getStudentName());
        //Database db = new Database();
        //db.getStudent();
        //System.out.println(db.studentList.size());
        //String testName = db.studentList.get(0).getStudentName();
        //if(testName.equals("Lim Hor Yee")){
        //  System.out.println("correct");
        //}else{
        
        
        
        //Database db = new Database();
        //db.getAllData();
        
        Frame_Index index = new Frame_Index();
        index.setVisible(true);

        //  System.out.println("fail");
        //}
        //System.out.println(db.studentList.get(0).getStudentName());
        //System.out.println(db.studentList.get(1).getStudentName());
    }

}
