package snake.core;

import snake.util.Constants;
import snake.graphics.Rect;
import snake.graphics.Renderer;
import snake.scene.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame implements KeyListener {

    private Renderer renderer;
    private Snake snake;
    private Image buffer;
    private Graphics gImage;
    private static Rectangle drawingArea;
    private long lastKeyboardEventTime;


    public GameWindow(Snake snake){
        this.snake = snake;

        setSize (Constants.WINDOW_WIDTH , Constants.WINDOW_HEIGHT);
        setResizable(false);
        setTitle(Constants.WINDOW_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //to_do --> Impedir janela de ser minimizada
        setLocationRelativeTo(null);
        addKeyListener(this);
        setVisible(true);

        buffer = createImage(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        gImage = buffer.getGraphics();

        renderer = new Renderer(gImage);

        defineDrawingArea();

    }

    public Renderer getRenderer() {
        return renderer;
    }

    @Override
    public void paint(Graphics gScreen) {
        if (gScreen == null || renderer == null) {
            return;
        }
        renderer.render();
        gScreen.drawImage(buffer, 0, 0, null);
    }

    private void defineDrawingArea(){
        int upperY = (int) (Constants.WINDOW_HEIGHT - getContentPane().getSize().getHeight());
        drawingArea = new Rectangle(0,upperY, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - upperY);
    }

    public static Rectangle getDrawingArea(){
        return drawingArea;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        long now = System.currentTimeMillis();

        if (now - lastKeyboardEventTime < 40) {
            return;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            snake.up();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            snake.down();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            snake.left();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            snake.right();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        lastKeyboardEventTime = now;
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

}
