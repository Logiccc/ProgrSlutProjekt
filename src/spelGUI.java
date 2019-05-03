import javax.swing.*;
import java.awt.*;

public class spelGUI {
    private JPanel gui;
    private JTextArea textArea1;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JButton button1;
    private JButton button2;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pasta Alfredos Äventyr");
        spelGUI test = new spelGUI();
        frame.setContentPane(test.gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(800, 600));
        frame.setVisible(true);

    }
}
