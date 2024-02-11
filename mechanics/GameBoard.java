package mechanics;
import mechanics.Pieces.Bishop;
import mechanics.Pieces.Knight;
import mechanics.Pieces.King;
//import other pieces when ready

public class GameBoard {
    public static Space[][] gameBoard;
    public Space wKingSpace;
    public Space bKingSpace;

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

        new King(true, 0, board);
        new King(false, 0, board);
        
        gameBoard = board;
        wKingSpace = gameBoard[4][0];
        bKingSpace = gameBoard[4][7];
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
                    if (gameBoard[i][j].occupant.getName() == "King"){
                        if (gameBoard[i][j].occupant.getColor()) {
                            wKingSpace = gameBoard[i][j];
                        }
                        else {
                            bKingSpace = gameBoard[i][j];
                        }
                    }
                    gameBoard[i][j].occupant.validMoves(gameBoard);
                }
            }
        }
    }

    public boolean whiteChecked() {
        return wKingSpace.bdanger;
    }
    public boolean blackChecked() {
        return bKingSpace.wdanger;
    }
}