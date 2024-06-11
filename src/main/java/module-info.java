module com.example.asielzoekersopt {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.asielzoekersopt to javafx.fxml;
    exports com.example.asielzoekersopt;
    exports Model;
    opens Model to javafx.fxml;
}