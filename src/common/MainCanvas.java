package common;

import circles.MainWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Класс отрисовки компонента
 */
public class MainCanvas extends JPanel {

    //region Поля
    private final CanvasRepaintListener controller;
    private long lastFrameTime;

    //endregion


    //region Конструктор
    public MainCanvas(CanvasRepaintListener controller) {
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }

    //endregion


    //region Методы

    /**
     * Метод для создания FPS=60 (60 кадров/сек)
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();
        repaint();
    }

    /**
     * Геттеры для получения границ канвы
     */
    public int getLeft() { return 0; }
    public int getRight() { return getWidth() -1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

    //endregion
}
