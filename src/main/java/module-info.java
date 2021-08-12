module com.mycompany.proyecto2p {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proyecto2p to javafx.fxml;
    exports com.mycompany.proyecto2p;
}
