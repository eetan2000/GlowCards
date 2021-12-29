module com.example.glowcards {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.glowcards to javafx.fxml;
    exports com.example.glowcards;
    exports com.example.glowcards.view;
    opens com.example.glowcards.view to javafx.fxml;
}