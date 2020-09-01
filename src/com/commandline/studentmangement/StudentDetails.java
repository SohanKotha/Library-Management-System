package com.commandline.studentmangement;
/**
 * @author Tirumanpuri Rikshith
 * This class basically wraps all the student details into a object
 * and then initializes them with a constructor and then setup getters and setters
 * for editing the private instance variables and prints the details of the student
 * to the screen or to a file using the toString method
 */

import com.commandline.bookmanagement.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentDetails {

    protected int id;
    protected String fullName;
    protected String branch;
    protected ArrayList<Book> requestedBooks;
    protected ArrayList<Book> issuedBooks;

    public StudentDetails(int id, String fullName, String branch) {
        this.id = id;
        this.fullName = fullName;
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
