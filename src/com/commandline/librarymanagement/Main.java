package com.commandline.librarymanagement;

import com.commandline.bookmanagement.Book;
import com.commandline.bookmanagement.BookManagement;
import com.commandline.facultyMangement.FacultyDetails;
import com.commandline.facultyMangement.FacultyManagement;
import com.commandline.studentmangement.StudentDetails;
import com.commandline.studentmangement.StudentManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean flag = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManagement  bookManagement = new BookManagement();
        StudentManagement studentManagement = new StudentManagement();
        FacultyManagement facultyManagement = new FacultyManagement();
        while (flag) {
            System.out.println("1.Book Management\n" + "2.Faculty Management\n" + "3.Student Management\n" + "4.Complaint Box\n" + "5.Exit");
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bookManagement.runner();
                    break;
                case 2:
                    facultyManagement.runner();
                    break;
                case 3:
                    studentManagement.runner();
                    break;
                case 4:
                    System.out.println("1.Register a Complaint");
                    System.out.println("2.Exit");
                    int choice4 = scanner.nextInt();
                    ComplaintBox complaintBox = new ComplaintBox();
                    switch (choice4) {
                        case 1:
                            complaintBox.studentFacultyComplaint();
                            break;
                        case 2:
                            flag = false;
                            break;
                        default:
                            System.out.println("Enter correct choice");
                    }
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    throw new IllegalArgumentException("Enter the correct choice");
            }
        }
    }


}


class ComplaintBox {
    private  ArrayList<Book> damagedBooks = new  ArrayList<>();
    public void bookDamage() {
        damagedBooks();
        System.out.println("You complaint about damaged books has been register");
        System.out.println("Thanks for reporting your issue will be sorted soon");
        System.out.println("Please visit again :)");

    }

    public void infrastructure() {
        System.out.println("Thanks for providing your info we will surely improve our infrastructure ");
        System.out.println("Please visit again :)");

    }

    public void others() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You can write down your complaint below");
        String complaint = scanner.nextLine().toLowerCase();
        System.out.println("Your Complaint: " + complaint);
        System.out.println("Thanks for reporting your issue we will surely try to sort it");
        System.out.println("Please visit again :)");
    }

    public void studentFacultyComplaint() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you have any complaints please press Y/N");
        String response = scanner.nextLine().toLowerCase();
        if (response.equals("y")) {
            System.out.println("Please choose the complains from below options");
            System.out.println("1.Book Damage");
            System.out.println("2.Infrastructure of Library");
            System.out.println("3.Others");
            int response1 = scanner.nextInt();
            switch (response1) {
                case 1:
                    bookDamage();
                    break;
                case 2:
                    infrastructure();
                    break;
                case 3:
                    others();
                    break;
                default:
                    System.out.println("Wrong Option");
            }
        } else if (response.equals("n")) {
            System.out.println("We are glad to know that");
            System.out.println("Thanks for visiting :)");
        } else {
            System.out.println("Please enter Y/N carefully,this is a last chance");
            String response1 = scanner.nextLine().toLowerCase();
            if (response1.equals("y")) {
                System.out.println("Please choose the complains from below options");
                System.out.println("1.Book Damage");
                System.out.println("2.Infrastructure of Library");
                System.out.println("3.Others");
                int response2 = scanner.nextInt();
                switch (response2) {
                    case 1:
                        bookDamage();
                        break;
                    case 2:
                        infrastructure();
                        break;
                    case 3:
                        others();
                        break;
                    default:
                        System.out.println("Wrong Option");
                }
            } else {
                System.out.println("As you have given a wrong input 2nd time you need to repeat the process to register a complaint");
                System.out.println("Thanks for visiting :)");

            }
        }
    }
    public void damagedBooks(){
        Scanner scannerForInts = new Scanner(System.in);
        Scanner scannerForStrings = new Scanner(System.in);
        System.out.println("Enter the Book Details in the given way below");
        System.out.println("1.Book Id");
        System.out.println("2.Book Name");
        System.out.println("3.Book Author");
        System.out.println("4.Book Review");
        System.out.println("5.Book Count");
        damagedBooks.add(new Book(scannerForInts.nextInt(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForInts.nextInt()));

    }
}
