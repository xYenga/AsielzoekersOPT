module com.example.asielzoekersopt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.asielzoekersopt to javafx.fxml;
    exports com.example.asielzoekersopt;
}