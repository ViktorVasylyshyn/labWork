package lab7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GraphicPanel extends JFrame implements ActionListener {
    //Елементи вікна
    private JPanel mainPanel, textPanel, fontPanel, colorPanel;
    private JSpinner fontsSpinner, colorsSpinner;
    private JTextField textField;
    private JLabel outputText;

    public void createGraphicPanel() {
        // Поле вводу
        textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());
        textPanel.add(new JLabel("Text"));
        textField = new JTextField("put here your text");
        textPanel.add(textField);

        //Спіннер шрифти
        String[] fontsList = {"Times New Roman", "Arial", "Verdana"};
        fontsSpinner = new JSpinner(new SpinnerListModel(fontsList));
        fontPanel = new JPanel();
        fontPanel.setLayout(new FlowLayout());
        fontPanel.add(new JLabel("Гарнітура"));
        fontPanel.add(fontsSpinner);

        //Спіннер кольори
        String[] colorsList = {"Чорний", "Червоний", "Зелений", "Синій"};
        colorsSpinner = new JSpinner(new SpinnerListModel(colorsList));
        colorPanel = new JPanel();
        colorPanel.setLayout(new FlowLayout());
        colorPanel.add(new JLabel("кольор"));
        colorPanel.add(colorsSpinner);

        // Кнопка
        JButton button = new JButton("Вивести рядок");
        button.addActionListener(this);

        //поле результату (для зручності додамо стартовий текс - підказку)
        outputText = new JLabel("<operation result will be here>");

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        //Додаємо єлементи вікна
        mainPanel.add(textPanel);
        mainPanel.add(fontPanel);
        mainPanel.add(colorPanel);
        mainPanel.add(button);
        mainPanel.add(outputText);

        setTitle("Виведення рядка");
        add(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String targetString = textField.getText();
        Font targetFont;
        Color targetColor;
        //Визначаємо який шрифт вибрав користувач
        switch (fontsSpinner.getValue().toString()) {
            case "Times New Roman":
                targetFont = new Font("Times Nes Roman", Font.BOLD, 72);
                break;
            case "Arial":
                targetFont = new Font("Arial", Font.BOLD, 72);
                break;
            case "Verdana":
                targetFont = new Font("Verdana", Font.BOLD, 72);
                break;
            default:
                throw new IllegalArgumentException();
        }
        //визначаємо який кольор вибрав користувач
        switch ((String) colorsSpinner.getValue()) {
            case "Чорний":
                targetColor = Color.BLACK;
                break;
            case "Червоний":
                targetColor = Color.RED;
                break;
            case "Зелений":
                targetColor = Color.GREEN;
                break;
            case "Синій":
                targetColor = Color.BLUE;
                break;
            default:
                throw new IllegalArgumentException();
        }

        outputText.setText(targetString);
        outputText.setFont(targetFont);
        outputText.setForeground(targetColor);
    }
}
