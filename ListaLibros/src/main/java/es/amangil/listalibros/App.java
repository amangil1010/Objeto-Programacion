package es.amangil.listalibros;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        var scene = new Scene(new StackPane(), 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Libro libro1 = new Libro("Ficheros en Java");
        System.out.println(libro1.getTitulo());
        libro1.setTitulo("Listas en Java");
        System.out.println(libro1.getTitulo());
        
        Libro libro2 = new Libro();
        
        Libro libro3 = new Libro("XML en Java");
        libro3.setTitulo("XML en Java 2");
        
        ArrayList<Libro> listaLibros = new ArrayList();
        listaLibros.add(libro1);
        listaLibros.add(libro2);
        listaLibros.add(libro3);
        
        // Mostrar el titulo del tercer libro
        System.out.println(listaLibros.get(2).getTitulo());
        
        //Eliminar segundo libro
        listaLibros.remove(1);
        
        //Mostrar todos los titulos de libros que estan en la lista
        for (int x=0; x<listaLibros.size(); x++){
            System.out.println(listaLibros.get(x).getTitulo());
        }
        //
        System.out.println("-----------------------------------");
        //
        for (int x=0; x<listaLibros.size(); x++){
            System.out.println(listaLibros.get(x));
        }
        
    }

    public static void main(String[] args) {
        launch();
    }

}