package snake.core;

import snake.graphics.Food;
import snake.graphics.Rect;
import snake.scene.Background;
import snake.graphics.Renderer;
import snake.scene.GameOverText;
import snake.scene.Snake;
import snake.util.Constants;
import snake.util.GameUtils;

import java.awt.*;

public class Game implements Runnable{

    private GameWindow gameWindow;
    private Renderer renderer;
    private Snake snake;
    private Food food;


    public void start(){
        snake = new Snake();
        gameWindow = new GameWindow(snake);
        food = new Food(snake, gameWindow.getDrawingArea());
        renderer = gameWindow.getRenderer();


        addElementsToScreen();

//        Thread t = new Thread(this);
//        t.start();

        new Thread(this).start();

    }

    private void addElementsToScreen() {
        renderer.add(new Background());
        renderer.add(snake);
        renderer.add(food);

    }

    @Override
    public void run() {
        do{
            gameWindow.repaint();

            snake.move();
            food.checkIfEaten(snake, GameWindow.getDrawingArea());
            GameUtils.sleep(100);

        } while (!isGameOver());

        processGameOver();
    }

    private boolean isGameOver() {
        return snake.collidesWithItself() || isSnakeHitBounds();
    }

    private void processGameOver() {
        renderer.remove(snake);
        renderer.remove(food);
        renderer.add(new GameOverText(food.getEatenTimes()));
        gameWindow.repaint();
    }

    private boolean isSnakeHitBounds(){
        Rect head = snake.getFirstRect();
        Rectangle drawingArea = gameWindow.getDrawingArea();

        int headX = (int) head.getLocation().getX();
        int headY = (int) head.getLocation().getY();

        int areaX1 = (int) drawingArea.getMinX();
        int areaY1 = (int) drawingArea.getMinY() - Constants.SNAKE_PIECE_SIZE * 2;

        int areaX2 = (int) drawingArea.getMaxX();
        int areaY2 = (int) drawingArea.getMaxY();

        if (headX <= areaX1 || headX + Constants.SNAKE_PIECE_SIZE >= areaX2){
            return true;
        }

        if (headY <= areaY1 || headY + Constants.SNAKE_PIECE_SIZE >= areaY2){
            return true;
        }

        return false;
    }

//    private void putNewFood() {
//
//    }

}
