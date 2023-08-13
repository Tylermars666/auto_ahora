module co.edu.uniquindio.auto_ahora {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens co.edu.uniquindio.auto_ahora to javafx.fxml;
    exports co.edu.uniquindio.auto_ahora;
    exports co.edu.uniquindio.auto_ahora.controller;
    opens co.edu.uniquindio.auto_ahora.controller to javafx.fxml;
}