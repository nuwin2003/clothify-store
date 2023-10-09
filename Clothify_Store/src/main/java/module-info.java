module com.example.clothify_store {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.clothify_store to javafx.fxml;
    exports com.example.clothify_store;
}