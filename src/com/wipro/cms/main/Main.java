package com.wipro.cms.main;

import com.wipro.cms.Service.CollegeService;
import com.wipro.cms.entity.Course;
import com.wipro.cms.entity.Enrollment;
import com.wipro.cms.entity.Student;
import com.wipro.cms.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(0, "Rahul Sharma", "BSc CS", "S001"));
        students.add(new Student(0, "Ananya Rao", "BCom General", "S002"));
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("CO101", "Data Structures", 4, 2, 0));
        courses.add(new Course("CO102", "Operating Systems", 3, 1, 0));
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        CollegeService service = new CollegeService(students, courses, enrollments);
        try {
            service.validateStudent("S001");
            service.validateCourse("CO101");
            service.checkCourseCapacity("CO101");
            Enrollment en = service.enrollStudent("S001", "CO101", "SEM1");
            System.out.println("Enrollment Successful!");
            System.out.println("Enrollment ID: " + en.getEnrollmentId());
            System.out.println("Course ID     : " + en.getCourseId());
            System.out.println("Fee Amount    : Rs." + en.getFeeAmount());
            System.out.println("\n--- Student Enrollment Summary ---");
            service.printStudentEnrollments("S001");
        } catch (InvalidStudentException ise) {
            System.out.println(ise.toString());
        } catch (CourseFullException cfe) {
            System.out.println(cfe.toString());
        } catch (EnrollmentException ee) {
            System.out.println(ee.toString());
        } catch (Exception ex) {
            System.out.println("Unexpected Error: " + ex.toString());
        }
    }
}
