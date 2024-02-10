package mechanics.Pieces;
import mechanics.Piece;
import mechanics.Space;
import java.util.ArrayList;
import java.util.List;

public class Rook implements Piece {
    private String name = "Rook";
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
    public String getName() {
        return name;
    }


    public boolean isValidMove(int x, int y, Space[][] board) {
        // Horizontal and vertical
        if (!(this.x == x || this.y == y)) {
            return false;
        }

        int dx = Integer.signum(x - this.x);
        int dy = Integer.signum(y - this.y);
        int steps = Math.max(Math.abs(x - this.x), Math.abs(y - this.y));

        for (int i = 1; i < steps; i++) {
            int checkX = this.x + i * dx;
            int checkY = this.y + i * dy;
            Space nextSpace = board[checkX][checkY];
            if (nextSpace.containsAlly(this)) { // Use containsAlly to check for blockage
                return false;
            }
        }
        return true;
    }

    public Space[] validMoves(Space[][] board) {
        List<Space> moves = new ArrayList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
        for (int[] dir : directions) {
            int nextX = x;
            int nextY = y;
            while (true) {
                nextX += dir[0];
                nextY += dir[1];
                if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) {
                    break; // Check board boundaries
                }
                
                Space nextSpace = board[nextX][nextY];
                if (nextSpace.containsAlly(this)) { // Stop if an ally is in the way
                    break;
                }
                moves.add(nextSpace); // Add as a valid move
                
                if (nextSpace.containsEnemy(this)) { // Stop if an enemy is encountered
                    break;
                }
            }
        }
        return moves.toArray(new Space[0]);
    }

    public int[] moveTo(int x, int y, Space[][] board) {
        if (isValidMove(x, y, board)) {
            board[this.x][this.y].occupant = null; 
            this.x = x;
            this.y = y;
            board[x][y].occupant = this; 
            updateDangerVariables(board);
            return new int[]{x, y};
        }
        return null; // bad move
    }

    public void remove(Space[][] board) {
        if (x != 0 && y != 0) {
            board[x][y].occupant = null; 
            x = 0; 
            y = 0;
        }
    }

    public void updateDangerVariables(Space[][] board) {
        // horizontal and vertical
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];
            int nextX = x;
            int nextY = y;
            while (true) {
                nextX += dx;
                nextY += dy;
                if (nextX < 0 || nextX >= 8 || nextY < 0 || nextY >= 8) {
                    break; // board boundary
                }
                if (isWhite) {
                    board[nextX][nextY].wdanger = true;
                } else {
                    board[nextX][nextY].bdanger = true;
                }
                if (board[nextX][nextY].isOccupied()) {
                    break; // occupied space
                }
            }
        }
    }
}