/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;


import view.formularioAutomatico;
import view.formularioBusqueda;
import view.formularioIngreso;
import view.formularioSalida;
import view.formularioMenu;

public class principal {
    
    static formularioIngreso operaciones = new formularioIngreso();
    static formularioBusqueda busqueda = new formularioBusqueda();
    static formularioSalida salida = new formularioSalida();
    static formularioAutomatico automatico = new formularioAutomatico();
    static formularioMenu menu = new formularioMenu();
    public static void main(String args[]) {
    //principal op = new principal();
    
    menu.setVisible(true);
    
    }
    public static void formularioIngreso(){
        operaciones.setVisible(true);
    }
    public static void formularioBusqueda(){
        busqueda.setVisible(true);
    }
    public static void formularioSalida(){
        salida.setVisible(true);
    }
    public static void formularioAutomatico(){
        automatico.setVisible(true);
    }
    public static void formularioBusquedaDesa(){
        busqueda.setVisible(false);
    }
    public static void formularioSalidaDesa(){
        salida.setVisible(false);
    }
    public static void formularioAutomaticoDesa(){
        automatico.setVisible(false);
    }
    
   
}

    
    

