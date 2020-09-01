package com.commandline.facultyMangement;
/**
 * @author Sohan Kotha
 * This class basically implements all the Faculty methods
 * and then processes them to add, delete, retrieve
 * Check the inTime and outTime totalFaculty and then
 * returns or prints them to the screen
 */

import com.commandline.bookmanagement.Book;
import com.commandline.bookmanagement.Book;
import com.commandline.studentmangement.StudentDetails;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Scanner;

public class FacultyManagement {

    private int totalTime = 0;
    private FacultyDetails[] totalFaculty = new FacultyDetails[2];
    private int numberOfFacultyToAdd = 0;
    private int totalFacultyPresent = 0;

    public void addFaculty() {
        Scanner scannerForInts = new Scanner(System.in);
        Scanner scannerForStrings = new Scanner(System.in);
        System.out.println("Enter number of faculty to add : ");
        numberOfFacultyToAdd = scannerForInts.nextInt();
        FacultyDetails[] facultyToAdd = new FacultyDetails[numberOfFacultyToAdd];
        //Initializes the student objects by taking the inputs at the runtime
        for (int i = 0; i < numberOfFacultyToAdd; i++) {
            System.out.println("Enter the details of the faculty at position " + (i+1));
            System.out.println("Enter the Faculty Details in the given way below");
            System.out.println("1.Faculty Id");
            System.out.println("2.Faculty Name");
            System.out.println("3.Faculty Branch");
            facultyToAdd[i] = new FacultyDetails(scannerForInts.nextInt(), scannerForStrings.nextLine(), scannerForStrings.nextLine());
        }
        totalFacultyPresent = totalFacultyPresent + numberOfFacultyToAdd;
        //copies the objects of faculty to the main array
        addToSystem(facultyToAdd);
    }


    private void addToSystem(FacultyDetails[] arrayToAdd) {
        int index = 0;
        outer:
        for (int i = 0; i < totalFaculty.length; i++) {
            if (totalFaculty[i] == null) {
                break outer;
            }
            index++;
        }
        System.arraycopy(arrayToAdd, 0, totalFaculty, index, arrayToAdd.length);
        //sort the main array after every insert
        sortTotalFaculty();
    }

    public void removeFaculty() {
        FacultyDetails facultyDetails1 = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the faculty to delete");
        int facultyToDelete = scanner.nextInt();
        //searches the element and records its index and then breaks out of the loop
        for (int i = 0; i <= totalFaculty.length; i++) {
            if (totalFaculty[i] == null) {
                continue;
            } else if (facultyToDelete == totalFaculty[i].id) {
                facultyDetails1 = totalFaculty[i];
                totalFaculty[i] = null;
                break;
            }
        }
        System.out.println(facultyDetails1.fullName + " with the id " + facultyDetails1.id + " deleted from the system");
    }

    public void sortTotalFaculty() {
        //TODO implement a sorting algorithm to sort the faculty
    }

