package mechanics.Pieces;
import mechanics.Piece;
import mechanics.Space;
import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {
    private int x, y;
    private boolean isWhite;
    private int id;

    public boolean getColor() {
        return isWhite;
    }

    public int getId() {
        return id;
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    private boolean isValidMove(int x, int y, Space[][] board) {
        int direction = isWhite ? -1 : 1;
        // regular move
        if (x == this.x && y == this.y + direction && board[x][y].occupant == null) {
            return true;
        }
        // first pawn move capability 2 squares
        if (this.x == x && ((isWhite && this.y == 6) || (!isWhite && this.y == 1)) &&
            y == this.y + 2 * direction && board[x][y].occupant == null && board[x][y - direction].occupant == null) {
            return true;
        }
        // diagonal capture
        if (Math.abs(this.x - x) == 1 && y == this.y + direction && board[x][y].containsEnemy(this)) {
            return true;
        }
        return false;
    }

    public Space[] validMoves(Space[][] board) {
        List<Space> validMoves = new ArrayList<>();
        int direction = isWhite ? -1 : 1;
        // check forward move
        if (board[x][y + direction].occupant == null) {
            validMoves.add(board[x][y + direction]);
        }
        // two square first move
        if ((isWhite && y == 6) || (!isWhite && y == 1)) {
            if (board[x][y + 2 * direction].occupant == null && board[x][y + direction].occupant == null) {
                validMoves.add(board[x][y + 2 * direction]);
            }
        }
        // diagonal capture
        if (x > 0 && board[x - 1][y + direction].containsEnemy(this)) {
            validMoves.add(board[x - 1][y + direction]);
        }
        if (x < 7 && board[x + 1][y + direction].containsEnemy(this)) {
            validMoves.add(board[x + 1][y + direction]);
        }
        return validMoves.toArray(new Space[0]);
    }

    public int[] moveTo(int x, int y, Space[][] board) {
        if (isValidMove(x, y, board)) {
            board[this.x][this.y].occupant = null; // remove from current space
            this.x = x;
            this.y = y;
            board[x][y].occupant = this; // in new space
            return new int[]{x, y};
        }
        return null; 
    }

    public void remove(Space[][] board) {
        board[x][y].occupant = null;
    }

    public String getName() {
        return "Pawn"; // name of piece
    }

    public void updateDangerVariables(Space[][] board) {
        int direction = isWhite ? -1 : 1;
        int[] dx = {-1, 1};

        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + direction;
            if (nextX >= 0 && nextX < 8 && nextY >= 0 && nextY < 8) {
                if (isWhite) {
                    board[nextX][nextY].wdanger = true;
                } else {
                    board[nextX][nextY].bdanger = true;
                }
            }
        }
    }
}