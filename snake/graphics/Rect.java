package snake.graphics;

import java.awt.*;

public class Rect extends Drawable{

    private Rectangle rectangle;


    public Rect(Point location, Dimension dimension) {
        this.rectangle = new Rectangle(location, dimension);

    }

    public Rect(int x, int y, int width, int height) {
        this.rectangle = new Rectangle(x, y, width, height);


    }

    public Rect(){
        this.rectangle = new Rectangle(0,0);
    }

    public Point getLocation() {
        return rectangle.getLocation();
    }

    public void setLocation(Point location) {
        rectangle.setLocation(location);
    }

    public Dimension getDimension() {
        return rectangle.getSize();
    }

    public void setDimension(Dimension dimension) {
        rectangle.setSize(dimension);
    }

    public boolean intersects(Rect other) {
        return rectangle.intersects(other.rectangle);
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect((int) rectangle.getLocation().getX(), (int)rectangle.getLocation().getY(), (int)rectangle.getSize().getWidth(), (int)rectangle.getSize().getHeight());
    }
}
