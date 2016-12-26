package pk.edu.nust.seecs.gradebook;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import pk.edu.nust.seecs.gradebook.dao.*;
import pk.edu.nust.seecs.gradebook.entity.*;

/**
 * My main App. 
 * <p>
 This executes everything.
 */

public class App {

    public static void main(String[] args) throws ParseException {
        CloDao clodao = new CloDao();
        ContentDao contentDao = new ContentDao();
        CourseDao courseDao = new CourseDao();
        GradeDao gradeDao = new GradeDao();
        StudentDao studentDao = new StudentDao();
        TeacherDao teacherDao = new TeacherDao();
//        Clo clo = clodao.getCloById(3);
//        clo.setName("Name Changed");
//        clodao.updateClo(clo);
        while(true){
            System.out.println("Enter a choice");
            System.out.println("Add Student");
            System.out.println("Add Teacher");
            System.out.println("Add Course");
            System.out.println("Add Clo");
            System.out.println("Add Content");
            System.out.println("Add Grade");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(choice==1){
                Student student = new Student();
                System.out.println("Enter the Name of the student");
                String name = scanner.next();
                student.setName(name);
                studentDao.addStudent(student);
                
            }
            else if(choice == 2){
                Teacher teacher = new Teacher();
                System.out.println("Enter the Name of the teacher");
                String name = scanner.next();
                teacher.setName(name);
                teacherDao.addTeacher(teacher);
            }
            else if(choice == 3){
                Clo clo = new Clo();
                System.out.println("Enter the Name of the Clo");
                String name = scanner.next();
                clo.setName(name);
                System.out.println("Enter the Description of the Clo");
                String description = scanner.next();
                clo.setDescription(description);

                System.out.println("Enter the CLO No.");
                String cloNo = scanner.next();
                clo.setPlo(cloNo);
                clodao.addClo(clo);
            }
            else if(choice == 4){
                Course course = new Course();
                System.out.println("Enter the course title.");
                String title = scanner.next();
                course.setClasstitle(title);
                System.out.println("Enter the credit hours.");
                int credits = scanner.nextInt();
                course.setCreditHours(credits);
                System.out.println("Enter the start date of the course");
                String start = scanner.next();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date inputDate = dateFormat.parse(start);
                course.setStartsOn(inputDate);
                System.out.println("Enter the End date of the course");
                String ends = scanner.next();
                inputDate = dateFormat.parse(ends);
                course.setEndsOn(inputDate);
                List<Teacher> teachers = teacherDao.getAllTeachers();
                System.out.println("Select teacher id from following list");
                for(int i=0;i<teachers.size();i++){
                    Teacher teacher = teachers.get(i);
                    System.out.println('#'+teacher.getTeacherId().toString()+"      Name:"+teacher.getName());
                }
                int id = scanner.nextInt();
                Teacher teacher = teacherDao.getTeacherById(id);
                course.setTeacher(teacher);
                courseDao.addCourse(course);
                
            }
            else if(choice == 6){
                List<Content> contents = contentDao.getAllContents();
                Grade grade = new Grade();
                System.out.println("Enter the name.");
                String name = scanner.next();
                grade.setName(name);

                System.out.println("Enter the Score.");
                int score = scanner.nextInt();
                grade.setScore(score);
                System.out.println("Select the course id from the following list");
                Content content;
                for(int i=0;i<contents.size();i++){
                    content = contents.get(i);
                    System.out.println("#"+content.getContentId().toString()+"  Title"+content.getTitle());
                }
                int input = scanner.nextInt();
                grade.setContentItem(contentDao.getContentById(input));
                gradeDao.addGrade(grade);
                
            }
            else if(choice==5){
                Content content = new Content();
                System.out.println("Enter the Description");
                String description = scanner.next();
                content.setDescription(description);
                System.out.println("Enter the Start Date");
                String start = scanner.next();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date inputDate = dateFormat.parse(start);
                content.setStarttime(inputDate);
                System.out.println("Enter the End date of the course");
                String ends = scanner.next();
                inputDate = dateFormat.parse(ends);
                content.setEndtime(inputDate);
                System.out.println("Enter the title of the course");
                String title = scanner.next();
                content.setTitle(title);
                System.out.println("Select course id from following table");
                List<Course> courses = courseDao.getAllCourses();
                for(int i=0;i<courses.size();i++){
                    Course course = courses.get(i);
                    System.out.println('#'+course.getCourseid().toString()+"   Name:"+course.getClasstitle());
                }
                int id = scanner.nextInt();
                Course course = courseDao.getCourseById(id);
                content.setCourse(course);
                contentDao.addContent(content);
                
            }
        }
        
//        // Add new clo
//        Clo clo = new Clo();
//        clo.setName("CLO 1");
//        clo.setDescription("Design efficient solutions for algorithmic problems");
//        clo.setPlo("2");
//        clodao.addClo(clo);
//
//        clodao.updateClo(clo);
//
//        // Delete an existing clo
//        //dao.deleteClo(1);
//
//        // Get all clos
//        for (Clo iter : clodao.getAllClos()) {
//            System.out.println(iter);
//        }
//
//        // Get clo by id
//        System.out.println(clodao.getCloById(1));

        
    }

}