package com.example.library_checkout;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HelloController {

    public Pagination pagination;
    public ListView infoList;
    public DatePicker calendar;
    public ImageView bookImage;
    public Button checkOutButton;
    public Button checkInButton;

    public void initialize() {
        //restoreOrReadData();

    }

    public void saveData() throws Exception {
        FileOutputStream fileOut = new FileOutputStream("SavedBooks");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        // allTheTexts is my ListView. Save its ObservableList by turning it into an ArrayList.
        ArrayList<String> temporaryList = new ArrayList<>(infoList.getItems());
        out.writeObject(temporaryList);

        out.close();
        fileOut.close();
    }
  //  public void restoreOrReadData() {
   //     try {
   //         FileInputStream fileIn = new FileInputStream("SavedCandyObjects");
   //         ObjectInputStream in = new ObjectInputStream(fileIn);
    //        Books.setAllBestSelling((ArrayList<BestSelling>)in.readObject());
    //        in.close();
     //       fileIn.close();
    //    } catch (Exception exception) {
     //       Books.signOut();
     //   }

      //  ArrayList<BestSelling> temporaryList = (ArrayList<BestSelling>) Books.getAllBestSelling();
      //  ObservableList temporaryObservableList = FXCollections.observableArrayList(temporaryList);
      //  infoList.setItems(temporaryObservableList);
   // }
}

