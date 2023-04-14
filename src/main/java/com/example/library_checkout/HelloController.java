package com.example.library_checkout;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class HelloController {

    public Pagination pagination;
    public ListView infoList;
    public DatePicker calendar;
    public ImageView bookImage;
    public Button checkOutButton;
    public Button checkInButton;
    int currentBook;
    int selectedBook;

    public void initialize() throws FileNotFoundException {
        restoreOrReadData();
        Books.readData();
        System.out.println(Books.getAllBooks());

        Image image1 = new Image(new FileInputStream(new File("BookCovers/Peter_Rabbit_first_edition_1902a.jpg")));
        Image image2 = new Image(new FileInputStream(new File("BookCovers/Johnathan_Livingston_Seagull.jpg")));
        Image image3 = new Image(new FileInputStream(new File("BookCovers/HungryCaterPillar.jpg")));
        Image image4 = new Image(new FileInputStream(new File("BookCovers/An_early_reprint_of__A_Message_to_Garcia_.jpg")));
        Image image5 = new Image(new FileInputStream(new File("BookCovers/220px-To_Kill_a_Mockingbird_(first_edition_cover).jpg")));
        Image image6 = new Image(new FileInputStream(new File("BookCovers/Dollanganger01_FlowersInTheAttic.jpg")));
        Image image7 = new Image(new FileInputStream(new File("BookCovers/Cosmos_book.jpg")));
        Image image8 = new Image(new FileInputStream(new File("BookCovers/Sofies_verden.jpg")));
        Image image9 = new Image(new FileInputStream(new File("BookCovers/AngelsAndDemons.jpg")));
        Image image10 = new Image(new FileInputStream(new File("BookCovers/KaneAndAbel.jpg")));




        ArrayList<Books> allBooks = Books.getAllBooks();
        allBooks.get(0).setImage(image1);
        allBooks.get(1).setImage(image2);
        allBooks.get(2).setImage(image3);
        allBooks.get(3).setImage(image4);
        allBooks.get(4).setImage(image5);
        allBooks.get(5).setImage(image6);
        allBooks.get(6).setImage(image7);
        allBooks.get(7).setImage(image8);
        allBooks.get(8).setImage(image9);
        allBooks.get(9).setImage(image10);


        bookImage.setImage(image1);
        bookImage.setImage(image2);
        bookImage.setImage(image3);
        bookImage.setImage(image4);
        bookImage.setImage(image5);
        bookImage.setImage(image6);
        bookImage.setImage(image7);
        bookImage.setImage(image8);
        bookImage.setImage(image9);
        bookImage.setImage(image10);

        currentBook = 0;
        bookImage.setImage(image1);
        infoList.getItems().add(allBooks.get(0).getName());
        infoList.getItems().add(allBooks.get(0).getAuthor());
        infoList.getItems().add(allBooks.get(0).getGenre());
        infoList.getItems().add(allBooks.get(0).getYear());

        //choosePicture.getSelectionModel().select(currentBook);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            public Node call(Integer pageIndex) {
                paginationClicked(pageIndex);
                return bookImage;
            }
        });

    }

    //restoreOrReadData();

        //pagination.setPageFactory((pageIndex)-> {

      //  ImageView bookImage = new ImageView();

        //Label label1 = new Label("Content for page with index: " + pageIndex);

        //return new VBox(bookImage);
   // });

    public void paginationClicked(int selectedIndex) {
        System.out.println(selectedIndex);
        bookImage.setImage(Books.getAllBooks().get(selectedIndex).getImage());
        infoList.getItems().clear();
        ArrayList<Books> allBooks = Books.getAllBooks();
        infoList.getItems().add(allBooks.get(selectedIndex).getName());
        infoList.getItems().add(allBooks.get(selectedIndex).getAuthor());
        infoList.getItems().add(allBooks.get(selectedIndex).getGenre());
        infoList.getItems().add(allBooks.get(selectedIndex).getYear());
        if (allBooks.get(selectedIndex).getCheckOut() != null) {
            infoList.getItems().add(allBooks.get(selectedIndex).getCheckOut());
        }


        // choosePicture.getSelectionModel().select(currentBook);
       // pictureNumberLabel.setText("Picture #" + (currentBook+1) + " of " + images.size());
    }

    public void CheckOutButtonPressed() {
        LocalDate toDoDate = calendar.getValue();
        infoList.getItems().add("Check Out" + " - " + toDoDate.toString());
        calendar.setValue(null);
        selectedBook = pagination.getCurrentPageIndex();
        Books.getAllBooks().get(selectedBook).setCheckOut(toDoDate.toString());
    }


    public void saveData() throws Exception {
        FileOutputStream fileOut = new FileOutputStream("SavedBooks");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        ArrayList<String> temporaryList = new ArrayList<>(infoList.getItems());
        out.writeObject(temporaryList);

        out.close();
        fileOut.close();
        System.out.println("Saved");
    }
    public void restoreOrReadData() {
        try {
            FileInputStream fileIn = new FileInputStream("SavedBooks");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Books.setAllBooks((ArrayList<Books>)in.readObject());
            in.close();
            fileIn.close();
        } catch (Exception exception) {
            Books.readData();

        }

        ArrayList<Books> temporaryList = (ArrayList<Books>) Books.getAllBooks();
        ObservableList temporaryObservableList = FXCollections.observableArrayList(temporaryList);
        infoList.setItems(temporaryObservableList);
    }
}

