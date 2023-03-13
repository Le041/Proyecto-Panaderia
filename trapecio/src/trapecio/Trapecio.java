/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trapecio;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class Trapecio {

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel resultadoLabel = new JLabel("Resultado");
        resultadoLabel.setBounds(10, 180, 80, 25);
        panel.add(resultadoLabel);

        JTextArea resultadoText = new JTextArea();
        resultadoText.setBounds(80, 180, 120, 200);
//        resultadoText.setLineWrap(true);
        panel.add(resultadoText);

        JLabel userLabelA = new JLabel("Ingresar la altura del trapecio: ");
        userLabelA.setBounds(25, 10, 250, 25);
        panel.add(userLabelA);

        JTextField numeroAText = new JTextField(20);
        numeroAText.setBounds(80, 40, 120, 25);
        panel.add(numeroAText);

        JLabel userLabelB = new JLabel("Ingresar el ancho del trapecio: ");
        userLabelB.setBounds(25, 65, 250, 25);
        panel.add(userLabelB);

        JTextField numeroBText = new JTextField(20);
        numeroBText.setBounds(80, 90, 120, 25);
        panel.add(numeroBText);

        JButton sendButton = new JButton("Generar");
        sendButton.setBounds(80, 140, 120, 25);
        panel.add(sendButton);
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int asteriscos = 1;
                int espacios = Integer.parseInt(numeroAText.getText()) - 1;
                int altura = Integer.parseInt(numeroAText.getText());
                int ancho = Integer.parseInt(numeroBText.getText());

                for (int fila = 0; fila < altura; fila++) {
                    for (int columna = 0; columna < espacios; columna++) {
                        resultadoText.append(" ");
                    }
                    for (int columnaAsteriscos = 0; columnaAsteriscos < ancho; columnaAsteriscos++) {
                        resultadoText.append("*");
                    }
                    resultadoText.append("\n");

                    asteriscos++;
                    espacios--;
                }

            }

        });

    }

    public static void main(String[] args) {

        int altura;
        int ancho;
        Scanner sc = new Scanner(System.in);

//        System.out.println("-------------------------- Trapecio Java ---------------------------");
//        System.out.println("\nPor favor Ingresar la altura del trapecio:");
//        altura = sc.nextInt();
//        System.out.println("\nPor favor Ingresar el ancho del trapecio:");
//        ancho = sc.nextInt();
//        dibujarTriangulo(altura, ancho);
        JFrame frame = new JFrame("Calculadora");
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height / 4;
        int width = pantalla.width / 4;
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    public static void dibujarTriangulo(int altura, int ancho) {
        int asteriscos = 1;
        int espacios = altura - 1;

        for (int fila = 0; fila < altura; fila++) {
            for (int columna = 0; columna < espacios; columna++) {
                System.out.print(" ");
            }
            for (int columnaAsteriscos = 0; columnaAsteriscos < ancho; columnaAsteriscos++) {
                System.out.print("*");
            }
            System.out.println();

            asteriscos++;
            espacios--;
        }
    }
}
