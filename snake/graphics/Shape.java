package snake.graphics;

import snake.core.Direction;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Shape extends Drawable {

    private List<Rect> rects;

    public Shape(Color color) {
        setColor(color);
        rects = new ArrayList<>();
    }

    public List<Rect> getRects() {
        return rects;
    }

    public Rect getFirstRect() {
        return rects.get(0);
    }

    public Rect getLastRect() {
        return rects.get(rects.size() - 1);
    }


    public void addRect(Rect rect) {
        rect.setColor(getColor());
        rects.add(rect);
    }

    public Rect duplicateRect(Rect baseRect, Direction direction) {
        int baseX = (int) baseRect.getLocation().getX();
        int baseY = (int) baseRect.getLocation().getY();
        int baseWidth = (int) baseRect.getDimension().getWidth();
        int baseHeight = (int) baseRect.getDimension().getHeight();

        Point location = new Point(baseX + (baseWidth * direction.getSgnX()), baseY + (baseHeight * direction.getSgnY()));

        Rect newRect = new Rect(location, baseRect.getDimension());
        return newRect;
    }

    @Override
    public void draw(Graphics g) {

        for (Rect r : rects) {
            r.draw(g);
        }
    }

    public boolean intersects(Rect rect){
        for (Rect r : rects) {
            if (r.intersects(rect)){
                return true;
            }
        }
        return false;
    }
}