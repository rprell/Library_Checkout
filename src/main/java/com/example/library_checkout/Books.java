package com.example.library_checkout;

import javafx.scene.image.Image;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Books {
    public static ArrayList<Books> allBooks = new ArrayList<>();
    public String Name;
    public String Author;
    public String Genre;
    public int Year;
    public Image Image;
    public String CheckOut;
    public String CheckIn;


    public Books(String name, String author, String genre, int year) {
        this.Name = name;
        this.Author = author;
        this.Genre = genre;
        this.Year = year;
        allBooks.add(this);
    }

    public static ArrayList<Books> getAllBooks() {
        return allBooks;
    }

    public static void setAllBooks(ArrayList<Books> allBooks) {
        Books.allBooks = allBooks;
    }

    public String getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(String checkOut) {
        CheckOut = checkOut;
    }

    public String getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(String checkIn) {
        CheckIn = checkIn;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {Name = name;}

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {Author = author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public int getYear() {return Year;}

    public void setYear(int year) {Year = year;}

    public Image getImage() {return Image;}

    public void setImage(Image image) {Image = image;}



    public static void readData() {
        Scanner sc = null;
        try {
            File text = new File("Books");
            sc = new Scanner(text);
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                System.out.println(line);
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("\t");
                String name = lineScanner.next();
                String author = lineScanner.next();
                String genre = lineScanner.next();
                int year = lineScanner.nextInt();
                //Image image = name+".jpg"
                new Books(name,author,genre,year);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) sc.close();
        }
    }

    public String toString() {
        String printOutString = "Book: ";
        printOutString = printOutString + Name + " ";
        printOutString = printOutString + Author + " ";
        printOutString = printOutString + Genre + " ";
        printOutString = printOutString + Year + " ";
        printOutString = printOutString + Image + " ";
        if (CheckOut != null) {
            printOutString = printOutString + CheckOut + " ";
        } else {
            printOutString = printOutString + "NOT checked out";
        }
        if (CheckIn != null) {
            printOutString = printOutString + CheckIn + " ";
        } else {
            printOutString = printOutString + "NOT checked in";
        }
        return printOutString + "\n";
    }
}
