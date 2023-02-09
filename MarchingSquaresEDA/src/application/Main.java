package application;

import java.util.Random;
import java.util.ArrayList;
import javafx.application.Application;

import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
 
/**
 *
 * @author Matis
 */
public class Main extends Application{

    @Override
    public void start(Stage stage){
    	
        
       //Calculamos el numero de celdas
       int[][] celdas;
       final int separacion = 20;
       int cols = 600 / separacion + 1;
       int filas = 400 / separacion + 1;
       celdas = new int[cols][filas];
       Random ran = new Random();
       
       //Asignamos valores aleatorio de 0 o 1 a cada celda.
       for(int i = 0; i < cols; i++){
            for(int j = 0; j < filas; j++){
                celdas[i][j] = ran.nextInt(2);
            }
       }
       
       Group group = new Group();
       
       for(int i = 0; i < cols; i++){
            for(int j = 0; j < filas; j++){
            	switch(celdas[i][j]) {
            	case 1:
            		group.getChildren().add(new Circle(i*separacion, j*separacion, separacion*0.2, Color.BLUE));
            		break;
            	default:
            		group.getChildren().add(new Circle(i*separacion, j*separacion, separacion*0.2, Color.WHITE));
            		break;
            	}
            }
       }
       
       //Dibujamos los segmentos de cada cuadrícula
       for (int i = 0; i < cols - 1; i++){
           for (int j = 0; j < filas - 1; j++){
               Line line;
               double x = i * separacion;
               double y = j * separacion;
                ArrayList<Double> a =new ArrayList<Double>();
                a.add(x+separacion*0.5);
                a.add(y);
                ArrayList<Double> b =new ArrayList<Double>();
                b.add(x+separacion);
                b.add(y+separacion*0.5);
                ArrayList<Double> c =new ArrayList<Double>();
                c.add(x+separacion*0.5);
                c.add(y+separacion);
                ArrayList<Double> d =new ArrayList<Double>();
                d.add(x);
                d.add(y+separacion*0.5);
                
               int state = getState(celdas[i][j], celdas[i+1][j], celdas[i+1][j+1], celdas [i][j+1]); 
               switch (state) {
                  case 1:  
                    line = new Line(c.get(0),c.get(1),d.get(0),d.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);   
                    break;
                  case 2:  
                    line = new Line(b.get(0),b.get(1),c.get(0),c.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line); 
                    break;
                  case 3:  
                    line = new Line(d.get(0),d.get(1),b.get(0),b.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    break;
                  case 4:  
                    line = new Line(a.get(0),a.get(1),b.get(0),b.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    break;
                  case 5:  
                    line = new Line(a.get(0),a.get(1),d.get(0),d.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    line = new Line(b.get(0),b.get(1),c.get(0),c.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    break;
                  case 6:  
                    line = new Line(a.get(0),a.get(1),c.get(0),c.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    break;
                  case 7:  
                    line = new Line(a.get(0),a.get(1),d.get(0),d.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    break;
                  case 8:  
                    line = new Line(a.get(0),a.get(1),d.get(0),d.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    break;
                  case 9:  
                    line = new Line(a.get(0),a.get(1),c.get(0),c.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    break;
                  case 10: 
                    line = new Line(a.get(0),a.get(1),b.get(0),b.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    line = new Line(c.get(0),c.get(1),d.get(0),d.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    break;
                  case 11: 
                    line = new Line(a.get(0),a.get(1),b.get(0),b.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    break;
                  case 12: 
                    line = new Line(b.get(0),b.get(1),d.get(0),d.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    break;
                  case 13: 
                    line = new Line(b.get(0),b.get(1),c.get(0),c.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                    break;
                  case 14: 
                    line = new Line(c.get(0),c.get(1),d.get(0),d.get(1));
                    line.setStroke(Color.WHITE);
                    group.getChildren().add(line);
                     
                }
             
            }
        }
       
     //Ajustes de la ventana del programa...
       Scene scene = new Scene(group,600,400);
       scene.setFill(Color.GRAY);
       stage.setTitle("Marching Squares");
       stage.setScene(scene);
       stage.show();
       
    }
  
    private int getState(int a, int b, int c, int d) {
        return a * 8 + b * 4  + c * 2 + d * 1;
    }          
                      
   public static void main(String[] args) {
       //Iniciar la aplicación
       launch(args);
   }   
}