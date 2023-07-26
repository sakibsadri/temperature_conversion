
package temperature_conversion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperature_conversion extends JFrame {

    private JTextField inputField;
    private JLabel inputLabel, resultLabel;
    private JButton convertButton;
    private JComboBox<String> conversionType;

    public Temperature_conversion() {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        inputLabel = new JLabel("Enter temperature:");
        inputField = new JTextField(10);
        resultLabel = new JLabel("Result: ");
        convertButton = new JButton("Convert");

        // Populate the conversion types in the drop-down menu
        String[] conversionTypes = {"Celsius to Fahrenheit", "Fahrenheit to Celsius"};
        conversionType = new JComboBox<>(conversionTypes);

        add(inputLabel);
        add(inputField);
        add(conversionType);
        add(convertButton);
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            double result;

            if (conversionType.getSelectedIndex() == 0) {
                result = (inputValue * 9.0 / 5.0) + 32.0;
                resultLabel.setText("Result: " + inputValue + "°C = " + result + "°F");
            } else {
                result = (inputValue - 32.0) * 5.0 / 9.0;
                resultLabel.setText("Result: " + inputValue + "°F = " + result + "°C");
            }

        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Temperature_conversion().setVisible(true);
            }
        });
    }
}

