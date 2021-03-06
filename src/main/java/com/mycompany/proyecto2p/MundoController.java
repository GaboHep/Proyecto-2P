package com.mycompany.proyecto2p;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MundoController implements Initializable {
    
    @FXML
    private BorderPane borderPane;
    @FXML
    private Label lblTiempo;
    @FXML
    private Label lblPresupuesto;
    @FXML
    private Label lblNombreCiudad;
    @FXML
    private Label lblNombreAlcalde;
    @FXML
    private VBox vboxServicios;
    @FXML
    private ComboBox cbServicios;
    @FXML
    private ImageView vistaPrevia;
    @FXML
    private Label infoVistaPrevia;
    
    public Ciudad ciudad=Ciudad.ciudadUtilizada;
    private int mesesEnBancarrota=0;
    
    @Override

    public void initialize(URL url, ResourceBundle rb) {       
        Servicio.llenarServicios();
        Construccion.llenarConstrucciones();
        llenarTerreno( Configuracion.COLUMNAS, Configuracion.FILAS);
        cbServicios.getItems().addAll(Servicio.listaServicios);
        cbServicios.getItems().addAll(Construccion.Construcciones);
        
        lblNombreCiudad.setText(ciudad.getNombre());
        lblNombreAlcalde.setText(ciudad.getNombreAlcalde());
        
        Thread t=new Thread(new TiempoDinero());
        Thread t2=new Thread(new Fecha());
        Thread t3=new Thread(new CobroPago());
        
        
        t.start();
        t2.start();
        t3.start();
        
        
        
        
    }
    
    class Fecha implements Runnable{
        @Override
        public void run(){
            while(true){
                try{
                    Platform.runLater(() -> lblTiempo.setText(ciudad.fechaToString()));
                    ciudad.siguienteDia();
                    Thread.sleep(Configuracion.DURACION_DIA_SEGUNDOS * 1000);
                }catch(InterruptedException ex){
                    
                }
            }
        }
    }
    //Clase para controlar el presupuesto en tiempo real
    class TiempoDinero implements Runnable{
        @Override
        public void run(){
            while(true){
                try {
                Platform.runLater(()->lblPresupuesto.setText("Presupuesto: "+ciudad.getPresupuesto()));
                                
                Thread.sleep(10);   
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } 
    }
    }    
    class CobroPago implements Runnable{
        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(Configuracion.DURACION_MES_SEGUNDOS*1000);
                    double aPagar=0;
                    double aCobrar=0;
                    for (int x = 0; x < Configuracion.COLUMNAS; x++) {
                        for (int y = 0; y < Configuracion.FILAS; y++) {
                            if(ciudad.edificios2d[x][y]!=null){
                                if(ciudad.edificios2d[x][y] instanceof Servicio){
                                    Servicio s=(Servicio) ciudad.edificios2d[x][y];
                                    aPagar+=s.getPrecioMensual();
                                } else if(ciudad.edificios2d[x][y] instanceof Construccion){
                                    Construccion c= (Construccion) ciudad.edificios2d[x][y];
                                    aCobrar+=c.valorAPagar();      
                            } 
                           }
                            
                        }
                    }  
                    ciudad.disminuirPresupuesto(aPagar);
                    ciudad.aumentarPresupuesto(aCobrar);
                    
                    if(ciudad.getPresupuesto()<=0){
                        mesesEnBancarrota++;  
                    }
                    if(mesesEnBancarrota==Configuracion.MESES_QUIEBRA){
                        Alert a=new Alert(AlertType.INFORMATION);
                        a.setTitle("GAME OVER");
                        a.setContentText("Su ciudad cay?? en bancarrota");
                        Platform.exit();
                        System.exit(0); //Hago as?? porque no estoy realizando la sobreescritura.
                    }
                }catch(InterruptedException ex){
                    
                }
            }
        }
    }

    public void llenarTerreno(int Columnas, int Filas) {
              
        GridPane gridpane = new GridPane();
         
        
        if (Columnas > 0 && Filas > 0) {
            
            
            Image grassTile = new Image("/servicios/grassTile.png", 50, 50, true, true);
                       
            
            for (int x = 0; x < Columnas; x++) {
                for (int y = 0; y < Filas; y++) {
                    int coordX=x;
                    int coordY=y;
                    StackPane stack=new StackPane();
                    ImageView imgvw = new ImageView(grassTile);
                    
                    stack.setOnMouseClicked(t->construirServicios(stack,coordX,coordY));
                    stack.getChildren().add(imgvw);
                    gridpane.add(stack, x, y);
                }
            }
        }
        
        borderPane.setCenter(gridpane);
        borderPane.setAlignment(gridpane,Pos.CENTER);
       /* borderPane.maxHeight(Filas);
        borderPane.maxWidth(Columnas);*/
        
    }
    //M??todo de construcci??n de servicios del alcalde
    
    public void construirServicios(StackPane s,int x,int y){
        if(cbServicios.getValue()!=null){
           if(cbServicios.getValue() instanceof Servicio){
                Servicio ser=(Servicio)cbServicios.getValue();
                s.getChildren().add(new ImageView(new Image(ser.getRuta(),45,45,true,true)));
                ciudad.disminuirPresupuesto(ser.getPrecioConstruccion());
                //Agrego este servicio con su posici??n a un Array 2d que lo almacena
                ciudad.edificios2d[x][y]=ser;
                
            }else if(cbServicios.getValue()instanceof Construccion){
                Construccion cons=(Construccion) cbServicios.getValue();
                s.getChildren().add(new ImageView(new Image(cons.getRuta(),45,45,true,true)));
                ciudad.edificios2d[x][y]=cons;
            }
        }
            
        else{ //Por si se clickea en los paneles sin seleciconar construccion
                Alert a=new Alert(AlertType.INFORMATION);
                a.setTitle("Error");
                a.setContentText("No ha seleccionado una construcci??n");
                a.show();
            }

             
       
    }
    
    //Imagen de vista previa al construir un servicio
    public void vistaPrevia(){
        if(cbServicios.getValue() instanceof Servicio){
            Servicio s=(Servicio)cbServicios.getValue();
            Image imagen=new Image(s.getRuta());
            vistaPrevia.setImage(imagen);
            infoVistaPrevia.setText("Precio construccion: "+s.getPrecioConstruccion()+"\nPrecio Mantenimiento: "+s.getPrecioMensual());
        }else if(cbServicios.getValue() instanceof Construccion){
            Construccion c=(Construccion) cbServicios.getValue();
            Image imagen=new Image(c.getRuta());
            vistaPrevia.setImage(imagen);
            infoVistaPrevia.setText("Ingresos mensuales: "+c.valorAPagar());
        }
    }
    
    //Posible m??todo de deserializaci??n
    /*
    public void construccionesAleatorias(){
        for (int x = 0; x < Configuracion.COLUMNAS; x++) {
                for (int y = 0; y < Configuracion.FILAS; y++) {
                    if(ciudad.edificios2d[x][y]==null){
                        Random r=new Random();
                        List <Integer> lista=Arrays.asList(0,1,2,3,4,5);
                        int prob=lista.get(r.nextInt(lista.size()));
                        if(prob==1){
                            Construccion c=Construccion.Construcciones.get(r.nextInt(Construccion.Construcciones.size()));
                            ciudad.edificios2d[x][y]=c;
                            
                            gridpane.add(new ImageView(new Image(c.getRuta())),x,y);
                            
                                    
                        }
                        
                    }
                }
        
        
    }*/
       
}
    



