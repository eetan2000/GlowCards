module com.example.glowcards {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.glowcards to javafx.fxml;
    exports com.example.glowcards;
    exports com.example.glowcards.view;
    opens com.example.glowcards.view to javafx.fxml;
    exports com.example.glowcards.control;
    opens com.example.glowcards.control to javafx.fxml;
}