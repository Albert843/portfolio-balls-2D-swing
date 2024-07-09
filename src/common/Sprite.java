package common;

import common.Interactable;
import common.MainCanvas;

import java.awt.*;

/**
 * Класс объекта графики
 */
public abstract class Sprite implements Interactable {

    //region Поля
    /**
     * Координаты центра объекта графики
     */
    protected float x, y;

    /**
     * Переменные для определения границ объекта графики
     */
    protected float halfWidth, halfHeight;

    //endregion


    //region Геттеры и Сеттеры

    /**
     * Геттеры и сеттеры для определения границ объекта графики
     */
    protected float getLeft() { return x - halfWidth; }
    protected void setLeft(float left) { x = left + halfWidth; }
    protected float getRight() { return x + halfWidth; }
    protected void setRight(float right) { x = right - halfWidth; }
    protected float getTop() { return y - halfHeight; }
    protected void setTop(float top) { y = top + halfHeight; }
    protected float getBottom() { return y + halfHeight; }
    protected void setBottom(float bottom) { y = bottom - halfHeight; }

    //endregion


    //region Методы

    /**
     * Ширина и высота объекта графики
     */
    protected float getWidth() { return halfWidth * 2f; }
    protected float getHeight() { return halfHeight * 2f; }

    /**
     * Метод обновления канвы через определенное время
     */
    public void update(MainCanvas canvas, float deltaTime) {}

    /**
     * Метод отрисовки канвы объектом графики
     */
    public void render(MainCanvas canvas, Graphics g) {}

    //endregion
}
