/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletdemo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dark
 */
public class StudentDataUtil {
    public static List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("sergio", "cacho", "ser@hotmail.com"));
        students.add(new Student("sergio2", "cacho", "ser2@hotmail.com"));
        students.add(new Student("sergio3", "cacho", "ser3@hotmail.com"));
        return students;
    }
}
