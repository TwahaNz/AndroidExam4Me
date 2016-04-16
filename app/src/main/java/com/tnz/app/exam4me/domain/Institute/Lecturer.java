package com.tnz.app.exam4me.domain.Institute;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.tnz.app.exam4me.domain.Student.Student;
import com.tnz.app.exam4me.services.UploadMarksImpl;

//// TODO: 2016/04/16  remove the uploadMarksImpl
public class Lecturer implements UploadMarksImpl, Serializable
{


    private Faculty lectureFaculty;
    private Map<Integer, Student> students;
    private String name;
    private String roomNumber;
    private String staffID;
    
    private Lecturer(){}

    public Lecturer(Builder builder){
        this.name = builder.name;
        this.roomNumber = builder.roomNumber;
        this.staffID = builder.staffID;
        this.lectureFaculty = builder.lectureFaculty;
    }
    
    public void assignStudentMarks(Map<Integer, Student> studentsMarks){
        this.students = studentsMarks;
    }

    public String getName() {
        return name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getStaffID() {
        return staffID;
    }

    public Faculty getFaculty(){
        return lectureFaculty;
    }

    @Override
    public List<Map<Integer, int[]>> uploadTermMarks(int term) {
        return null;
    }

    public static class Builder
    {
        Faculty lectureFaculty;
        private String name;
        private String roomNumber;
        private String staffID;
                
        public Builder assignName(String name){
            this.name = name;
            return this;
        }
        
        public Builder assignRoomNumber(String roomNumber){
            this.roomNumber = roomNumber;
            return this;
        }
        
        public Builder assignStaffID(String staffID){
            this.staffID = staffID;
            return this;
        }
        
        public Builder assignFaculty(Faculty faculty){

            lectureFaculty = faculty;
            return this;
        }

        public Lecturer build(){
            return new Lecturer(this);
        }

        public Builder copyLecturer(Lecturer lecturer) {

            this.name = lecturer.name;
            this.roomNumber = lecturer.roomNumber;
            this.staffID = lecturer.staffID;
            this.lectureFaculty = lecturer.lectureFaculty;

            return this;
        }
    }
}
