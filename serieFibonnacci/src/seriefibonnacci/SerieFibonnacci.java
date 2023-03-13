/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package seriefibonnacci;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class SerieFibonnacci extends JFrame {

    /**
     *
     * @author
     */
    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel resultadoLabel = new JLabel("Resultado");
        resultadoLabel.setBounds(10, 120, 80, 25);
        panel.add(resultadoLabel);

        JTextArea resultadoText = new JTextArea();
        resultadoText.setBounds(80, 120, 120, 200);
        resultadoText.setLineWrap(true);
        panel.add(resultadoText);

        JLabel userLabel = new JLabel("Ingresar el tamaño de la serie Fibonnacci:");
        userLabel.setBounds(25, 10, 250, 25);
        panel.add(userLabel);

        JTextField numeroAText = new JTextField(20);
        numeroAText.setBounds(80, 40, 120, 25);
        panel.add(numeroAText);

        JButton sendButton = new JButton("Generar");
        sendButton.setBounds(80, 80, 120, 25);
        panel.add(sendButton);
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String total = numeroAText.getText();
                int num1 = 0, num2 = 1, suma = 1;
                ArrayList<Integer> number = new ArrayList<Integer>();
                for (int i = 1; suma <= Integer.parseInt(total); i++) {
                    resultadoText.setText(number+"\n");
                    System.out.println(suma);
                    number.add(num1 + num2);
                    suma = num1 + num2;
                    num1 = num2;
                    num2 = suma;

                }
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Serie Fibonnacci");
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height / 4;
        int width = pantalla.width / 4;
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);

//        Scanner sc = new Scanner(System.in);
//
//        int num1 = 0, num2 = 1, suma = 1, total = 0;
//
//        //System.out.println(num1);
//        System.out.println("-------------------------- Serie Fibonnacci Java ---------------------------");
//        System.out.println("\nPor favor Ingresar el tamaño de la serie Fibonnacci:");
//        total = Integer.parseInt(sc.nextLine());
//
//        for (int i = 1; suma <= total; i++) {
//            System.out.println(suma);
//            suma = num1 + num2;
//            num1 = num2;
//            num2 = suma;
//        }
    }
}
