package mechanics;

public class Space {
    public Piece occupant;
    public boolean wdanger;
    public boolean bdanger;
    int xcoord;
    int ycoord;

    public Space[][] createBoard() {
        Space[][] gameBoard = new Space[8][8];
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
            gameBoard[i][j].xcoord = i;
            gameBoard[i][j].ycoord = j; 
            }
        }
        return gameBoard;
    }
}

//todo: place pieces (initialize occupants and danger variables per space on board) note: this could be done by the pieces initializing, rather than the board