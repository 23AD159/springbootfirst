package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext student = new ClassPathXmlApplicationContext("resources.xml");
        Student s= (Student) student.getBean("st");
        s.internshipProgram();
        System.out.println( "Main class" );
        SpringBoot f=(SpringBoot) student.getBean("fun");
        f.hello("hai");

        Assessment as = (Assessment) student.getBean("newtask1");
        as.task();
        Assessment as2 = (Assessment) student.getBean("newtask2");
        as2.task2("secondtask");

        Attendance attend = (Attendance) student.getBean("studentslist");
        attend.studentslist();
        Attendance absent = (Attendance) student.getBean("studentslist2");
        absent.studentslist2(12);

        Certification cer = (Certification) student.getBean("achievement");
        cer.achievements();
        Certification c2 = (Certification) student.getBean("achievement2");
        c2.coursecompletion("Yamuna Shri T");

    }
}