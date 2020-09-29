package snake.graphics;


import snake.scene.Snake;
import snake.util.Constants;
import snake.graphics.Rect;
import snake.util.GameUtils;
import snake.*;

import java.awt.*;

public class Food extends Rect {

    private int eatenTimes;

    public Food(Snake snake, Rectangle drawingArea) {
        setColor(Color.green);
        setDimension(new Dimension(Constants.SNAKE_PIECE_SIZE,Constants.SNAKE_PIECE_SIZE));
        setRandomLocation(snake, drawingArea);

    }

    public void setRandomLocation(Snake snake, Rectangle drawingArea){
        int offset = 3;
        do {
            int minX = (int) drawingArea.getMinX() + offset;
            int minY = (int) drawingArea.getMinX() + offset;

            int maxX = (int) drawingArea.getMaxX() - Constants.SNAKE_PIECE_SIZE - offset;
            int maxY = (int) drawingArea.getMaxY() - Constants.SNAKE_PIECE_SIZE - offset;

            int randomX = GameUtils.random(minX, maxX);
            int randomY = GameUtils.random(minY, maxY);

            setLocation(new Point(randomX, randomY));
        } while (snake.intersects(this));
    }

    public void checkIfEaten(Snake snake, Rectangle drawingArea){
        if (snake.intersects(this)) {
            eatenTimes++;
            setRandomLocation(snake, drawingArea);
            snake.elongate();
        }
    }

    public int getEatenTimes(){
        return eatenTimes;
    }
}

