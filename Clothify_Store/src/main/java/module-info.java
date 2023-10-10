module com.coursework.clothify_store {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfoenix;


    opens com.coursework.clothify_store to javafx.fxml;
    exports com.coursework.clothify_store;
}