package mechanics.Pieces;
import mechanics.Piece;
import mechanics.Space;

import java.util.ArrayList;
import java.util.List;

public class Rook implements Piece {
    private int x, y;
    private boolean isWhite;
    private int id;

    @Override
    public boolean getColor() {
        return isWhite;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int[] getPos() {
        return new int[]{x, y};
    }

    @Override
    public boolean isValidMove(int x, int y, Space[][] board) {
        // horizontal and vertical
        if (!(this.x == x || this.y == y)) {
            return false;
        }

        int dx = Integer.signum(x - this.x);
        int dy = Integer.signum(y - this.y);
        int steps = Math.max(Math.abs(x - this.x), Math.abs(y - this.y));

        for (int i = 1; i < steps; i++) {
            int checkX = this.x + i * dx;
            int checkY = this.y + i * dy;
            if (board[checkX][checkY].isOccupied()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Space[] validMoves(Space[][] board) {
        // rook moves
    }

    @Override
    public int[] moveTo(int x, int y, Space[][] board) {
        if (isValidMove(x, y, board)) {
            // move rook if can
        }
        return null;
    }

    @Override
    public void remove(Space[][] board) {
        // removing rook
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