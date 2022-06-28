module com.example.java_project2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_project2 to javafx.fxml;
    exports com.example.java_project2;
}