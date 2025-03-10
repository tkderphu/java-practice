package gui.b6;

import javax.swing.*;
import java.awt.*;

public class Prime extends JFrame {
    private JTextField numberField;
    private JLabel resultLabel;
    public Prime() {
        setTitle("Kiem tra so nguyen to");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("Nhap so n: "));
        numberField = new JTextField(10);
        jPanel.add(numberField);

        JButton buttonCheck = new JButton("Check");
        this.resultLabel = new JLabel();
        jPanel.add(buttonCheck);
        jPanel.add(resultLabel);
        buttonCheck.addActionListener(e -> {
            String value = numberField.getText();
            try {
                int numb = Integer.parseInt(value);
                if(Prime.isPrime(numb)) {
                    this.resultLabel.setText(String.format("%s la so nguyen to", value));
                } else {
                    this.resultLabel.setText(String.format("%s khong phai la so nguyen to", value));
                }
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, String.format("%s khong phai la chu so", value), "Loi nhap du lieu", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(jPanel);
    }

    public static void main(String[] args) {
        var frame = new Prime();
        frame.setVisible(true);
    }
    public static boolean isPrime(int x) {
        if(x < 2) return false;
        for(int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0) return false;
        }
        return true;
    }
}
