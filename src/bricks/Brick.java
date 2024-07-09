package bricks;

import common.MainCanvas;
import common.Sprite;

import java.awt.*;
import java.util.Random;

/**
 * Класс прозрачного квадрата
 */
public class Brick extends Sprite {

    //region Поля

    private static final Random random = new Random();
    private final Color color;
    private float vX, vY;               //Speed of brick

    //endregion


    //region Конструктор

    /**
     * Конструктор движущего объекта графики
     */
    Brick() {
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(random.nextInt());
        vX = 100f + (float) (Math.random() * 200f);
        vY = 100f + (float) (Math.random() * 200f);
    }

    //endregion


    //region Методы

    /**
     * Метод отрисовки объекта графики
     */
    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.setColor(color);
        g.drawRect((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());

    }

    /**
     * Метод обновления объекта графики
     */
    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }
    }

    //endregion
}