    public FacultyDetails getFaculty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+++++++++++++++++++");
        System.out.println("Enter the id of the faculty to retrieve");
        int facultyToRetrieve = scanner.nextInt();
        //searches the element and records its index and then breaks out of the loop
        for (int i = 0; i <= totalFaculty.length; i++) {
            if (totalFaculty[i] == null) {
                continue;
            } else if (facultyToRetrieve == totalFaculty[i].id) {
                return totalFaculty[i];
            }
        }
        return null;
    }

    public int totalNumberOfFaculty() {

        return totalFacultyPresent;
    }

        public void displayAllFaculty () {
            System.out.println("++++++++++++++++++++++++++++++++");
            for (int i = 0; i < totalFaculty.length; i++) {
                if (totalFaculty[i] == null) {
                    System.out.println("Slot Empty");
                } else {
                    System.out.println(totalFaculty[i]);
                }
            }
            System.out.println("++++++++++++++++++++++++++++++++");
        }

        public void checkIn () {
            Scanner scanner = new Scanner(System.in);
            FacultyDetails facultyDetails1 = getFaculty();
            System.out.println("Enter the time when Faculty checkedOut in hours");
            int timeHours = scanner.nextInt();
            System.out.println("Enter the time when Faculty checkedOut in minutes");
            int timeMinutes = scanner.nextInt();
            timeHours *= 60;
            int totalTime = timeHours + timeMinutes;
            facultyDetails1.setCheckIn(totalTime);
            facultyDetails1.inLibrary = true;
            System.out.println("Check In successful");
        }

        public void checkOut () {
            Scanner scanner = new Scanner(System.in);
            FacultyDetails facultyDetails1 = getFaculty();
            if(facultyDetails1.inLibrary){
                System.out.println("Enter the time when Faculty checkedOut in hours");
                int timeHours = scanner.nextInt();
                System.out.println("Enter the time when Faculty checkedOut in minutes");
                int timeMinutes = scanner.nextInt();
                timeHours *= 60;
                int time = timeHours + timeMinutes;
                facultyDetails1.setCheckOut(time);
                completeCheckout(facultyDetails1);
            }else{
                System.out.println("Improper Checkout");
            }
        }

        public int computeTotalTime ( int startTime, int endTime){
            return (endTime - startTime);
        }

        public int computePenalty (FacultyDetails facultyDetails){
            int totalTime = computeTotalTime(facultyDetails.getCheckIn(), facultyDetails.getCheckOut());
            if (totalTime <= 30) {
                facultyDetails.setCheckIn(0);
                facultyDetails.setCheckOut(0);
                return 0;
            } else {
                int lateTime = totalTime - 30;
                int penalty = lateTime * 1;
                return penalty;
            }
        }

        public void completeCheckout (FacultyDetails facultyDetails){
            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);
            int totalPenalty = computePenalty(facultyDetails);
            int dues = facultyDetails.getOutStandingDues();
            dues = dues + totalPenalty;
            facultyDetails.setOutStandingDues(dues);
            System.out.println("Sir/Madam do you want to recommend any books to the students.Press Y/N");
            String option = scanner1.nextLine();
            option = option.toLowerCase();
            if(option.equals("y")){
                System.out.println("Enter the Book Details in the given way below");
                System.out.println("1.Book Id");
                System.out.println("2.Book Name");
                System.out.println("3.Book Author");
                System.out.println("4.Book Review");
                System.out.println("5.Book Count");
                Book book =new Book(scanner.nextInt(), scanner1.nextLine(), scanner1.nextLine(), scanner1.nextLine(), scanner.nextInt());
                facultyDetails.recommendedBooks.add(book);
                payDues(dues, facultyDetails);
            }else if(option.equals("n")){
                payDues(dues, facultyDetails);
            }else{
                System.out.println("Please repeat the process to complete the checkout");
            }
            facultyDetails.inLibrary = false;
        }

        public void payDues ( int dues, FacultyDetails facultyDetails){
            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Sir/Madam you have an OutstandingDue of : Rs." + facultyDetails.getOutStandingDues() + " would you like to pay this amount?");
            System.out.println("Press Y for yes and N for no");
            String response = scanner1.nextLine().toLowerCase();
            if (response.equals("y")) {
                System.out.println("How much amount would you like to pay Sir/Madam");
                int facultyMoney = scanner.nextInt();
                if (facultyMoney < dues) {
                    dues = dues - facultyMoney;
                    System.out.println("Sir/Madam after paying your dues you are still left with a due of : Rs." + dues);
                } else if (facultyMoney == dues) {
                    dues = 0;
                    System.out.println("Sir/Madam thanks for clearing your total due");
                } else if(facultyMoney > dues){
                    facultyMoney = facultyMoney - dues;
                    System.out.println("Sir/Madam thanks for clearing your total due,After paying you are left with a change of : Rs." + facultyMoney);
                }
            } else {
                System.out.println("Sir/Madam Thanks for visiting");
            }
        }


    public void runner() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while(flag){
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
                System.out.println("1.Add a Faculty or a Faculties");
                System.out.println("2.Delete a Faculty");
                System.out.println("3.Get a Faculty");
                System.out.println("4.Display all Faculty");
                System.out.println("5.Check-In faculty");
                System.out.println("6.Check-Out faculty");
                System.out.println("7.Exit");
                System.out.println("Enter your choice");
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addFaculty();
                        break;
                    case 2:
                        removeFaculty();
                        break;
                    case 3:
                        FacultyDetails facultyDetails = getFaculty();
                        System.out.println(facultyDetails.toString());
                        break;
                    case 4:
                        displayAllFaculty();
                        break;
                    case 5:
                        checkIn();
                        break;
                    case 6:
                        checkOut();
                        break;
                    case 7:
                        flag = false;
                        break;
                    default:
                        System.out.println("Enter correct choice");
                }
        }
        }
    }
