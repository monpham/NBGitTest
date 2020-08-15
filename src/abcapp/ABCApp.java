/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abcapp;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author 02
 */
public class ABCApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        List<Student> students = new ArrayList<>();
        int chosse;
        do {
            Showmenu(students);
            chosse = Integer.parseInt(sc.nextLine());

            switch (chosse) {
                case 1:
                   printListOfStudent(addListOfStudent());
                    System.out.println("-------------------------");
                    break;
                case 2:
                        students.sort((e1, e2) -> Double.compare(e1.getAvgmark(), e2.getAvgmark()));
                   avgMark(addListOfStudent());
                  
                    break;
                case 3:
                    System.out.println("GOOdbye!!");
                    break;

                default:
                    System.err.println("OHHHHHHHHHHHH NOOOOOOOOOOOO");
                  
                          
                    break;
            }
        } while (chosse != 3);
    }

    public static void addStudent(Student student) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id: ");
        student.setStudentID(Integer.parseInt(scanner.nextLine()));
        System.out.print("Name: ");
        student.setStudentName(scanner.nextLine());
        System.out.print("BATCH: ");
        student.setBatch(scanner.nextLine());
        System.out.print("Mark1 ");
        student.setMark1(Double.parseDouble(scanner.nextLine()));
        System.out.print("Mark: ");
        student.setMark2(Double.parseDouble(scanner.nextLine()));

    }

    public static void viewStudent(Student student) {
        System.out.println("Name: " + student.getStudentName());
        System.out.println("Avg Mark: " + student.getAvgmark());
        System.out.println("Rate: " + student.getRate());
    }

    public static List<Student> addListOfStudent() {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of student: ");
        int numberOfStudent = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudent; i++) {
            Student student = new Student();
            addStudent(student);
            students.add(student);
        }
        return students;
    }

    public static void printListOfStudent(List<Student> students) {
        for (Student student : students) {
            viewStudent(student);
        }
    }

    public static double avgMark(List<Student> students) {
        double avgMark = 0;
        for (Student student : students) {
            avgMark = (student.getMark1() + student.getMark2()) / 2;
            System.out.println(student.getStudentName() + ": " + avgMark);
          
        }

        return avgMark;
    }

    public static void Showmenu(List<Student> students) {
        System.out.println("1.STUDENT AVG AND RATE NO UP");
        System.out.println("2.STUDENT AVG NO RATE UP UP");
        System.out.println("3.OUTTTTTTTTTTTTTTTTT");

    }
}
