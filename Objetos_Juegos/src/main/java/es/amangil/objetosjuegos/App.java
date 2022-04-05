package es.amangil.objetosjuegos;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
        
    @Override
    public void start(Stage stage) {
            
        StackPane root = new StackPane();
        //-----
        
        
        
        
        
        //-----
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Objeto objeto1 = new Objeto("Espada");
        objeto1.setNombre("Pistola");
        objeto1.setPropietario("JaviMG");
        objeto1.setCalidad("Alta");
        objeto1.setnumUnidades(1);
        objeto1.setPrecio(100);
        objeto1.setfecha("2022/02/12");
        System.out.println(objeto1.getNombre());
        System.out.println(objeto1.getPropietario());
        
        Objeto objeto2 = new Objeto("Arcos");
        objeto2.setNombre("Lanza");
        
        Objeto objeto3 = new Objeto("Arcos");
        
        listaObjetos.getListaObjeto().add(objeto1);
        listaObjetos.getListaObjeto().add(objeto2);
        listaObjetos.getListaObjeto().add(objeto3);
        System.out.println(listaObjetos.getListaObjeto().get(0));
        
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
        
        listaObjetos.getListaObjeto().get(objetoActual);

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
        
        TextArea textArea = new TextArea();

        
        Button buttonSiguiente = new Button("Siguiente");
        buttonSiguiente.setStyle("-fx-background-color: #ADD8E6;");
        buttonSiguiente.setMinHeight(40);
        buttonSiguiente.setMinWidth(100);
        buttonSiguiente.setMaxHeight(40);
        buttonSiguiente.setMaxWidth(100);
        buttonSiguiente.setOnAction((t) -> {
            objetoActual++;
            label.setText("Nombre: " + listaObjetos.getListaObjeto().get(objetoActual).getNombre());
//            label.setUnderline(true);
            labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(objetoActual).getPropietario());
            labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(objetoActual).getCalidad());
            labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(objetoActual).getnumUnidades());
            labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(objetoActual).getPrecio());
            labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(objetoActual).getfecha());
            
        });
        
        
        Button buttonAnterior = new Button("Anterior");
        buttonAnterior.setStyle("-fx-background-color: #ADD8E6;");
        buttonAnterior.setMinHeight(40);
        buttonAnterior.setMinWidth(100);
        buttonAnterior.setMaxHeight(40);
        buttonAnterior.setMaxWidth(100);
        buttonAnterior.setOnAction((t) -> {
            objetoActual--;
            label.setText("Nombre: " + listaObjetos.getListaObjeto().get(objetoActual).getNombre());
            labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(objetoActual).getPropietario());
            labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(objetoActual).getCalidad());
            labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(objetoActual).getnumUnidades());
            labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(objetoActual).getPrecio());
            labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(objetoActual).getfecha());
        });

        label.setText("Nombre: " + listaObjetos.getListaObjeto().get(objetoActual).getNombre());
        labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(objetoActual).getPropietario());
        labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(objetoActual).getCalidad());
        labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(objetoActual).getnumUnidades());
        labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(objetoActual).getPrecio());
        labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(objetoActual).getfecha());
        
        //----------------------------------------------------------------------
        VBox  VBox = new VBox();
        VBox.setAlignment(Pos.CENTER);
        VBox.setSpacing(20);
        VBox.setBorder(new Border(new BorderStroke(Color.valueOf("#ADD8E6"),
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            new BorderWidths(10))));
        root.getChildren().add(VBox);
        
        HBox  paneScores = new HBox();
        paneScores.setAlignment(Pos.TOP_CENTER);
        paneScores.getChildren().add(buttonSelecFile);        
        paneScores.getChildren().add(buttonImportFile);
        paneScores.setSpacing(100);
        VBox.getChildren().add(paneScores);
        
        VBox  VBox2 = new VBox();
        VBox2.setMinHeight(300);
        VBox2.setMinWidth(200);
        VBox2.setMaxHeight(300);
        VBox2.setMaxWidth(200);
        VBox2.setAlignment(Pos.CENTER);
        VBox2.setSpacing(20);
        VBox2.setBorder(new Border(new BorderStroke(Color.valueOf("#ADD8E6"),
            BorderStrokeStyle.DASHED,
            CornerRadii.EMPTY,
            new BorderWidths(5))));
        VBox2.getChildren().add(label);
        VBox2.getChildren().add(labe2); 
        VBox2.getChildren().add(labe3); 
        VBox2.getChildren().add(labe4);
        VBox2.getChildren().add(labe5);
        VBox2.getChildren().add(labe6); 
        VBox.getChildren().add(VBox2);
        
        HBox  paneHBox = new HBox();
        paneHBox.setSpacing(100);
        paneHBox.setAlignment(Pos.BOTTOM_CENTER);
        paneHBox.getChildren().add(buttonAnterior);
        paneHBox.getChildren().add(buttonSiguiente);
        VBox.getChildren().add(paneHBox);
        //-------------------------------------------
        
    }
        

    public static void main(String[] args) {
        launch();
    }

}