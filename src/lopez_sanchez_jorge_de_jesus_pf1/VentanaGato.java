
package lopez_sanchez_jorge_de_jesus_pf1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class VentanaGato extends JFrame implements ActionListener {
    //Campos
    JButton iniciar; // Usuario podrá dar click
    JButton tablero [][]; //Realizar una matriz de botones
    String jugador1, jugador2; // Jugadores
    int turno= -1; // Campo para saber a quien le corresponde
    JLabel mensaje; // Campo para mensaje al usuario para el turno
    Color colorB;  // Campo para el color de los botones 

   
//Constructor
public VentanaGato() {
  this.setLayout(null); 
    mensaje = new JLabel("Bienvenido al Juego del Gato");
    mensaje.setBounds(150,40,200,30);
    this.add(mensaje);
    iniciar = new JButton("Iniciar Juego");
    iniciar.setBounds(175,350,150,30);
    iniciar.addActionListener(this);
    this.add(iniciar);
    
    tablero = new JButton[3][3];
    for (int i = 0; i < tablero.length; i++){
        for (int j=0; j < tablero.length; j++){
            tablero[i][j] = new JButton();
            tablero[i][j].setBounds((i+1)*80+50,(j+1)*80,80,80);
            this.add(tablero[i][j]);
            tablero[i][j].addActionListener(this);
        }
    }
    colorB = tablero[0][0].getBackground();

    
    
} // FIN DEL CONSTRUCTOR 

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==iniciar){
           turno= 0;
           JOptionPane.showMessageDialog(this, "El Juego esta iniciando");
           jugador1= JOptionPane.showInputDialog(this,"Escribe el nombre del Jugador 1");
           jugador2= JOptionPane.showInputDialog(this,"Escribe el nombre del Jugador 2");
           mensaje.setText(" Turno del Jugador " + jugador1);
           Limpiar();
    }else{
    JButton boton = (JButton) ae.getSource();
    if(turno == 0){
        if(boton.getText().equals("")){
            boton.setBackground(Color.white);
            boton.setText("X");
            boton.setEnabled(false);
            turno = 1;
            mensaje.setText("Turno del Jugador " + jugador2);
           }
    }else{
     if(turno == 1){
        if(boton.getText().equals("")){
            boton.setBackground(Color.black);
            boton.setText("O");
            boton.setEnabled(false);
            turno = 0;
            mensaje.setText("Turno del Jugador " + jugador1);
          }   
       } 
     }
    Verificar();
  }
}
    
    
public void Verificar(){
    int ganador = 0;
    for(int i=0; i < tablero.length; i++ ){
        if(tablero[0][i].getText().equals("X")&& tablero[1][i].getText().equals("X")
            && tablero[2][i].getText().equals("X")){
        ganador = 1;
        }
        if(tablero[i][0].getText().equals("X")&& tablero[i][1].getText().equals("X")
            && tablero[i][2].getText().equals("X")){
        ganador = 1;
        }
        if(tablero[0][0].getText().equals("X")&& tablero[1][1].getText().equals("X")
            && tablero[2][2].getText().equals("X")){
        ganador = 1;    
        }
        if(tablero[0][2].getText().equals("X")&& tablero[1][1].getText().equals("X")
            && tablero[2][0].getText().equals("X")){
        ganador = 1;    
        }
   } //FIN FOR JUGADOR 1
    
for(int i=0; i <tablero.length; i++ ){
    if(tablero[0][i].getText().equals("O")&& tablero[1][i].getText().equals("O")
            && tablero[2][i].getText().equals("O")){
        ganador = 2;
        }
    if(tablero[i][0].getText().equals("O")&& tablero[i][1].getText().equals("O")
            && tablero[i][2].getText().equals("O")){
        ganador = 2;
        }
    if(tablero[0][0].getText().equals("O")&& tablero[1][1].getText().equals("O")
            && tablero[2][2].getText().equals("O")){
        ganador = 2;    
    }
    if(tablero[0][2].getText().equals("O")&& tablero[1][1].getText().equals("O")
            && tablero[2][0].getText().equals("O")){
        ganador = 2;    
    }
    
    } // FIN FOR 

        if(ganador==1){
        JOptionPane.showMessageDialog(this, " Feliciades Jugador: " + jugador1 + " ¡GANASTE! ");
        Bloquear();
    }
    if(ganador==2){
        JOptionPane.showMessageDialog(this, " Feliciades Jugador: " + jugador2 + " ¡GANASTE! ");
        Bloquear();
    }
    
    
} // FIN METODO VERIFICAR   



    
 public void Limpiar(){
     for (int i = 0; i < tablero.length; i++){
        for (int j=0; j < tablero.length; j++){
        tablero[i][j].setEnabled(true);
        tablero[i][j].setText("");
        tablero[i][j].setBackground(colorB);
        }      
     }
 }   
 
  /*
 Metodo para Bloquear el tablero
 */
 public void Bloquear(){
     for (int i = 0; i < tablero.length; i++){
        for (int j=0; j < tablero.length; j++){
        tablero[i][j].setEnabled(true);
        tablero[i][j].setText("");
        tablero[i][j].setBackground(colorB);
        }      
     }
 }   
       
    
} //FIN DEL PROGRAMA


