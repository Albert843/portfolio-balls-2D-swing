package bricks;

import common.CanvasRepaintListener;
import common.Interactable;
import common.MainCanvas;

import javax.swing.*;
import java.awt.*;

/**
 * Класс окна с квадратами
 */
public class MainWindow extends JFrame implements CanvasRepaintListener {

    //region Поля

    private static final int POS_X = 800;
    private static final int POS_Y = 200;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private final Interactable[] sprites = new Interactable[10];

    //endregion


    //region Конструктор

    /**
     * Конструктор окна
     */
    private MainWindow() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
            setAlwaysOnTop(true);
            setTitle("Bricks");

            for (int i = 0; i < sprites.length; i++) {
                sprites[i] = new Brick();
            }
            MainCanvas canvas = new MainCanvas(this);
            add(canvas);

            setVisible(true);
        }

    //endregion


    //region Методы

        /**
        * Метод для отрисовки канвы объектом графики через определенное время
        */
        public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
            update(canvas, deltaTime);
            render(canvas, g);
        }

        /**
        * Метод для обновления канвы через определенное время
        */
        private void update(MainCanvas canvas, float deltaTime) {
            for (int i = 0; i < sprites.length; i++) {
                sprites[i].update(canvas, deltaTime);
            }
        }

        /**
        * Метод для отрисовки канвы объектом графики
        */
        private void render(MainCanvas canvas, Graphics g) {
            for (int i = 0; i < sprites.length; i++) {
                sprites[i].render(canvas, g);
            }
        }

    /**
     * Точка входа
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    //endregion
}
