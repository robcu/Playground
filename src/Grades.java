import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by robculclasure on 2/2/17.
 */
public class Grades {

    HashMap gradeRegistry = new HashMap();
    String currentStudent;
    double gradeAVG;
    ArrayList myGrades;
    Scanner scanner = new Scanner(System.in);

    void processStudentMenu(){
        System.out.println("Student File Options:");
        System.out.println("[1] - Select a student");
        System.out.println("[2] - Add a student");
        System.out.println("[3] - Remove a student");
        System.out.println("[4] - Exit program");

        switch(scanner.nextLine()){
            case "1":
                findStudent();
                break;
            case "2":
                addStudent();
                break;
            case "3":
                removeStudent();
                break;
            case "4":
                System.exit(0);
            default:
                System.out.println("Sorry, that is not a valid option. Please try again.");
                processStudentMenu();
        }
    }

    void findStudent(){
        boolean existence;
        System.out.println("Enter student name:");
        currentStudent = scanner.nextLine();
        existence = gradeRegistry.containsValue(currentStudent);
        if(existence){
            System.out.println("Record for " + currentStudent + " found.");
            processGradeMenu();
        }
        else{
            System.out.println("Record for " + currentStudent + " not found.");
            System.out.println("What would you like to do?");
            System.out.println("[A]dd student");
            System.out.println("[R]eturn to Main menu");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("a")){
                addStudent();
            }
            else if(input.equalsIgnoreCase("r")){
                processStudentMenu();
            }
        }
    }

    void addStudent(){
        gradeRegistry.put(currentStudent, myGrades); // HOW TO CREATE INITIAL EMPTY ARRAY
    }

    void removeStudent(){
        gradeRegistry.remove((currentStudent));
        System.out.println(currentStudent + " has been removed from the database.");
        processStudentMenu();
    }

    void processGradeMenu(){
        System.out.println(currentStudent + "'s Grades");
        System.out.println("[A]dd a new grade");
        System.out.println("[R]emove a grade");
        System.out.println("[S]how grade average");
        System.out.println("[E]xit to Main menu");
        switch (scanner.nextLine().toLowerCase()){
            case "a":
                //addGrade();++++++++++++++++++++++++++++++++++++++++++
                processGradeMenu();
                break;
            case "r":
                //removeGrade();++++++++++++++++++++++++++++++++++++++++++
                processGradeMenu();
                break;
            case "s":
                //findAverage();++++++++++++++++++++++++++++++++++++++++++
                processGradeMenu();
                break;
            case "e":
                processStudentMenu();
                break;
            default:
                System.out.println("Invalid option. Please try again:");
                processGradeMenu();
        }
    }



}