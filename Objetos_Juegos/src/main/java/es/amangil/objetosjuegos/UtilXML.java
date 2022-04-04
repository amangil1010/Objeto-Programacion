package es.amangil.objetosjuegos;


import java.io.File;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML {
    
    public static void guardarDatosXML(Stage stage, Objetos listaobjetos) {
        JAXBContext contexto;
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar XML en");
            File fileListaLibros = fileChooser.showSaveDialog(stage);

            //File fileListaLibros = new File("ListaLibros.xml");
            contexto = JAXBContext.newInstance(Objetos.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(listaobjetos, System.out);
            marshaller.marshal(listaobjetos, fileListaLibros);
        } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            ex.printStackTrace();
        }            
    }
    
    public static Objetos ImportDatosXML(Stage stage) {
           try {
            
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Import XML en");
            File fileListaLibros = fileChooser.showOpenDialog(stage);
            
            JAXBContext context = JAXBContext.newInstance( Objetos.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            Objetos librosImport = new Objetos();
            librosImport = (Objetos)unmarshaller.unmarshal(fileListaLibros);
             
        return librosImport;
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El formarto del archivo XML no es correcto");
            alert.showAndWait();
        return null;           
    }
    
}

