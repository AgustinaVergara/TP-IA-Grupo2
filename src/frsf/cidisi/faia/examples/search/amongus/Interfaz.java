package frsf.cidisi.faia.examples.search.amongus;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interfaz {
    static JFrame frame = new JFrame();
    static JButton exitButton = new JButton("Exit");
    
    static String source = "C:\\Users\\agust\\OneDrive\\Desktop\\Acciones\\";
    
    
	public static void imagen (String icono) throws InterruptedException {
		// Crea un objeto ImageIcon a partir del archivo de imagen
        ImageIcon icon = new ImageIcon(icono);

        // Crea un objeto JLabel con el ImageIcon
        JLabel label = new JLabel(icon);

        // Crea un objeto JFrame y agrega el JLabel

        frame.getContentPane().add(label);
        frame.setLocation(0,0);
        
        // Configura el JFrame
        frame.pack();
        frame.setVisible(true);
        Thread.sleep(1000);
        frame.getContentPane().remove(label);
        
	}
	public static void videoMatando (String icono) throws InterruptedException {

		// Crea un objeto ImageIcon a partir del archivo de imagen
        ImageIcon icon = new ImageIcon(icono);

        // Crea un objeto JLabel con el ImageIcon
        JLabel label = new JLabel(icon);

        // Crea un objeto JFrame y agrega el JLabel

        frame.getContentPane().add(label);
        frame.setLocation(0,0);
        // Configura el JFrame
        frame.pack();
        frame.setVisible(true);
        Thread.sleep(1550);
        frame.getContentPane().remove(label);
        
	}
	
	
	public static void matar () throws InterruptedException {
		//System.out.println("Matar a tripulante");
				videoMatando(source+"matando4.gif");
		
	}
	
	public static void moviendoA1 () throws InterruptedException {
		//System.out.println("Se mueve a Cafeteria");
				imagen(source+"cafeteria.jpg");
	}
	public static void moviendoA2 () throws InterruptedException {
		//System.out.println("Se mueve a Pasillo1");
				imagen(source+"pasillo1.jpg");
	}
	public static void moviendoA3 () throws InterruptedException {
		//System.out.println("Se mueve a Medbay");
				imagen(source+"medbay.jpg");
	}
	public static void moviendoA4 () throws InterruptedException {
		//System.out.println("Se mueve a UpperEngine");
				imagen(source+"upper.jpg");
	}
	public static void moviendoA5 () throws InterruptedException {
		//System.out.println("Se mueve a Pasillo2");
				imagen(source+"pasillo2.jpg");
	}
	public static void moviendoA6 () throws InterruptedException {
		//System.out.println("Se mueve a Reactor");
				imagen(source+"reactor.jpg");
	}
	public static void moviendoA7 () throws InterruptedException {
		//System.out.println("Se mueve a Security");
				imagen(source+"security.jpg");
	}
	public static void moviendoA8 () throws InterruptedException {
		//System.out.println("Se mueve a LowerEngine");
				imagen(source+"lower.jpg");
	}
	public static void moviendoA9 () throws InterruptedException {
		//System.out.println("Se mueve a Pasillo3");
				imagen(source+"pasillo3.jpg");
	}
	public static void moviendoA10 () throws InterruptedException {
		//System.out.println("Se mueve a Electrical");
				imagen(source+"electrical.jpg");
	}
	public static void moviendoA11 () throws InterruptedException {
		//System.out.println("Se mueve a Storage");
				imagen(source+"storage.jpg");
	}
	public static void moviendoA12 () throws InterruptedException {
		//System.out.println("Se mueve a Pasillo5");
				imagen(source+"pasillo5.jpg");
	}
	public static void moviendoA13 () throws InterruptedException {
		//System.out.println("Se mueve a Pasillo4");
				imagen(source+"pasillo4.jpg");
	}
	public static void moviendoA14 () throws InterruptedException {
		//System.out.println("Se mueve a Communication");
				imagen(source+"comunicaciones.jpg");
	}
	public static void moviendoA15 () throws InterruptedException {
		//System.out.println("Se mueve a Admin");
				imagen(source+"admin.jpg");
	}
	public static void moviendoA16 () throws InterruptedException {
		//System.out.println("Se mueve a Shield");
				imagen(source+"shield.jpg");
	}
	public static void moviendoA17 () throws InterruptedException {
		//System.out.println("Se mueve a Pasillo6");
				imagen(source+"pasillo6.jpg");
	}
	public static void moviendoA18 () throws InterruptedException {
		//System.out.println("Se mueve a Navigation");
				imagen(source+"navigation.jpg");
	}
	public static void moviendoA19 () throws InterruptedException {
		//System.out.println("Se mueve a O2");
				imagen(source+"o2.jpg");
	}
	public static void moviendoA20 () throws InterruptedException {
		//System.out.println("Se mueve a Weapons");
				imagen(source+"weapons.jpg");
	}
	public static void moviendoA21 () throws InterruptedException {
		//System.out.println("Se mueve a Pasillo7");
				imagen(source+"pasillo7.jpg");
	}
	public static void sabotear () throws InterruptedException {
		//System.out.println("Se sabotea una maquina");
				imagen(source+"sabotear.jpg");
	}
	public static void objetivoAlcanzado () throws InterruptedException {
		//System.out.println("Se alcanzó el objetivo");
				imagen(source+"objetivo.jpg");
	}
	
	
	

	public static void main(String[] args) throws Exception {	
    	FileReader archivo;
        BufferedReader lector;
        exitButton.addActionListener(e -> {
            System.exit(0); // Terminate the program with exit code 0 (success)
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(exitButton);
		imagen(source+"pruebaMapa2.jpg");
        try {
            archivo = new FileReader("logAcciones.txt");
            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;
                while ((cadena = lector.readLine()) != null) {
                    Interfaz obj = new Interfaz();
                    Method method = obj.getClass().getMethod(cadena);
                    method.invoke(obj);              
                }
            } else {
                System.out.println("El archivo no está listo para ser leído...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


