package gui;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("The front View of a microwave");
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        LayoutManager layoutManager = new BorderLayout();
        JPanel jPanel = new JPanel(layoutManager);
        jPanel.add(new JButton("A button"));
        frame.add(jPanel, BorderLayout.WEST);
        JPanel jPanel1 = new JPanel(layoutManager);
        jPanel1.add(new JTextField("a textfield"));
        jPanel1.add(new JButton("12 buttons"));
        frame.add(jPanel1, BorderLayout.EAST);





    }
}
