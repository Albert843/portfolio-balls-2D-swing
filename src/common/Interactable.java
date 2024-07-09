package common;

import java.awt.*;

public interface Interactable {

    /**
     * Метод для обновления канвы через определенное время
     */
    void update(MainCanvas canvas, float deltaTime);

    /**
     * Метод для отрисовки канвы объектом графики
     */
    void render(MainCanvas canvas, Graphics g);
}
