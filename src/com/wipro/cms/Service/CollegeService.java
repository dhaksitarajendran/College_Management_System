package com.wipro.cms.Service;

import com.wipro.cms.entity.Course;
import com.wipro.cms.entity.Enrollment;
import com.wipro.cms.entity.Student;
import com.wipro.cms.util.CourseFullException;
import com.wipro.cms.util.EnrollmentException;
import com.wipro.cms.util.InvalidStudentException;
import java.util.ArrayList;

public class CollegeService {
    private final ArrayList<Student> students;
    private final ArrayList<Course> courses;
    private final ArrayList<Enrollment> enrollments;


    public CollegeService(ArrayList<Student> students, ArrayList<Course> courses, ArrayList<Enrollment> enrollments) {
        this.students = students;
        this.courses = courses;
        this.enrollments = enrollments;
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public void addCourse(Course course){
        courses.add(course);
    }
    public void addEnrollment(Enrollment enrollment){
        enrollments.add(enrollment);
    }
    public boolean validateStudent(String studentId) throws InvalidStudentException {
        if(studentId==null || studentId.isEmpty()){
            throw new InvalidStudentException();
        }
        for(Student s: students){
            if(s.getStudentId().equals(studentId)){
                return true;
            }
        }return false;
    }

    public boolean validateCourse(String courseId) throws EnrollmentException {
        if(courseId==null || courseId.isEmpty()){
            throw new EnrollmentException();
        }
        for(Course c: courses){
            if(c.getCourseId().equals(courseId)){
                return true;
            }
        }return false;
    }

    public boolean checkCourseCapacity(String courseId) throws CourseFullException {
        if(courseId==null || courseId.isEmpty()){
            throw new CourseFullException();
        }
        for(Course c:courses){
            if(c.getCourseId().equals(courseId)){
                if(c.getEnrolledCount()>=c.getMaxCapacity()){
                    return false;
                }
            }

        }return true;

    }

    public Enrollment enrollStudent(String studentId, String courseId, String semester)
            throws Exception {
        if(!validateStudent(studentId)){
            throw new InvalidStudentException();  }  
        if(!validateCourse(courseId)){
            throw new EnrollmentException(); }   
        if(!checkCourseCapacity(courseId)){
            throw new CourseFullException(); 
            }
        else{
            String enrollmentId = "ENR001";
            Enrollment newEnrollment = new Enrollment(enrollmentId, studentId, courseId, semester, 0);
            enrollments.add(newEnrollment);
            for(Course c:courses){
                if(c.getCourseId().equals(courseId)){
                    c.setEnrolledCount(c.getEnrolledCount()+1);
                }
            }
            return newEnrollment;
        }

    }

    public boolean dropEnrollment(String enrollmentId) throws EnrollmentException {
        if(enrollmentId==null || enrollmentId.isEmpty()){
         System.out.println("Invalid Enrollment ID");
        }
        for(Enrollment e: enrollments){
            if(e.getEnrollmentId().equals(enrollmentId)){
                enrollments.remove(e);
                return true;
            }
        }
        return false;
    }

    public void printStudentEnrollments(String studentId){
        if(studentId==null || studentId.isEmpty()){
            System.out.println("Invalid Student ID");
            return;
        }
        for(Enrollment e: enrollments){
            if(e.getStudentId().equals(studentId)){
                System.out.println(e);
            }
        }
    }

    }

