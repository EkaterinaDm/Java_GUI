package pr6;

import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

interface Min{
    void number(int min1, int min2, String name); 
} 
interface Min2{
    void number2(int min1, int min2, String name, Desktop desktop[], Laptop laptop[], Label lbl); 
} 
class MyStringOps {
//статический метод//
static void m2(int min1, int min2, String name, Desktop desktop[], Laptop laptop[], Label lbl){       
    if (desktop[min1].cost() < laptop[min2].cost()){
                            name = desktop[min1].name();
                            lbl.setText((min1+1) + " " + name + desktop[min1].put()); 
                        } else {
                            name = laptop[min2].name();
                            lbl.setText((min2+1) + " " + name + laptop[min2].put2());
                        }   
                    }
}

public class Pr6 extends Application {
    //ссылка на функциональный интерфейс и параметры//
    static void method(Min2 m2, int min1, int min2, String name, Desktop desktop[], Laptop laptop[], Label lbl) {
       m2.number2(min1, min2, name, desktop, laptop, lbl); 
    }
    public void start(Stage stage) throws Exception {
        Label d = new Label("Введите количество настольных компьютеров: ");
        Label l = new Label("Введите количество ноутбуков: ");
        TextField textField1 = new TextField();
        textField1.setPrefColumnCount(11);
        TextField textField2 = new TextField();
        textField2.setPrefColumnCount(11);
        Button btn = new Button("Click");
        Label lbl = new Label();
        
        RadioButton rbtn1 = new RadioButton("Лямбда-выражение");
        RadioButton rbtn2 = new RadioButton("Ссылка на метод");
        ToggleGroup group = new ToggleGroup();
         
        rbtn1.setToggleGroup(group);
        rbtn2.setToggleGroup(group);
        btn.setOnAction((ActionEvent event) -> {
            int cost;
            int n1 = Integer.parseInt(textField1.getText());
            int n2 = Integer.parseInt(textField2.getText());
        Random rand = new Random();
        Desktop [] desktop = new Desktop[n1]; //создание массива объектов класса Desktop
        Laptop [] laptop = new Laptop[n2]; //создание массива объектов класса Laptop
        //заполнение массивов//
        for (int i=0; i<n1; i++){
            cost = rand.nextInt(200000);
            desktop[i] = new Desktop(cost);
        }
        for (int i=0; i<n2; i++){
            cost = rand.nextInt(200000);
            laptop[i] = new Laptop(cost);
        }
        System.out.print("Настольные компьютеры:\n");
                    for (int i=0; i<n1; i++){
                        System.out.print((i+1) + " " + desktop[i].name() + " - " + desk-top[i].cost() + " руб.\n" );    
                    }
        System.out.print("Ноутбуки:\n");
            for (int i=0; i<n2; i++){
                System.out.print((i+1) + " " + laptop[i].name() + " - " + laptop[i].cost() + " руб.\n" );    
            } 
        
        
        RadioButton selection = (RadioButton) group.getSelectedToggle();
            if ("Лямбда-выражение".equals(selection.getText())){
                Min m = (min1, min2, name)-> {
                        for (int i=0; i<n1; i++){
                            if (desktop[i].cost() < desktop[min1].cost()){
                                min1 = i; 
                            }
                        }   
                        for (int i=0; i<n2; i++){
                            if (laptop[i].cost() < laptop[min2].cost()){
                                min2 = i;  
                            }
                        }        
                        if (desktop[min1].cost() < laptop[min2].cost()){
                            name = desktop[min1].name();
                            lbl.setText((min1+1) + " " + name + desktop[min1].put());
                        } else {
                            name = laptop[min2].name();
                            lbl.setText((min2+1) + " " + name + laptop[min2].put2());
                        }   
                    };
                    m.number (0, 0, "компьютер");
            } else {
                int min1 = 0;
                    int min2 = 0;
                    String name = "компьютер";
                    for (int i=0; i<n1; i++){
                        if (desktop[i].cost() < desktop[min1].cost()){
                            min1 = i; 
                        }
                    }   
                    for (int i=0; i<n2; i++){
                        if (laptop[i].cost() < laptop[min2].cost()){
                            min2 = i;  
                        }
                    }
                    //передача ссылки методу method()//
                    method(MyStringOps :: m2, min1, min2, name, desktop, laptop, lbl);
            
            }
        });
        
        FlowPane root = new FlowPane(Orientation.VERTICAL, 0, 10);
        root.setAlignment(Pos.BASELINE_CENTER);
        root.getChildren().addAll(d,  textField1, l, textField2);
        root.getChildren().addAll(rbtn1, rbtn2, btn, lbl);
        
        root.setPadding(new Insets(0, 0, 0, 10));
        Scene scene = new Scene(root, 400, 300);
          
        stage.setScene(scene); 
        stage.setTitle("Практическая работа №6");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
	Класс Computer:
package pr6;
class Computer{
    String text = "cамый дешевый компьютер";
}
