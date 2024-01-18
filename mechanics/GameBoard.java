package mechanics;

public class GameBoard {
    public Space[][] gameBoard;
    
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
        //todo: call piece initializations
        this.gameBoard = board;
    }
}