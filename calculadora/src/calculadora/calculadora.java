/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculadora;

/**
 *
 * @author
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculadora extends JFrame {

    public static int result(String operacion, String numeroA, String numeroB, double res) {
        switch (operacion) {
            case "1":
                res = Integer.parseInt(numeroA) + Integer.parseInt(numeroB);
                break;
            case "2":
                res = Integer.parseInt(numeroA) - Integer.parseInt(numeroB);
                break;
            case "3":
                res = Integer.parseInt(numeroA) * Integer.parseInt(numeroB);
                break;
            case "4":
                res = Integer.parseInt(numeroA) / Integer.parseInt(numeroB);
                 break;
        }
        return (int) res;
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel resultadoLabel = new JLabel("Resultado");
        resultadoLabel.setBounds(10, 120, 80, 25);
        panel.add(resultadoLabel);

        JTextField resultadoText = new JTextField(20);
        resultadoText.setBounds(100, 120, 160, 25);
        panel.add(resultadoText);

        JLabel userLabel = new JLabel("Número A");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        JTextField numeroAText = new JTextField(20);
        numeroAText.setBounds(100, 10, 160, 25);
        panel.add(numeroAText);

        JTextField numeroBText = new JTextField(20);
        numeroBText.setBounds(100, 40, 160, 25);
        panel.add(numeroBText);

        JButton sumaButton = new JButton("+");
        sumaButton.setBounds(8, 80, 60, 25);
        panel.add(sumaButton);
        sumaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int resultado;
                resultado = result("1", numeroAText.getText(), numeroBText.getText(), 0);
                resultadoText.setText("" + resultado);
            }
        });
        JButton restaButton = new JButton("-");
        restaButton.setBounds(80, 80, 60, 25);
        panel.add(restaButton);
        restaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int resultado;
                resultado = result("2", numeroAText.getText(), numeroBText.getText(), 0);
                resultadoText.setText("" + resultado);
            }
        });

        JButton multiButton = new JButton("x");
        multiButton.setBounds(150, 80, 60, 25);
        panel.add(multiButton);
        multiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int resultado;
                resultado = result("3", numeroAText.getText(), numeroBText.getText(), 0);
                resultadoText.setText("" + resultado);
            }
        });

        JButton divButton = new JButton("%");
        divButton.setBounds(220, 80, 60, 25);
        panel.add(divButton);
        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int resultado;
                resultado = result("4", numeroAText.getText(), numeroBText.getText(), 0);
                resultadoText.setText("" + resultado);
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height / 4;
        int width = pantalla.width / 4;
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);

//        Scanner sc = new Scanner(System.in);
//        int numeroA = 0;
//        int numeroB = 0;
//        double res = 0;
//        String operacion;
//        System.out.println("-------------------------- Minicalculadora Java ---------------------------");
//        System.out.println("\n¿Que operación aritmetica listada desea ejecutar?\n 1. Suma\n 2. Resta\n 3. Multiplicación\n 4. División \n\n Por favor seleccione el numero de la operación a ejecutar ");
//        operacion = sc.nextLine();
//        System.out.println("Digite el primer número");
//        numeroA = Integer.parseInt(sc.nextLine());
//        System.out.println("Digite el segundo número");
//        numeroB = Integer.parseInt(sc.nextLine());
//        switch (operacion) {
//            case "1":
//                res = numeroA + numeroB;
//                break;
//            case "2":
//                res = numeroA - numeroB;
//                break;
//            case "3":
//                res = numeroA * numeroB;
//                break;
//            case "4":
//                res = numeroA / numeroB;
//        }
//        System.out.println("\nEl resultado de la operación es:\n" + res);
    }

}
