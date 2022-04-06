package es.amangil.objetosjuegos;

import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Objetos {
    
    private ArrayList<Objeto> listaObjeto = new ArrayList();
    
    public ArrayList<Objeto> getListaObjeto(){
        return listaObjeto;
    }
    
    @XmlElement(name = "objeto")
    public void setListaObjeto( ArrayList<Objeto> listaObjeto){
        this.listaObjeto = listaObjeto;
    }
    
        public void fusionarLibros(Objetos librosNuevos){
        // this.getListaLibros() <- librosNuevos.getlistaLibros();
////        this.getListaLibros().add(librosNuevos);
////        this.getListaLibros().addAll(librosNuevos);
        this.getListaObjeto().addAll(listaObjeto);
        
    }
        
        public void noHayLibros(){
            if (listaObjeto.size() == 0){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Aviso");
                alert.setContentText("Error no existen Objetos que mostrar, debes importar un XML");
                ButtonType buttonTypeok = new ButtonType("OK");
                alert.getButtonTypes().setAll(buttonTypeok);
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
    

}
