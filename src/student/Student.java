/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 * A student class, creates a student object that takes 3 courses 
 * @author George Aziz
 */
public class Student {
    
    private String name;
    private String gender;
    private String email;
    private Course course1;
    private Course course2;
    private Course course3;
    

    public Student() {
        this.name = null;
        this.gender = null;
        this.email = null;
        this.course1 = null;
        this.course2 = null;
        this.course3 = null;
    }

    public Student(String name, String gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.course1 = null;
        this.course2 = null;
        this.course3 = null;
    }

    public Student(String name, String gender, String email, Course course1, 
            Course course2, Course course3) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
    }

    public Student(Student student) {
        this.name = student.name;
        this.gender = student.gender;
        this.email = student.email;
        this.course1 = new Course(course1);
        this.course2 = new Course(course2);
        this.course3 = new Course(course3);
    }
    
    /**
     * Calculates how many courses are passed
     * @return the number of courses passed
     */
    public int calcPassedCourseNum() {
        int coursePassed = 0; 
        
        if (course1.isPassed() == true)
            ++coursePassed;
        if (course2.isPassed() == true)
            ++coursePassed;
        if (course3.isPassed() == true)
            ++coursePassed;
        
        return coursePassed;
    }
    
    /**
     * Calculates the credits based on the if the course is passed or not
     * @return the total of credits earned  
     */
    public double calcTotalCredit() {
        double totalCredit = 0;
       
        if (course1.calcFinalScore() >= 60)
            totalCredit += course1.getCredit();
        if (course2.calcFinalScore() >= 60)
            totalCredit += course2.getCredit();
        if (course3.calcFinalScore() >= 60)
            totalCredit += course3.getCredit();
       
        return totalCredit;
    }
    
    /**
     * Checks if the email is valid or not
     * @return a boolean value whether the email is valid or not
     */
    public boolean isEmailValid() {
        if (email.length() > 320)
            return false;
        
        String firstPart = email.substring(0, email.indexOf("@"));
        String secondPart = email.substring(email.indexOf("@")+1, email.lastIndexOf("."));
        String thirdPart = email.substring(email.lastIndexOf(".")+1, email.length());
        
        return !(firstPart.isEmpty() || secondPart.isEmpty() || thirdPart.isEmpty());
    }
    
    /**
     * If the email is valid it returns the email
     * @return the email if it's valid
     */
    public String emailValid() {
        if (isEmailValid() == true)
            return email;
        
        return "This email is not valid";
    }
    
    /**
     * Formats calender data to a string
     * @return formatted string containing calender data
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-20s: %s\n", "Name", name);
        str += String.format("%-20s: %s\n", "Gender", gender);
        str += String.format("%-20s: %s\n\n", "Email", emailValid());
        str += String.format("%-20s %-25s %-10s %s\n", "Course", "Name", "Credit",
                "Score");
        str += String.format("--------------------------------------------------"
                + "-------------\n");
        str += String.format("%-20s: %-25s %-10.1f %.1f\n", "Course 1", 
                course1.getCourseName(), course1.getCredit(), course1.calcFinalScore());
        str += String.format("%-20s: %-25s %-10.1f %.1f\n", "Course 2", 
                course2.getCourseName(), course2.getCredit(), course2.calcFinalScore());
        str += String.format("%-20s: %-25s %-10.1f %.1f\n", "Course 3", 
                course3.getCourseName(), course3.getCredit(), course3.calcFinalScore());
        str += String.format("%-15s: %d\n", "Passed Courses", calcPassedCourseNum());
        str += String.format("%-15s: %.1f\n", "Total Credits", calcTotalCredit());

        return str;
    }

    public boolean equals(Student student) {
        return this.name.equals(student.name) &&
                this.gender.equals(student.gender) && 
                this.email.equals(student.email) && 
                this.course1.equals(student.course1) && 
                this.course2.equals(student.course2) && 
                this.course3.equals(student.course3);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse1() {
        return course1;
    }

    public void setCourse1(Course course1) {
        this.course1 = course1;
    }

    public Course getCourse2() {
        return course2;
    }

    public void setCourse2(Course course2) {
        this.course2 = course2;
    }

    public Course getCourse3() {
        return course3;
    }

    public void setCourse3(Course course3) {
        this.course3 = course3;
    }
}
