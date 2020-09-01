package com.commandline.studentmangement;

/**
 * @author Tirumanpuri Rikshith
 * This class basically implements all the student methods
 * and then processes them to add, delete, retrieve, totalstudents and then
 * returns or prints them to the screen
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.commandline.bookmanagement.Book;

public class StudentManagement {

    public StudentDetails[] totalStudents = new StudentDetails[10];
    protected int numberOfStudentsToAdd = 0;
    protected int totalStudentsPresent = 0;

    public StudentManagement(){
        for (int i = 0; i < totalStudents.length; i++) {
            totalStudents[i] = null;
        }
    }

    public void addStudents() {
        Scanner scannerForInts = new Scanner(System.in);
        Scanner scannerForStrings = new Scanner(System.in);
        System.out.println("Enter number of students to add : ");
        numberOfStudentsToAdd = scannerForInts.nextInt();
        StudentDetails[] studentsToAdd = new StudentDetails[numberOfStudentsToAdd];
        //Initializes the student objects by taking the inputs at the runtime
        for (int i = 0; i < numberOfStudentsToAdd; i++) {
            System.out.println("Enter the details of the student at position " + (i+1));
            System.out.println("Enter the Student Details in the given way below");
            System.out.println("1.Student Id");
            System.out.println("2.Student Name");
            System.out.println("3.Student Branch");
            studentsToAdd[i] = new StudentDetails(scannerForInts.nextInt(), scannerForStrings.nextLine(), scannerForStrings.nextLine());
        }
        totalStudentsPresent = totalStudentsPresent + numberOfStudentsToAdd;
        //copies the objects of students to the main array
        addToSystem(studentsToAdd);
    }

    private void addToSystem(StudentDetails[] arrayToAdd) {
        int index = 0;
        outer:
        for (int i = 0; i < totalStudents.length; i++) {
            if (totalStudents[i] == null) {
                break outer;
            }
            index++;
        }
        System.arraycopy(arrayToAdd, 0, totalStudents, index, arrayToAdd.length);

    }

    public void removeStudents() {
        int i;
        StudentDetails studentDetails1 = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("+++++++++++++++++++");
        System.out.println("Enter the id of the student to delete");
        int studentToDelete = scanner.nextInt();
        //searches the element and records its index and then breaks out of the loop
        for (i = 0; i < totalStudents.length; i++) {
            if (totalStudents[i] == null) {
                continue;
            }
            if (studentToDelete == totalStudents[i].id) {
                studentDetails1 = totalStudents[i];
                totalStudents[i] = null;
                break;
            }
        }
        if(i>=totalStudents.length){
            System.out.println("Student Not Found");
        }else{
            System.out.println(studentDetails1.fullName + " with the id " + studentDetails1.id + " deleted from the system");
        }

    }

    public StudentDetails getStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+++++++++++++++++++");
        System.out.println("Enter the id of the student to retrieve");
        int studentToRetrieve = scanner.nextInt();
        //searches the element and records its index and then breaks out of the loop
        for (int i = 0; i < totalStudents.length; i++) {
            if (totalStudents[i] == null) {
                continue;
            }else if (studentToRetrieve == totalStudents[i].id) {
                return totalStudents[i];
            }
        }
        return null;
    }

    public void manageBooks() {
        StudentDetails studentToManage = getStudents();
        Scanner scannerForInts = new Scanner(System.in);
        Scanner scannerForStrings = new Scanner(System.in);
        if (studentToManage == null) {
            System.out.println("No Student found");
        } else {
            System.out.println("+++++++++++++++++++");
            System.out.println("\n1.Request Books\n2.Issue Books");
            System.out.println("+++++++++++++++++++");
            int choice = scannerForInts.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the Book Details in the given way below");
                    System.out.println("1.Book Id");
                    System.out.println("2.Book Name");
                    System.out.println("3.Book Author");
                    System.out.println("4.Book Review");
                    System.out.println("5.Book Count");
                    Book requestedBook = new Book(scannerForInts.nextInt(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForInts.nextInt());
                    studentToManage.requestedBooks.add(requestedBook);
                }
                break;
                case 2: {
                    System.out.println("Enter the Book Details in the given way below");
                    System.out.println("1.Book Id");
                    System.out.println("2.Book Name");
                    System.out.println("3.Book Author");
                    System.out.println("4.Book Review");
                    System.out.println("5.Book Count");
                    Book issuedBook = new Book(scannerForInts.nextInt(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForInts.nextInt());
                    studentToManage.issuedBooks.add(issuedBook);
                }
                default:
                    throw new IllegalArgumentException("Unexpected value: " + choice);
            }
        }
    }

    public int totalNumberOfStudents() {
        return totalStudentsPresent;
    }

    public void displayAllStudents() {
        System.out.println("++++++++++++++++++++++++++++++++");
        for (int i = 0; i < totalStudents.length; i++) {
            if (totalStudents[i] == null) {
                System.out.println("Slot Empty");
            } else {
                System.out.println(totalStudents[i]);
            }
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    public void runner() {
        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println("1.Add a Student or Students");
            System.out.println("2.Delete a Student");
            System.out.println("3.Get a Student");
            System.out.println("4. Display all Students");
            System.out.println("5.Manage Student Books");
            System.out.println("6.Exit");
            System.out.println("Enter your choice");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++");
            int choice3 = scanner.nextInt();
            switch (choice3) {
                case 1:
                    addStudents();
                    break;
                case 2:
                    removeStudents();
                    break;
                case 3:
                    StudentDetails studentDetails1 = getStudents();
                    if (studentDetails1 == null) {
                        System.out.println("no student found");
                    } else {
                        System.out.println(studentDetails1);
                    }
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    manageBooks();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter correct choice");
            }
        }
    }

}
