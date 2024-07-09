package common;

import java.awt.*;

public interface CanvasRepaintListener {

    /**
     * Метод для отрисовки канвы объектом графики через определенное время
     */
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime);
}
