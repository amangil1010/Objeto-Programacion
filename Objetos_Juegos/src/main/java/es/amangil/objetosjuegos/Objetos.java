package es.amangil.objetosjuegos;

import java.util.ArrayList;
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
    

}
