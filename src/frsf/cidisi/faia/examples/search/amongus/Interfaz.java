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
    
    static String source = "C:\\Users\\agust\\OneDrive\\Desktop\\amongUs\\";
    
    
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
        Thread.sleep(100);
        frame.getContentPane().remove(label);
        
	}
	public static void imagenMasLenta (String icono) throws InterruptedException {

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
	public static void imagenMasRapida (String icono) throws InterruptedException {

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
        Thread.sleep(200);
        frame.getContentPane().remove(label);
        
	}
	
	public static void matar () throws InterruptedException {
		System.out.println("entra a matar");
		for(int j=0;j<=20;j++) {
			if(j%2==0) {
				imagen(source+"mover2.jpg");
			} else {
				imagen(source+"mover1.jpg");
			}
		}
		
	}
	public static void de0a1 () throws InterruptedException {
		for(int i=3;i<=15;i++) {
			imagen(source+"1 ("+i+").png");
		}
		for(int i=2;i<=6;i++) {
			imagen(source+"2 ("+i+").png");
		}
	}
	
	public static void huyendo() throws InterruptedException{
		for(int i=1;i<=10;i++) {
			imagenMasLenta(source+"lucha1."+i+".png");
		}
		for(int i=1;i<=8;i++) {
			imagenMasLenta(source+"lucha1.perdio"+i+".png");
		}
	}
	public static void peleando() throws InterruptedException{
		for(int i=1;i<=10;i++) {
			imagenMasLenta(source+"lucha1."+i+".png");
		}
		for(int i=1;i<=6;i++) {
			imagenMasLenta(source+"lucha1.perdio"+i+".png");
		}
	}
	public static void algo() throws InterruptedException{
		for(int i=1;i<=16;i++) {
			imagenMasRapida(source+"algo"+i+".png");
		}
	}
	
    public static void main(String[] args) throws Exception {	
    	FileReader archivo;
        BufferedReader lector;
        exitButton.addActionListener(e -> {
            System.exit(0); // Terminate the program with exit code 0 (success)
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(exitButton);
        try {
            archivo = new FileReader("C:\\Users\\agust\\eclipse-workspace\\examples\\logAcciones.txt");
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


