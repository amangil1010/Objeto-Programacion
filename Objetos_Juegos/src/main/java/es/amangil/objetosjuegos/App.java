package es.amangil.objetosjuegos;

import java.io.File;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        var scene = new Scene(new StackPane(), 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Objeto objeto1 = new Objeto();
        
        Objeto objeto2 = new Objeto();
        
        Objeto objeto3 = new Objeto();
        
        ListaObjetos listaObjetos = new ListaObjetos();
        listaObjetos.getListaObjeto().add(objeto1);
        listaObjetos.getListaObjeto().add(objeto2);
        listaObjetos.getListaObjeto().add(objeto3);

        
        // Mostrar el titulo del tercer libro
        //System.out.println(listaObjeto.get(2).getTitulo());
        
        //Eliminar segundo libro
//        listaObjeto.remove(1);
        
        //Mostrar todos los titulos de libros que estan en la lista
        //for (int x=0; x<listaObjeto.size(); x++){
        //    System.out.println(listaObjeto.get(x).getTitulo());
        //}
        //
        //System.out.println("-----------------------------------");
        //
        //for (int x=0; x<listaObjeto.size(); x++){
        //    System.out.println(listaObjeto.get(x));
        //}
        
        JAXBContext contexto;
        try {
            File fileListaObjeto = new File("ListaObjetos.xml");
            contexto = JAXBContext.newInstance(listaObjetos.getClass);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            marshaller.marshal(listaObjetos, System.out);
            marshaller.marshal(listaObjetos, fileListaObjeto);
        } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            ex.printStackTrace();
        }
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}