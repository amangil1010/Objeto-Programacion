package es.amangil.objetosjuegos;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaObjetos {
    
    private ArrayList<Objeto> listaObjeto = new ArrayList();
    
    public ArrayList<Objeto> getListaObjeto(){
        return listaObjeto;
    }
    
    public void setListaObjeto( ArrayList<Objeto> listaObjeto){
        this.listaObjeto = listaObjeto;
    }
}
