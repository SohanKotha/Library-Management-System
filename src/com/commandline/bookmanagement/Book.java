package com.commandline.bookmanagement;

/**
 * @author Anisha Shendkar
 * This class basically wraps all the book details into a object
 * and then initializes them with a constructor and then setup getters and setters
 * for editing the private instance variables and prints the details of the books
 * to the screen or to a file using the toString method
 */


public class Book {
    public int id;
    public String name;
    public String authorName;
    public String review;
    public int bookCount;

    public Book(int id, String name, String authorName, String review, int bookCount) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.review = review;
        this.bookCount = bookCount;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getBookCount() {
        return bookCount;
    }


    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", review='" + review + '\'' +
                ", bookCount=" + bookCount +
                '}';
    }

    public void bookDetails(Book bookDetails) {
        bookDetails.toString();
    }

}
