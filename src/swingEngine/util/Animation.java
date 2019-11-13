package swingEngine.util;

public class Animation {
    private Position position;
    private int length;
    private int spriteSize;
    private int speed;
    private int cmpt;
    private int negativeCmpt;
    private boolean animationOnY;

    public Animation(int x, int y, int length, int spriteSize, int speed) {
        this.position = new Position(x, y);
        this.length = length;
        this.spriteSize = spriteSize;
        this.cmpt = 0;
        this.negativeCmpt = 0;
        this.speed = speed;
        this.animationOnY = false;
    }

    public void setAnimationOnY() {
        this.animationOnY = true;
    }

    public Animation(int x, int y, int length, int spriteSize, int speed, int decalage) {
        this.position = new Position(x, y);
        this.length = length;
        this.spriteSize = spriteSize;
        this.cmpt = decalage;
        this.negativeCmpt = 0;
        this.speed = speed;
    }

    public int getSpriteSize() {
        return spriteSize;
    }

    public int getLength() {
        return length;
    }

    public int getSpeed() {
        return speed;
    }

    public Position getNextPosition(){

        if (speed > 0) {
            cmpt += speed;
            if (cmpt >= length){
                cmpt = 0;
            }
        }
        else {
            if (negativeCmpt == speed) {
                cmpt++;
                if (cmpt >= length){
                    cmpt = 0;
                }
                negativeCmpt = 0;

            }
            negativeCmpt--;
        }
        int toAdd = (cmpt*spriteSize);
        if (animationOnY){
            return new Position(position.getX(), position.getY() + toAdd);
        }
        return new Position(position.getX() + toAdd, position.getY());
    }

}
