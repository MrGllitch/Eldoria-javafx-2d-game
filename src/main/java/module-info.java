module eu.gltch.eldoria {
    requires javafx.controls;
    requires javafx.fxml;


    opens eu.gltch.eldoria to javafx.fxml;
    exports eu.gltch.eldoria;
    exports eu.gltch.eldoria.controllers;
    opens eu.gltch.eldoria.controllers to javafx.fxml;
}