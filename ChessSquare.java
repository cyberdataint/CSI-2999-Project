import javax.swing.*;

public class ChessSquare {
    
    public ImageIcon sprite;
    private int x;
    private int y;

    public ChessSquare(ImageIcon pieceSprite, int xCoord, int yCoord) {

        sprite = pieceSprite;
        x = xCoord;
        y = yCoord;

    }

    public int getX() {

        return x;

    }

    public int getY() {

        return y;

    }


}
