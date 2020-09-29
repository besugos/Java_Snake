package snake.scene;

import snake.graphics.Text;
import snake.util.Constants;

import java.awt.*;

public class GameOverText extends Text {

    public GameOverText(int score) {

        super(Constants.GAME_OVER_COLOR, String.format(Constants.GAME_OVER_TEXT, score), Constants.GAME_OVER_LOCATION);
    }
}
