module com.example.hellofromjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.hellofromjavafx to javafx.fxml;
    exports com.example.hellofromjavafx;
}