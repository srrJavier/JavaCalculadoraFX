
package org.javiersian.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
public class CalculadoraView {
    private VBox view;
    private Label pantalla;
    private GridPane cuadroBotones;
 
    public CalculadoraView(){
        view = new VBox (15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: #25D6F5");
        pantalla = new Label ("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(235, 50);
        cuadroBotones = new GridPane(); 
        cuadroBotones.setHgap(12); 
        cuadroBotones.setVgap(12);
        cuadroBotones.setAlignment(Pos.CENTER);
 
        Button btnUno = crearBoton("1");
        Button btnDos = crearBoton("2");
        Button btnTres = crearBoton("3");
        Button btnCuatro = crearBoton("4");
        Button btnCinco = crearBoton("5");
        Button btnSeis = crearBoton("6");
        Button btnSiete = crearBoton("7");
        Button btnOcho = crearBoton("8");
        Button btnNueve = crearBoton("9");
        Button btnCero = crearBoton("0");
        Button btnSuma = crearBoton("+");
        Button btnResta = crearBoton("-");
        Button btnMultiplicacion = crearBoton("x");
        Button btnDividir = crearBoton("÷");
        Button btnRaiz = crearBoton("√");
        Button btnPotencia = crearBoton("x²");
        Button btnPunto = crearBoton(".");
        Button btnIgual = crearBoton("=");
        Button btnClear = crearBoton("C");
        cuadroBotones.add(btnUno, 0, 4);
        cuadroBotones.add(btnDos, 1, 4);
        cuadroBotones.add(btnTres, 2, 4);
        cuadroBotones.add(btnCuatro, 0, 3);
        cuadroBotones.add(btnCinco, 1, 3);
        cuadroBotones.add(btnSeis, 2, 3);
        cuadroBotones.add(btnSiete, 0, 2);
        cuadroBotones.add(btnOcho, 1, 2);
        cuadroBotones.add(btnNueve, 2, 2);
        cuadroBotones.add(btnCero, 1, 5);
        cuadroBotones.add(btnSuma, 3, 4);
        cuadroBotones.add(btnResta, 3, 3);
        cuadroBotones.add(btnMultiplicacion, 3, 2);
        cuadroBotones.add(btnPunto, 2, 5);
        cuadroBotones.add(btnIgual, 3, 5);
        cuadroBotones.add(btnClear, 0, 5);
 
 
        view.getChildren().addAll(pantalla, cuadroBotones); 
    }
 
    private Button crearBoton(String texto) {
        Button boton = new Button(texto);
        boton.setPrefSize(50, 50);
        boton.setStyle("-fx-background-color: #6B8E23; -fx-text-fill: white; -fx-background-radius: 5px; -fx-cursor: hand;");
        boton.setFont(Font.font("Consolas", FontWeight.NORMAL, 20));
        boton.setOnMousePressed(e -> {
            boton.setStyle("-fx-background-color: #388E3C; -fx-text-fill: white; -fx-background-radius: 5px; -fx-cursor: hand;");
            boton.setTranslateY(2);
        });
        boton.setOnMouseReleased(e -> {
            boton.setStyle("-fx-background-color: #6B8E23; -fx-text-fill: white; -fx-background-radius: 5px; -fx-cursor: hand;");
            boton.setTranslateY(0);
        });
        return boton;
    }
 
    public VBox getView() {
        return view; 
    }
    private Button nuevoBoton (String texto){
        Button btn = new Button(texto);
        //configurar tamaño
        // tamaño,estilo,sus funciones
        return btn;
    }
}