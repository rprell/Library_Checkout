package com.example.library_checkout;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.ArrayList;

public class HelloController {

    public Pagination pagination;
    public ListView infoList;
    public DatePicker calendar;
    public ImageView bookImage;
    public Button checkOutButton;
    public Button checkInButton;
    int currentBook;

    public void initialize() throws FileNotFoundException {
        Books.readData();

        Image image1 = new Image(new FileInputStream(new File("BookCovers/200px-To_Kill_a_Mockingbird_(first_edition_cover).jpg")));
        Image image2 = new Image(new FileInputStream(new File("BookCovers/An_early_reprint_of_A_Message_to_Garcia_.jpg")));
        Image image3 = new Image(new FileInputStream(new File("BookCovers/AngelsAndDemons.jpg")));
        Image image4 = new Image(new FileInputStream(new File("BookCovers/Cosmos_book.jpg")));
        Image image5 = new Image(new FileInputStream(new File("BookCovers/Dollanganger01_FlowersInTheAttic.jpg")));
        Image image6 = new Image(new FileInputStream(new File("BookCovers/HungryCaterPillar.jpg")));
        Image image7 = new Image(new FileInputStream(new File("BookCovers/Johnathan_Livingston_Seagull.jpg")));
        Image image8 = new Image(new FileInputStream(new File("BookCovers/KaneAndAbel.jpg")));
        Image image9 = new Image(new FileInputStream(new File("BookCovers/Peter_Rabbit_first_edition_1902a.jpg")));
        Image image10 = new Image(new FileInputStream(new File("BookCovers/Sofies_verden.jpg")));


        Books.add(image1);
        bookImage.getImage().add("image1");
        Books.add(image2);
        bookImage.getImage().add("image2");
        Books.add(image3);
        bookImage.getImage().add("image3");
        Books.add(image4);
        bookImage.getImage().add("image4");

        currentBook = 1;
        bookImage.setImage(image1);
        choosePicture.getSelectionModel().select(currentBook);
    }

    //restoreOrReadData();

        //pagination.setPageFactory((pageIndex)-> {

      //  ImageView bookImage = new ImageView();

        //Label label1 = new Label("Content for page with index: " + pageIndex);

        //return new VBox(bookImage);
   // });

    public void nextButtonPressed() {
        if (currentBook < Books.size()-1) {
            currentBook = currentBook + 1;
        } else {
            currentBook = 0;
        }
        photoView.setImage(images.get(currentBook));
        choosePicture.getSelectionModel().select(currentBook);
        pictureNumberLabel.setText("Picture #" + (currentBook+1) + " of " + images.size());
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
     //       Books.readData();
     //   }

      //  ArrayList<BestSelling> temporaryList = (ArrayList<BestSelling>) Books.getAllBestSelling();
      //  ObservableList temporaryObservableList = FXCollections.observableArrayList(temporaryList);
      //  infoList.setItems(temporaryObservableList);
   // }
}

