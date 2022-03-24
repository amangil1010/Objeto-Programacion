module es.amangil.objetosjuegos {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports es.amangil.objetosjuegos;
    opens es.amangil.objetosjuegos to java.xml.bind;
}
