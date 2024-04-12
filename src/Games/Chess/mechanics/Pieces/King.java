package Games.Chess.Mechanics.Pieces;
import Games.Chess.Mechanics.Piece;
import Games.Chess.Mechanics.Space;
import Games.Chess.Mechanics.Game;
import Games.Chess.Mechanics.GameBoard;

public class King implements Piece {
    private int[] position;
    boolean color; //white or black
    int id; //#id of piece (i.e. bishop 0 or bishop 1)
    String name;

    public King(boolean col, int id, Space[][] board) { //constructor, initialize variable values;
        position = new int[2];
        this.name = "King";
        this.color = col;
        this.id = id;
        //initially placing piece based on color and id
        if (col){
            this.position[1]=0;
        }
        else {
            this.position[1]=7;
        }
        this.position[0]=4;
        board[this.position[0]][this.position[1]].occupant = this;
    }

    public Space[] validMoves(Space[][] board) { //return space array of valid moves
        int[] pos = this.position;
        Space[] moves = new Space[8];
        int moveCounter = 0;
        //^
        if (pos[1]+1 < 8){
            if (!board[pos[0]][pos[1]+1].containsAlly(this)) {
                if (!(board[pos[0]][pos[1]+1].bdanger && this.color) && !(board[pos[0]][pos[1]+1].wdanger && !this.color)) {//if king isn't putting themselves in danger
                    moves[moveCounter] = board[pos[0]][pos[1]+1]; //valid move
                    moveCounter++;
                    if (this.color) {
                        board[pos[0]][pos[1]+1].wdanger=true;
                    }
                    else {
                        board[pos[0]][pos[1]+1].bdanger=true;
                    }
                }
                
            }
        }
        //>^
        if (pos[0]+1 < 8 && pos[1]+1 < 8){
            if (!board[pos[0]+1][pos[1]+1].containsAlly(this)) {
                if (!(board[pos[0]+1][pos[1]+1].bdanger && this.color) && !(board[pos[0]+1][pos[1]+1].wdanger && !this.color)) {
                    moves[moveCounter] = board[pos[0]+1][pos[1]+1]; //valid move
                    moveCounter++;
                    if (this.color) {
                        board[pos[0]+1][pos[1]+1].wdanger=true;
                    }
                    else {
                        board[pos[0]+1][pos[1]+1].bdanger=true;
                    }
                }
            }
        }
        //>
        if (pos[0]+1 < 8){
            if (!board[pos[0]+1][pos[1]].containsAlly(this)) {
                if (!(board[pos[0]+1][pos[1]].bdanger && this.color) && !(board[pos[0]+1][pos[1]].wdanger && !this.color)) {
                    moves[moveCounter] = board[pos[0]+1][pos[1]]; //valid move
                    moveCounter++;
                    if (this.color) {
                        board[pos[0]+1][pos[1]].wdanger=true;
                    }
                    else {
                        board[pos[0]+1][pos[1]].bdanger=true;
                    }
                }
            }
        }
        //>v
        if (pos[0]+1 < 8 && pos[1]-1 > -1){
            if (!board[pos[0]+1][pos[1]-1].containsAlly(this)) {
                if (!(board[pos[0]+1][pos[1]-1].bdanger && this.color) && !(board[pos[0]+1][pos[1]-1].wdanger && !this.color)) {
                    moves[moveCounter] = board[pos[0]+1][pos[1]-1]; //valid move
                    moveCounter++;
                    if (this.color) {
                        board[pos[0]+1][pos[1]-1].wdanger=true;
                    }
                    else {
                        board[pos[0]+1][pos[1]-1].bdanger=true;
                    }
                }
            }
        }
        //v
        if (pos[1]-1 > -1){
            if (!board[pos[0]][pos[1]-1].containsAlly(this)) {
                if (!(board[pos[0]][pos[1]-1].bdanger && this.color) && !(board[pos[0]][pos[1]-1].wdanger && !this.color)) {
                    moves[moveCounter] = board[pos[0]][pos[1]-1]; //valid move
                    moveCounter++;
                    if (this.color) {
                        board[pos[0]][pos[1]-1].wdanger=true;
                    }
                    else {
                        board[pos[0]][pos[1]-1].bdanger=true;
                    }
                }
            }
        }
        //<v
        if (pos[0]-1 > -1 && pos[1]-1 > -1){
            if (!board[pos[0]-1][pos[1]-1].containsAlly(this)) {
                if (!(board[pos[0]-1][pos[1]-1].bdanger && this.color) && !(board[pos[0]-1][pos[1]-1].wdanger && !this.color)) {
                    moves[moveCounter] = board[pos[0]-1][pos[1]-1]; //valid move
                    moveCounter++;
                    if (this.color) {
                        board[pos[0]-1][pos[1]-1].wdanger=true;
                    }
                    else {
                        board[pos[0]-1][pos[1]-1].bdanger=true;
                    }
                }
            }
        }
        //<
        if (pos[0]-1 > -1){
            if (!board[pos[0]-1][pos[1]].containsAlly(this)) {
                if (!(board[pos[0]-1][pos[1]].bdanger && this.color) && !(board[pos[0]-1][pos[1]].wdanger && !this.color)) {
                    moves[moveCounter] = board[pos[0]-1][pos[1]]; //valid move
                    moveCounter++;
                    if (this.color) {
                        board[pos[0]-1][pos[1]].wdanger=true;
                    }
                    else {
                        board[pos[0]-1][pos[1]].bdanger=true;
                    }
                }
            }
        }
        //<^
        if (pos[0]-1 > -1 && pos[1]+1 < 8){
            if (!board[pos[0]-1][pos[1]+1].containsAlly(this)) {
                if (!(board[pos[0]-1][pos[1]+1].bdanger && this.color) && !(board[pos[0]-1][pos[1]+1].wdanger && !this.color)) {
                    moves[moveCounter] = board[pos[0]-1][pos[1]+1]; //valid move
                    moveCounter++;
                    if (this.color) {
                        board[pos[0]-1][pos[1]+1].wdanger=true;
                    }
                    else {
                        board[pos[0]-1][pos[1]+1].bdanger=true;
                    }
                }
            }
        }
        if (moveCounter == 0) {
            if ((this.color && GameBoard.whiteChecked()) || (!this.color && GameBoard.blackChecked())) {
                this.remove(board);
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
                    //notify of attack
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
        //end game
        Game.endGame(this.getColor());
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
    public String getName() {
        return this.name;
    }
}
