package mechanics.Pieces;
import mechanics.Piece;
import mechanics.Space;
import java.util.ArrayList;
import java.util.List;

public class Queen implements Piece {
    private String name = "Queen";
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

    private boolean isValidMove(int x, int y, Space[][] board) {
        if (!(this.x == x || this.y == y || Math.abs(this.x - x) == Math.abs(this.y - y))) {
            return false; 
        }
    
        int dx = Integer.signum(x - this.x);
        int dy = Integer.signum(y - this.y);
        int steps = Math.max(Math.abs(x - this.x), Math.abs(y - this.y));
    
        for (int i = 1; i < steps; i++) {
            int checkX = this.x + i * dx;
            int checkY = this.y + i * dy;
            Space nextSpace = board[checkX][checkY];
            if (nextSpace.containsAlly(this)) { // Assuming containsAlly(this) checks if the space is occupied by an ally
                return false; 
            }
        }
    
        return true; 
    }

    public Space[] validMoves(Space[][] board) {
        List<Space> validMoves = new ArrayList<>();
        int[][] directions = {
            {0, 1}, // Up
            {0, -1}, // Down
            {1, 0}, // Right
            {-1, 0}, // Left
            {1, 1}, // Up-Right Diagonal
            {-1, -1}, // Down-Left Diagonal
            {1, -1}, // Down-Right Diagonal
            {-1, 1} // Up-Left Diagonal
        };
        
        for (int[] dir : directions) {
            int nextX = x;
            int nextY = y;
            
            while (true) {
                nextX += dir[0];
                nextY += dir[1];
                
                if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) {
                    break;
                }
                
                Space nextSpace = board[nextX][nextY];
                if (nextSpace.containsAlly(this)) { // Block move if an ally is in the way
                    break;
                } else if (nextSpace.containsEnemy(this)) { // Can move if an enemy is there, but stop checking further
                    validMoves.add(nextSpace);
                    break;
                } else {
                    validMoves.add(nextSpace); // Add as a valid move if empty
                }
            }
        }
        
        return validMoves.toArray(new Space[0]);
    }

    public int[] moveTo(int newX, int newY, Space[][] board) {
        if (isValidMove(newX, newY, board)) {
            // remove queen
            board[x][y].occupant = null;
    
            // new queen position
            board[newX][newY].occupant = this;
    
            this.x = newX;
            this.y = newY;
    
            return new int[]{newX, newY}; // back to position
        }
        return null; // bad move
    }

    public void remove(Space[][] board) {
        if (x != 0 && y != 0) {
            board[x][y].occupant = null;
            this.x = 0;
            this.y = 0;
        }
    }

    public void updateDangerVariables(Space[][] board) {
        // up, down, diagonal 
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

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
                    break;
                }
            }
        }
    }
}