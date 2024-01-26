package mechanics.Pieces;
import mechanics.Piece;
import mechanics.Space;

public class Bishop implements Piece {
    private int[] position;
    boolean color; //white or black
    int id; //#id of piece (i.e. bishop 0 or bishop 1)

    public Bishop(boolean col, int id, Space[][] board) { //constructor, initialize variable values;
        position = new int[2];
        this.color = col;
        this.id = id;
        //initially placing piece based on color and id
        if (col){
            this.position[1]=0;
        }
        else {
            this.position[1]=7;
        }
        if (id > 0) {
            this.position[0]=5;
        }
        else {
            this.position[0]=2;
        }
        board[this.position[0]][this.position[1]].occupant = this;
    }

    public int[] getPos() {
        return this.position;
    }
    public int getId() {
        return this.id;
    }
    public boolean getColor() {
        return this.color;
    }

    public Space[] validMoves(Space[][] board) { //return space array of valid moves
        int[] pos = this.position;
        Space[] moves = new Space[13];
        int moveCounter = 0;
        //check up right diagonal
        for (int i=1;pos[0]+i<8 && pos[1]+i<8 && !board[pos[0]+i][pos[1]+i].containsAlly(this); i++){ //on the board and no ally occupant
            moves[moveCounter]=board[pos[0]+i][pos[1]+i]; //valid move
            moveCounter++;
            if (this.color) {
                board[pos[0]+i][pos[1]+i].wdanger=true;
            }
            else {
                board[pos[0]+i][pos[1]+i].bdanger=true;
            }
            if (board[pos[0]+i][pos[1]+i].containsEnemy(this)) { //if contains an enemy, go no further
                i=10;
            }
        }
        //check down right diagonal
        for (int i=1;pos[0]+i<8 && pos[1]-i>-1 && !board[pos[0]+i][pos[1]-i].containsAlly(this); i++){ //on the board and no ally occupant
            moves[moveCounter]=board[pos[0]+i][pos[1]-i]; //valid move
            moveCounter++;
            if (this.color) {
                board[pos[0]+i][pos[1]-i].wdanger=true;
            }
            else {
                board[pos[0]+i][pos[1]-i].bdanger=true;
            }
            if (board[pos[0]+i][pos[1]-i].containsEnemy(this)) { //if contains an enemy, go no further
                i=10;
            }
        }
        //check down left diagonal
        for (int i=1;pos[0]-i>-1 && pos[1]-i>-1 && !board[pos[0]-i][pos[1]-i].containsAlly(this); i++){ //on the board and no ally occupant
            moves[moveCounter]=board[pos[0]-i][pos[1]-i]; //valid move
            moveCounter++;
            if (this.color) {
                board[pos[0]-i][pos[1]-i].wdanger=true;
            }
            else {
                board[pos[0]-i][pos[1]-i].bdanger=true;
            }
            if (board[pos[0]-i][pos[1]-i].containsEnemy(this)) { //if contains an enemy, go no further
                i=10;
            }
        }
        //check up left diagonal
        for (int i=1;pos[0]-i>-1 && pos[1]+i<8 && !board[pos[0]-i][pos[1]+i].containsAlly(this); i++){ //on the board and no ally occupant
            moves[moveCounter]=board[pos[0]-i][pos[1]+i]; //valid move
            moveCounter++;
            if (this.color) {
                board[pos[0]-i][pos[1]+i].wdanger=true;
            }
            else {
                board[pos[0]-i][pos[1]+i].bdanger=true;
            }
            if (board[pos[0]-i][pos[1]+i].containsEnemy(this)) { //if contains an enemy, go no further
                i=10;
            }
        }
        return moves;
    }

    public int[] moveTo(int x, int y, Space[][] board){
        Space [] moves = this.validMoves(board);
        for (int i=0;i<moves.length; i++) {
            if (moves[i].xcoord == x & moves[i].ycoord == y) { //if the coords are in the valid moves
                board[this.position[0]][this.position[1]].occupant = null; //pick up the piece
                if (board[moves[i].xcoord][moves[i].ycoord].containsEnemy(this)) { //if enemy
                    board[moves[i].xcoord][moves[i].ycoord].occupant.remove(board); //remove the enemy from the board
                }
                board[moves[i].xcoord][moves[i].ycoord].occupant = this; //place the piece
                int[] newCoords = new int[2];
                newCoords[0] = moves[i].xcoord;
                newCoords[1] = moves[i].ycoord; //update coords
                this.position = newCoords; //update piece variable
                //todo: figure out danger variables... Currently thinking they should be updated by the input handler compiling valid moves.
                return newCoords; //return coords
            }
        }
        return null; //return null if it failed
        
    }

    public void remove(Space[][] board){
        board[this.position[0]][this.position[1]].occupant = null;
        this.position = null;
    }

}
