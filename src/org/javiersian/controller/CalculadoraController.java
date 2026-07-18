
package org.javiersian.controller;

import javafx.scene.control.Label;

public class CalculadoraController {
    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = false;
    
    public CalculadoraController(){
        
    }
    
    public void procesoDeEntrada(String entrada, Label pantalla){
        if (entrada.equals("C")) {
            opcion1 = "";
            operador = "";
            opcion2 = "";
            pantalla.setText("");
        }
        //si ya se completo uncalculo// reiniciar
        if (calculoTerminado && entrada.matches("[0-9]")){
            opcion1 = "";
            operador = "";
            opcion2 = "";
        }
        calculoTerminado = false;
        
        if(entrada.matches("[0-9]")) {
            if(operador.isEmpty()){
                opcion1 += entrada;
            }else{
                opcion2 += entrada;
            } 
            actualizarPantalla(pantalla);
        }else if (entrada.equals("+")){
            operador = entrada;
            actualizarPantalla(pantalla);
        }else if (entrada.equals("=")){
            if(operador.equals("+")){
                opcion1 = resultadoSuma(opcion1, opcion2);
                operador = "";
                opcion2 = "";
                calculoTerminado = true; 
            }
            actualizarPantalla(pantalla);
        }
         
        if(entrada.matches(" ")) {
            if(operador.isEmpty()){
                opcion1 += entrada;
            }else{
                opcion2 += entrada;
            } 
            actualizarPantalla(pantalla);
        } else if (entrada.equals("-")) {
            operador = entrada;
            actualizarPantalla(pantalla);
        } else if (entrada.equals("=")) {
            if (operador.equals("-")) {
                opcion1 = resultadoResta(opcion1, opcion2);
                operador = "";
                opcion2 = "";
                calculoTerminado = true;
            }
            actualizarPantalla(pantalla);
        }
        
        if(entrada.matches(" ")) {
            if(operador.isEmpty()){
                opcion1 += entrada;
            }else{
                opcion2 += entrada;
            } 
            actualizarPantalla(pantalla);
        } else if (entrada.equals("x")) {
            operador = entrada;
            actualizarPantalla(pantalla);
        } else if (entrada.equals("=")) {
            if (operador.equals("x")) {
                opcion1 = resultadoMultiplicacion(opcion1, opcion2);
                operador = "";
                opcion2 = "";
                calculoTerminado = true;
            }
            actualizarPantalla(pantalla);
        }      
        
        if (entrada.matches(" ")) {
            if (operador.isEmpty()) {
                opcion1 += entrada;
            } else {
                opcion2 += entrada;
            }
            actualizarPantalla(pantalla);
        } else if (entrada.equals("÷")) {
            operador = entrada;
            actualizarPantalla(pantalla);
        } else if (entrada.equals("=")) {
            if (operador.equals("÷")) {
                opcion1 = resultadoDivision(opcion1, opcion2);
                operador = "";
                opcion2 = "";
                calculoTerminado = true;
            }
            actualizarPantalla(pantalla);
        }
        
        else if (entrada.equals(".")) {
            if (operador.isEmpty()) {
                if (!opcion1.contains(".")) {
                    opcion1 += entrada;
                }
            } else {
                if (!opcion2.contains(".")) {
                    opcion2 += entrada;
                }
            }
            actualizarPantalla(pantalla);
        }

        if (entrada.matches(" ")) {
            if (operador.isEmpty()) {
                opcion1 += entrada;
            } else {
                opcion2 += entrada;
            }
            actualizarPantalla(pantalla);
    
        } else if (entrada.equals("%")) {
            if (operador.isEmpty() && !opcion1.isEmpty()) {
                opcion1 = resultadoPorcentaje(opcion1);
            } else if (!opcion2.isEmpty()) {
                opcion2 = resultadoPorcentaje(opcion2);
            }
            actualizarPantalla(pantalla);
        }
        
        if (entrada.matches(" ")) {
            if (operador.isEmpty()) {
                opcion1 += entrada;
            } else {
                opcion2 += entrada;
            }
            actualizarPantalla(pantalla);
        } else if (entrada.equals("√")) {
            if (operador.isEmpty() && !opcion1.isEmpty()) {
                opcion1 = resultadoRaiz(opcion1);
            } else if (!opcion2.isEmpty()) {
                opcion2 = resultadoRaiz(opcion2);
            }
            actualizarPantalla(pantalla);
        }
        
        if (entrada.matches(" ")) {
            if (operador.isEmpty()) {
                opcion1 += entrada;
            } else {
                opcion2 += entrada;
            }
            actualizarPantalla(pantalla);
        } else if (entrada.equals("x²")) {
            if (operador.isEmpty() && !opcion1.isEmpty()) {
                opcion1 = resultadoPotencia(opcion1);
            } else if (!opcion2.isEmpty()) {
                opcion2 = resultadoPotencia(opcion2);
            }
            actualizarPantalla(pantalla);
        }
        
    }
   
    private void actualizarPantalla(Label pantalla){
        if(operador.isEmpty()){
            pantalla.setText(opcion1);
        }else{
            pantalla.setText(opcion1 + " " + operador + " " + opcion2 );
        }
    }
    
    private String resultadoSuma(String numeroUno, String numeroDos){
        String resultado;
        double datoUno = Double.parseDouble(opcion1);
        double datoDos = Double.parseDouble(opcion2);
        double suma = datoUno+datoDos;
        
        return resultado = String.valueOf(suma);
    }
    
 
    private String resultadoResta(String numeroUno, String numeroDos) {
        String resultado;
        double datoUno = Double.parseDouble(opcion1);
        double datoDos = Double.parseDouble(opcion2);
        double resta = datoUno - datoDos;

        return resultado = String.valueOf(resta);
    }
    
    private String resultadoMultiplicacion(String numeroUno, String numeroDos){
       String resultado;
       double datoUno = Double.parseDouble(opcion1);
       double datoDos = Double.parseDouble(opcion2);
       double multiplicacion = datoUno * datoDos;

       return resultado = String.valueOf(multiplicacion); 
    }
    
    private String resultadoDivision(String numeroUno, String numeroDos) {
        String resultado; 
        double datoUno = Double.parseDouble(numeroUno); 
        double datoDos = Double.parseDouble(numeroDos);
        if (datoDos == 0) {
            return "Error";
        }
        double division = datoUno / datoDos;         
        return resultado = String.valueOf(division);
    }
     
    private String resultadoPorcentaje(String numero){
        double dato = Double.parseDouble(numero);
        return String.valueOf(dato / 100);
    }
    private String resultadoRaiz(String numero) {
        double dato = Double.parseDouble(numero);
        return String.valueOf(Math.sqrt(dato));
    }
    
    private String resultadoPotencia(String numero) {
        double dato = Double.parseDouble(numero);
        return String.valueOf(Math.pow(dato, 2));
    }
}