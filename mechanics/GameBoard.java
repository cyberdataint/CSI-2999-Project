package mechanics;
import mechanics.Pieces.Bishop;
import mechanics.Pieces.Knight;
//import other pieces when ready

public class GameBoard {
    public static Space[][] gameBoard;
    
    public GameBoard() {
        Space[][] board = new Space[8][8];
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
            gameBoard[i][j].xcoord = i;
            gameBoard[i][j].ycoord = j;
            gameBoard[i][j].bdanger = false;
            gameBoard[i][j].wdanger = false;
            gameBoard[i][j].occupant = null; 
            }
        }
        //call piece initializations
        new Knight(true, 0, board);
        new Knight(true, 1, board);
        new Knight(false, 0, board);
        new Knight(false, 1, board);

        new Bishop(true, 0, board);
        new Bishop(true, 1, board);
        new Bishop(false, 0, board);
        new Bishop(false, 1, board);
        gameBoard = board;
    }

    public void updateBoard() { //to be called after each turn
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                gameBoard[i][j].bdanger = false;
                gameBoard[i][j].wdanger = false;
            }
        }
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if (gameBoard[i][j].occupant != null) {
                    gameBoard[i][j].occupant.validMoves(gameBoard);
                }
            }
        }
    }

    public void intializePieces() {

        // implement

    }
}