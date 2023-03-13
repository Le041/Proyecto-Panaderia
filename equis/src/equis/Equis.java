/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package equis;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Equis extends JFrame {

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel resultadoLabel = new JLabel("Resultado");
        resultadoLabel.setBounds(10, 120, 80, 25);
        panel.add(resultadoLabel);

        JTextArea resultadoText = new JTextArea();
        resultadoText.setBounds(80, 120, 120, 200);
//        resultadoText.setLineWrap(true);
        panel.add(resultadoText);

        JLabel userLabel = new JLabel("Ingresar el tamaño de la 'X':");
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
                int tamano = Integer.parseInt(numeroAText.getText());

                if (tamano == 0) {
                    resultadoText.setText("ERROR");
                } else {
                    String[][] dibujo = new String[tamano][tamano];
                    for (int i = 0; i < dibujo.length; i++) {
                        for (int j = 0; j < dibujo.length; j++) {
                            int x = i + 1;
                            if ((i == j) || (j == (tamano - x))) {
                                dibujo[i][j] = "X";
                                resultadoText.append(dibujo[i][j] + "");
                            } else {
                                dibujo[i][j] = "_";
                                resultadoText.append(dibujo[i][j] + "");
                            }
                        }
                        resultadoText.append("\n");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Miniequis");
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
//        Scanner input = new Scanner(System.in);
//        System.out.println("-------------------------- Miniequis Java ---------------------------");
//        System.out.println("\nPor favor Ingresar el tamaño de la X:");
//        int tamano = input.nextInt();
//
//        if (tamano == 0) {
//            System.out.println("ERROR");
//        } else {
//            String[][] dibujo = new String[tamano][tamano];
//
//            for (int i = 0; i < dibujo.length; i++) {
//                for (int j = 0; j < dibujo.length; j++) {
//                    int x = i + 1;
//                    if ((i == j) || (j == (tamano - x))) {
//                        dibujo[i][j] = "X";
//                        System.out.print(dibujo[i][j] + " ");
//                    } else {
//                        dibujo[i][j] = "_";
//                        System.out.print(dibujo[i][j] + " ");
//                    }
//                }
//                System.out.println();
//            }
//        }
    }
}
