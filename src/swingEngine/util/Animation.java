package swingEngine.util;

public class Animation {
    private Position position;
    private int length;
    private int spriteSize;
    private int speed;
    private int cmpt;
    private int negativeCmpt;

    public Animation(int x, int y, int length, int spriteSize, int speed) {
        this.position = new Position(x, y);
        this.length = length;
        this.spriteSize = spriteSize;
        this.cmpt = -1;
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
        int toAdd = 0;

        if (speed > 0) {
            cmpt += speed;
            if (cmpt >= length){
                cmpt = 0;
            }
            toAdd = (cmpt*spriteSize);
        }
        else {
            if (negativeCmpt == speed) {
                cmpt++;
                if (cmpt >= length){
                    cmpt = 0;
                }
                negativeCmpt = 0;
                toAdd = (cmpt*spriteSize);
            }
            negativeCmpt--;
        }

        return new Position(position.getX() + toAdd, position.getY());
    }

}
