package lab8;

import javax.swing.*;
import java.awt.*;

public class AnimateEllipse extends JFrame {
    // Розміри вікна
    private static final int CANVAS_WIDTH = 480;
    private static final int CANVAS_HEIGHT = 360;
    // Інтервал анімації в мілісекундах
    private static final int UPDATE_INTERVAL = 50;

    private DrawCanvas canvas;

    // Параметри еліпсу = його положення та стартові розміри та значення для зменшення розмірів
    private int x = 100;
    private int y = 100;
    private int startHeight = 200;
    private int startWidth = 400;
    private int heightDecrease = 2;
    private int widthDecrease = 4;

    // Конструктор
    public AnimateEllipse() {
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        this.setContentPane(canvas);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setTitle("Bouncing Ball");
        this.setVisible(true);

        for (int i = 0; i < 60; i++) {
            update();
            repaint();
            try {
                // затримуємо потік виконання, щом анімація тривала деякий час
                Thread.sleep(UPDATE_INTERVAL);
            } catch (InterruptedException ignore) {}
        }
    }

    // зменшуємо розміри
    public void update() {
        startWidth -= widthDecrease;
        startHeight -= heightDecrease;
    }

    // Перемальовуємо еліпс з новими розмірами
    class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.GRAY);
            g.setColor(Color.GREEN);
            g.fillOval(x, y, startWidth, startHeight);
        }
    }
}