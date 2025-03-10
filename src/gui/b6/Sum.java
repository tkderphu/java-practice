package gui.b6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sum extends JFrame {
    private JTextField number1Field;
    private JTextField number2Field;
    private JLabel resultLabel;

    public Sum() {
        setTitle("Sum 2 number");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        
        // Nhập số 1
        panel.add(new JLabel("Num1:"));
        number1Field = new JTextField(10);
        panel.add(number1Field);
        
        // Nhập số 2
        panel.add(new JLabel("Num2:"));
        number2Field = new JTextField(10);
        panel.add(number2Field);
        
        // Nút tính tổng
        JButton sumButton = new JButton("Sum");
        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number1 = Integer.parseInt(number1Field.getText());
                    int number2 = Integer.parseInt(number2Field.getText());
                    int sum = number1 + number2;
                    resultLabel.setText("Result: " + sum);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(sumButton);
        
        resultLabel = new JLabel("Kết quả:");
        panel.add(resultLabel);
        
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Sum().setVisible(true);
        });
    }
}
