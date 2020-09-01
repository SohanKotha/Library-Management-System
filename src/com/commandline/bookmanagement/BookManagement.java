package com.commandline.bookmanagement;
/**
 * @author Anisha Shendkar
 * This class basically implements all the book methods
 * and then processes them to add, delete, retrieve, totalbooks and then
 * returns or prints them to the screen
 */

//import jdk.internal.util.xml.impl.Pair;

import com.commandline.facultyMangement.FacultyDetails;
import com.commandline.studentmangement.StudentDetails;

import java.util.*;

public class BookManagement {
    private Book[] totalBooks = new Book[2];
    private int numberOfBookToAdd = 0;
    private int totalBookPresent = 0;
    private int id;


    public void addBooks() {
        Scanner scannerForInts = new Scanner(System.in);
        Scanner scannerForStrings = new Scanner(System.in);
        System.out.println("Enter number of Book to add : ");
        numberOfBookToAdd = scannerForInts.nextInt();
        Book[] bookToAdd = new Book[numberOfBookToAdd];
        //Initializes the Book objects by taking the inputs at the runtime
        for (int i = 0; i < numberOfBookToAdd; i++) {
            System.out.println("Enter the details of the book at position " + (i+1));
            System.out.println("Enter the Book Details in the given way below");
            System.out.println("1.Book Id");
            System.out.println("2.Book Name");
            System.out.println("3.Book Author");
            System.out.println("4.Book Review");
            System.out.println("5.Book Count");
            bookToAdd[i] = new Book(scannerForInts.nextInt(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForStrings.nextLine(), scannerForInts.nextInt());
        }
        totalBookPresent = totalBookPresent + numberOfBookToAdd;
        //copies the objects of students to the main array
        addToSystem(bookToAdd);
    }

    private void addToSystem(Book[] arrayToAdd) {
        int index = 0;
        outer:
        for (int i = 0; i < totalBooks.length; i++) {
            if (totalBooks[i] == null) {
                break outer;
            }
            index++;
        }
        System.arraycopy(arrayToAdd, 0, totalBooks, index, arrayToAdd.length);
    }


    public void removeBook() {
        Book book1 = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the book to delete");
        int studentToDelete = scanner.nextInt();
        //searches the element and records its index and then breaks out of the loop
        for (int i = 0; i <= totalBooks.length; i++) {
            if (totalBooks[i] == null) {
                continue;
            } else if (studentToDelete == totalBooks[i].id) {
                book1 = totalBooks[i];
                totalBooks[i] = null;
                break;
            }
        }
        System.out.println(book1.name + " with the id " + book1.id + " deleted from the system");
    }


    public Book getBook() {
        int index = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("Enter the Book id to remove");
        int idToSearch = scanner.nextInt();
        //converts the list to array and then assigns it to the main array
        for (int i = 0; i < totalBooks.length; i++) {
            if (totalBooks[i] == null) {
                continue;
            } else if (idToSearch == totalBooks[i].id) {
                return totalBooks[i];
            }
        }
        return null;
    }


    public int totalNumberOfBooks() {
        return totalBooks.length;
    }

    public void displayAllBooks() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        for (int i = 0; i < totalBooks.length; i++) {
            if (totalBooks[i] == null) {
                System.out.println("Book Slot  is Empty");
            } else {
                System.out.println(totalBooks[i]);

            }
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
    }

    public void runner() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println("1.Add a Book or Books");
            System.out.println("2.Delete a Book");
            System.out.println("3.Get a Book");
            System.out.println("4.Display all Books");
            System.out.println("5.Exit");
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            int choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    Book book1 = getBook();
                    System.out.println(book1.toString());
                case 4:
                    displayAllBooks();
                    break;
                case 5:
                    flag = false;
                default:
                    System.out.println("Enter correct choice");
            }

        }
    }
}




