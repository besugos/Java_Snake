package snake.graphics;

import java.awt.*;

public abstract class Drawable {


    private Color color;

    public Drawable(Color color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Drawable() {
        color = Color.black;
    }

    public Color getColor() {
        return color;
    }

    public abstract void draw(Graphics g);


}
