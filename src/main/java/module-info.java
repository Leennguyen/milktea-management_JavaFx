module com.example.milkteamanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.milkteamanagement to javafx.fxml;
    opens com.example.milkteamanagement.data.models to javafx.base;
    exports com.example.milkteamanagement;
}