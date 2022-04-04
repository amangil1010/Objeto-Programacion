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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class App extends Application {
    ////Variables
    int cambio = 0;
    int libroActual = 0;
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
        root.getChildren().add(buttonSelecFile);
        buttonSelecFile.setOnAction((t) -> {
            UtilXML.guardarDatosXML(stage, listaObjetos);
        }); 
        
        listaObjetos.getListaObjeto().get(libroActual);

        Button buttonImportFile = new Button("Import XML");
        root.getChildren().add(buttonImportFile);
        buttonImportFile.setOnAction((t) -> {
            Objetos librosImport = UtilXML.ImportDatosXML(stage);
            System.out.println("Numero de libros: ");
            System.out.println(librosImport.getListaObjeto().size());
            
            listaObjetos.fusionarLibros(librosImport);
        });
        
//        Label label = new Label();
//        Label labe2 = new Label();
//        Label labe3 = new Label();
//        Label labe4 = new Label();
//        Label labe5 = new Label();
//        Label labe6 = new Label();
        
        TextArea textArea = new TextArea();

        
        Button buttonSiguiente = new Button("Siguiente");
        buttonSiguiente.setOnAction((t) -> {
            libroActual++;
            label.setText("Nombre:" + listaObjetos.getListaObjeto().get(libroActual).getNombre());
            labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(libroActual).getPropietario());
            labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(libroActual).getCalidad());
            labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(libroActual).getnumUnidades());
            labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(libroActual).getPrecio());
            labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(libroActual).getfecha());
            
        });
        Button buttonAnterior = new Button("Anterior");
        buttonAnterior.setOnAction((t) -> {
            libroActual--;
            label.setText("Nombre:" + listaObjetos.getListaObjeto().get(libroActual).getNombre());
            labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(libroActual).getPropietario());
            labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(libroActual).getCalidad());
            labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(libroActual).getnumUnidades());
            labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(libroActual).getPrecio());
            labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(libroActual).getfecha());
        });

        label.setText("Nombre:" + listaObjetos.getListaObjeto().get(libroActual).getNombre());
            labe2.setText("Propietario: " + listaObjetos.getListaObjeto().get(libroActual).getPropietario());
            labe3.setText("Calidad: " + listaObjetos.getListaObjeto().get(libroActual).getCalidad());
            labe4.setText("Num Unidades: " + listaObjetos.getListaObjeto().get(libroActual).getnumUnidades());
            labe5.setText("Precio: " + listaObjetos.getListaObjeto().get(libroActual).getPrecio());
            labe6.setText("Fecha: " + listaObjetos.getListaObjeto().get(libroActual).getfecha());
        
        
        
        
        
        VBox  paneScores = new VBox();
        paneScores.setAlignment(Pos.CENTER);
        paneScores.getChildren().add(buttonSelecFile);        
        paneScores.getChildren().add(buttonImportFile);
        paneScores.setSpacing(20);
        root.getChildren().add(paneScores);
//        textArea.setText(listaObjetos.getListaObjeto().get(cambio));
////        textArea.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
//        BorderStrokeStyle.DASHED,
//        CornerRadii.EMPTY,
//        BorderWidths.DEFAULT)));
//        

        label.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
            BorderStrokeStyle.DASHED,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
        labe2.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
            BorderStrokeStyle.DASHED,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
        labe3.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
            BorderStrokeStyle.DASHED,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
        labe4.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
            BorderStrokeStyle.DASHED,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
        labe5.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
            BorderStrokeStyle.DASHED,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
        labe6.setBorder(new Border(new BorderStroke(Color.valueOf("#000000"),
            BorderStrokeStyle.DASHED,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));


//            textArea.setBackground(Background.BLACK);

        paneScores.getChildren().add(label);
        paneScores.getChildren().add(labe2);
        paneScores.getChildren().add(labe3);
        paneScores.getChildren().add(labe4);
        paneScores.getChildren().add(labe5);
        paneScores.getChildren().add(labe6);
        paneScores.getChildren().add(buttonSiguiente);
        paneScores.getChildren().add(buttonAnterior);
        
    }

    public static void main(String[] args) {
        launch();
    }

}