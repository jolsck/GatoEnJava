
package lopez_sanchez_jorge_de_jesus_pf1;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class Gato {
    public static void main(String[] args) {
         VentanaGato vg = new  VentanaGato();
        
        vg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        centrarVentana(vg, "Juego del Gato", 500, 500);
        
        vg.setVisible(true);
        vg.setResizable(false);
        
        
    } //Fin del Main
   
    
    /**
     * Método para centrar la ventana
     */
    public static void centrarVentana(JFrame ventana, String titulo, 
            int anchoVentana, int altoVentana) {
        
        Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        double anchoPantalla = tamPantalla.getWidth();
        double altoPantalla = tamPantalla.getHeight();
        
        int posXVentana = ((int)anchoPantalla - anchoVentana) / 2;
        int posYVentana = ((int)altoPantalla - altoVentana) / 2;
        
        ventana.setBounds(posXVentana, posYVentana, anchoVentana, altoVentana);
        ventana.setTitle(titulo);
        
    } // Fin de centrarVentana
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
