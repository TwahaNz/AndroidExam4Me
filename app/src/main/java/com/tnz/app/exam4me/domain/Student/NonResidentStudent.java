package com.tnz.app.exam4me.domain.Student;


import com.tnz.app.exam4me.services.Impl.TuitionFee;
import com.tnz.app.exam4me.services.FeesImpl;

import java.io.Serializable;


/**
 * Write a description of class NonResidentStudentFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NonResidentStudent extends Student implements Serializable
{
    private FeesImpl tuitionFee;
    private String studentName;
    private String studentNumber;

    public NonResidentStudent(Builder builder){
        super(builder.studentName, "" + builder.studentNumber);
        tuitionFee = builder.tuitionFee;
    }

    @Override
    public void payStudentFee(float amountPaid, String typeOfFee) {
        if (typeOfFee.toLowerCase().equals("tuition"))
            tuitionFee.payStudentFee(amountPaid);
    }

    @Override
    public String displayCurrentFee() {
        return "\n Current Fee: R" + tuitionFee.getStudentFee() +
                "\n =================================================================";
    }

    @Override
    public String displayAllFees() {
        return "\n Course Fee: R" + tuitionFee.retrieveStudentCosts(getFacultyName()) +
                "\n Current Fee Owing: R" + tuitionFee.getStudentFee() +
                "\n =================================================================";
    }

    @Override
    public float getTotalFees() {
        return tuitionFee.getStudentFee();
    }


    public static class Builder extends Student
    {
        private FeesImpl tuitionFee;
        private String studentName;
        private String studentNumber;

        public Builder(){
            tuitionFee = TuitionFee.getInstance();
        }

        public Builder studentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        public Builder studentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        @Override
        public void payStudentFee(float amountPaid, String typeOfFee) {
            if (typeOfFee.toLowerCase().equals("tuition"))
                tuitionFee.payStudentFee(amountPaid);
        }

        @Override
        public String displayCurrentFee() {
            return "\n Current Fee: R" + tuitionFee.getStudentFee() +
                    "\n =================================================================";
        }

        @Override
        public String displayAllFees() {
            return "\n Course Fee: R" + tuitionFee.retrieveStudentCosts(getFacultyName()) +
                    "\n Current Fee Owing: R" + tuitionFee.getStudentFee() +
                    "\n =================================================================";
        }

        @Override
        public float getTotalFees() {
            return tuitionFee.getStudentFee();
        }

        public NonResidentStudent build(){
            return new NonResidentStudent(this);
        }

        public Builder copyNonResidentStudent(NonResidentStudent student){
            tuitionFee = student.tuitionFee;
            studentName = student.studentName;
            studentNumber = student.studentNumber;

            return this;
        }
    }

}
