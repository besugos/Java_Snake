package snake.core;

public enum Direction {

    NONE(0,0),
    LEFT(-1,0),
    RIGHT(1,0),
    UP(0,-1),
    DOWN(0,1);

    int sgnX;
    int sgnY;

    Direction(int sgnX, int sgnY) {
        this.sgnX = sgnX;
        this.sgnY = sgnY;
    }

    public int getSgnX() {
        return sgnX;
    }

//    public void setSgnX(int sgnX) {
//        this.sgnX = sgnX;
//    }

    public int getSgnY() {
        return sgnY;
    }

//    public void setSgnY(int sgnY) {
//        this.sgnY = sgnY;
//    }

    public boolean canChangeTo(Direction other) {
        return !(sgnX + other.sgnX == 0 && sgnY + other.sgnY == 0);
    }
}
