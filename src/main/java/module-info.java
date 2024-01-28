module com.example.socialnetwork {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.socialnetwork to javafx.fxml;
    exports com.example.socialnetwork;
}