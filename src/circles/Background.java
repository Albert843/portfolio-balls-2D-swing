package circles;

import common.Interactable;
import common.MainCanvas;

import java.awt.*;

/**
 * Класс фона для окна с шариками
 */
public class Background implements Interactable {

    //region Поля
    private float time;
    private static final float AMPLITUDE = 255f / 2f;
    private Color color;

    //endregion


    //region Методы
    /**
     * Метод обновления цвета фона через определенное время
     */
    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
        color = new Color(red, green, blue);
    }

    /**
     * Метод отрисовки цвета фона
     */
    @Override
    public void render(MainCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }

    //endregion
}
