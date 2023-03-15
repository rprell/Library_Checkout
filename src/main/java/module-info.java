module com.example.library_checkout {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.library_checkout to javafx.fxml;
    exports com.example.library_checkout;
}