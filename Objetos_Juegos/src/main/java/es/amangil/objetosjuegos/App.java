package es.amangil.objetosjuegos;

import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class App extends Application {
    ////Variables
    int cambio = 0;
    int objetoActual = 0;
    
    Objetos listaObjetos = new Objetos();
    
    Label label = new Label();
    Label labe2 = new Label();
    Label labe3 = new Label();
    Label labe4 = new Label();
    Label labe5 = new Label();
    Label labe6 = new Label();
    
//    Image icono = new Image(getClass().getResourceAsStream("/images/xml.png"));
//    ImageView iconoView = new ImageView(icono);
        
    @Override
    public void start(Stage stage) {
            
        StackPane root = new StackPane();
        var scene = new Scene(root, 640, 480);
        stage.setTitle("XML Objetos");
//        stage.getIcons().add(icono);
        stage.setScene(scene);
        stage.show();
        root.setStyle("-fx-background-color: #ffffff;");
        
        //------------------------------------
        Objeto objeto1 = new Objeto("Espada");
        objeto1.setNombre("Pistola");
        objeto1.setPropietario("JaviMG");
        objeto1.setCalidad("Alta");
        objeto1.setnumUnidades(1);
        objeto1.setPrecio(100);
        objeto1.setfecha("2022/02/12");
        System.out.println(objeto1.getNombre());
        System.out.println(objeto1.getPropietario());
        //---------------------------------------
        Objeto objeto2 = new Objeto("Arcos");
        objeto2.setNombre("Francotirador");
        objeto2.setPropietario("Gavi");
        objeto2.setCalidad("Alta");
        objeto2.setnumUnidades(1);
        objeto2.setPrecio(1000);
        objeto2.setfecha("2022/01/10");
        //------------------------------------------
        Objeto objeto3 = new Objeto("Arcos");
        objeto3.setNombre("Espada");
        objeto3.setPropietario("Juan");
        objeto3.setCalidad("baja");
        objeto3.setnumUnidades(500);
        objeto3.setPrecio(10);
        objeto3.setfecha("2021/02/12");
        //--------------------------------------------
        listaObjetos.getListaObjeto().add(objeto1);
        listaObjetos.getListaObjeto().add(objeto2);
        listaObjetos.getListaObjeto().add(objeto3);
////////////        System.out.println(listaObjetos.getListaObjeto().get(0));
        
        //------------------------------------------------------------
        Button buttonSelecFile = new Button("Guardar XML");
        buttonSelecFile.setStyle("-fx-background-color: #ADD8E6;");
        buttonSelecFile.setMinHeight(40);
        buttonSelecFile.setMinWidth(100);
        buttonSelecFile.setMaxHeight(40);
        buttonSelecFile.setMaxWidth(100);
        root.getChildren().add(buttonSelecFile);
        buttonSelecFile.setOnAction((t) -> {
        UtilXML.guardarDatosXML(stage, listaObjetos);
        }); 
        
//////////        listaObjetos.getListaObjeto().get(objetoActual);
        //-------------------------------------------------------------
        Button buttonImportFile = new Button("Import XML");
        buttonImportFile.setStyle("-fx-background-color: #ADD8E6;");
        buttonImportFile.setMinHeight(40);
        buttonImportFile.setMinWidth(100);
        buttonImportFile.setMaxHeight(40);
        buttonImportFile.setMaxWidth(100);
        root.getChildren().add(buttonImportFile);
        buttonImportFile.setOnAction((t) -> {
            Objetos librosImport = UtilXML.ImportDatosXML(stage);
            System.out.println("Numero de libros: ");
            System.out.println(librosImport.getListaObjeto().size());
            listaObjetos.fusionarLibros(librosImport);
        });
        
        //-------------------------------------------------------------
        Button buttonSiguiente = new Button("Siguiente");
        buttonSiguiente.setStyle("-fx-background-color: #ADD8E6;");
        buttonSiguiente.setMinHeight(40);
        buttonSiguiente.setMinWidth(100);
        buttonSiguiente.setMaxHeight(40);
        buttonSiguiente.setMaxWidth(100);
        buttonSiguiente.setOnAction((t) -> {
        try {
            objetoActual++;
            label.setText("Nombre: " + listaObjetos.getListaObjeto().get(objetoActual).getNombre());
//            label.setUnderline(true);
            labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(objetoActual).getPropietario());
            labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(objetoActual).getCalidad());
            labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(objetoActual).getnumUnidades());
            labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(objetoActual).getPrecio());
            labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(objetoActual).getfecha());
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error, no existen mas XML para mostrar");
            alert.setContentText("Error, no existen mas XML para mostrar, a donde desea ir: ");
            ButtonType buttonTypeok = new ButtonType("Inicio");
            ButtonType buttonTypeCancelar = new ButtonType("Final");
            ButtonType buttonTypeExit = new ButtonType("Salir");
            alert.getButtonTypes().setAll(buttonTypeok, buttonTypeCancelar,buttonTypeExit);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeok){
                objetoActual = 0;
                System.out.println("objetoActual" + objetoActual);
                label.setText("Nombre: " + listaObjetos.getListaObjeto().get(objetoActual).getNombre());
                labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(objetoActual).getPropietario());
                labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(objetoActual).getCalidad());
                labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(objetoActual).getnumUnidades());
                labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(objetoActual).getPrecio());
                labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(objetoActual).getfecha());
            } else if (result.get() == buttonTypeCancelar) {
                objetoActual = listaObjetos.getListaObjeto().size();
                System.out.println("objetoActual" + objetoActual);
                label.setText("Nombre: " + listaObjetos.getListaObjeto().get(objetoActual).getNombre());
                labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(objetoActual).getPropietario());
                labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(objetoActual).getCalidad());
                labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(objetoActual).getnumUnidades());
                labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(objetoActual).getPrecio());
                labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(objetoActual).getfecha());
            } else {
                    System.exit(0);
            }
        }
        });
        //------------------------------------------------------------
        Button buttonAnterior = new Button("Anterior");
        buttonAnterior.setStyle("-fx-background-color: #ADD8E6;");
        buttonAnterior.setMinHeight(40);
        buttonAnterior.setMinWidth(100);
        buttonAnterior.setMaxHeight(40);
        buttonAnterior.setMaxWidth(100);
        buttonAnterior.setOnAction((t) -> {
        try {
            objetoActual--;
            label.setText("Nombre: " + listaObjetos.getListaObjeto().get(objetoActual).getNombre());
            labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(objetoActual).getPropietario());
            labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(objetoActual).getCalidad());
            labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(objetoActual).getnumUnidades());
            labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(objetoActual).getPrecio());
            labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(objetoActual).getfecha());
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error, no existen mas XML para mostrar");
            alert.setContentText("Error, no existen mas XML para mostrar, a donde desea ir: ");
            ButtonType buttonTypeok = new ButtonType("Inicio");
            ButtonType buttonTypeCancelar = new ButtonType("Final");
            ButtonType buttonTypeExit = new ButtonType("Salir");
            alert.getButtonTypes().setAll(buttonTypeok, buttonTypeCancelar,buttonTypeExit);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeok){
                objetoActual = 0;
                System.out.println("objetoActual " + objetoActual);
                label.setText("Nombre: " + listaObjetos.getListaObjeto().get(objetoActual).getNombre());
                labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(objetoActual).getPropietario());
                labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(objetoActual).getCalidad());
                labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(objetoActual).getnumUnidades());
                labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(objetoActual).getPrecio());
                labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(objetoActual).getfecha());
            } else if (result.get() == buttonTypeCancelar) {
                objetoActual = listaObjetos.getListaObjeto().size() - 1;
                System.out.println("objetoActual " + objetoActual);
                label.setText("Nombre: " + listaObjetos.getListaObjeto().get(objetoActual).getNombre());
                labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(objetoActual).getPropietario());
                labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(objetoActual).getCalidad());
                labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(objetoActual).getnumUnidades());
                labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(objetoActual).getPrecio());
                labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(objetoActual).getfecha());
            } else {
                System.exit(0);
            }
        }
        });

        label.setText("Nombre: " + listaObjetos.getListaObjeto().get(objetoActual).getNombre());
        labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(objetoActual).getPropietario());
        labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(objetoActual).getCalidad());
        labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(objetoActual).getnumUnidades());
        labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(objetoActual).getPrecio());
        labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(objetoActual).getfecha());
        
        //----------------------------------------------------------------------
        VBox vboxPrincipal = new VBox();
        vboxPrincipal.setAlignment(Pos.CENTER);
        vboxPrincipal.setSpacing(20);
        vboxPrincipal.setBorder(new Border(new BorderStroke(Color.valueOf("#ADD8E6"),
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            new BorderWidths(10))));
        root.getChildren().add(vboxPrincipal);
        //------------------------------------------------------------------------
        HBox  botonesSuperiores = new HBox();
        botonesSuperiores.setAlignment(Pos.TOP_CENTER);
        botonesSuperiores.getChildren().add(buttonSelecFile);        
        botonesSuperiores.getChildren().add(buttonImportFile);
        botonesSuperiores.setSpacing(100);
        vboxPrincipal.getChildren().add(botonesSuperiores);
        //----------------------------------------------------------------------
        VBox  vboxLabel = new VBox();
        vboxLabel.setMinHeight(300);
        vboxLabel.setMinWidth(200);
        vboxLabel.setMaxHeight(300);
        vboxLabel.setMaxWidth(200);
        vboxLabel.setAlignment(Pos.CENTER);
        vboxLabel.setSpacing(20);
        vboxLabel.setBorder(new Border(new BorderStroke(Color.valueOf("#ADD8E6"),
            BorderStrokeStyle.DASHED,
            CornerRadii.EMPTY,
            new BorderWidths(5))));
        vboxLabel.getChildren().add(label);
        vboxLabel.getChildren().add(labe2); 
        vboxLabel.getChildren().add(labe3); 
        vboxLabel.getChildren().add(labe4);
        vboxLabel.getChildren().add(labe5);
        vboxLabel.getChildren().add(labe6); 
        vboxPrincipal.getChildren().add(vboxLabel);
        //--------------------------------------------
        HBox  botonesInferiores = new HBox();
        botonesInferiores.setSpacing(100);
        botonesInferiores.setAlignment(Pos.BOTTOM_CENTER);
        botonesInferiores.getChildren().add(buttonAnterior);
        botonesInferiores.getChildren().add(buttonSiguiente);
        vboxPrincipal.getChildren().add(botonesInferiores);
        //-------------------------------------------
        listaObjetos.noHayLibros();
    }
        

    public static void main(String[] args) {
        launch();
    }

}