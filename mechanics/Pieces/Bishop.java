package mechanics.Pieces;
import mechanics.Piece;
import mechanics.Space;

public class Bishop implements Piece {
    int[] position;
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

    public int[] moveTo(int dir, int dist, Space[][] board){
        //implement proper method
        //check pos, check adjacent valid spaces for occupants, then the next adjacent valid spaces, etc.
        int[] newPos = this.position;
        if (newPos[0]>7 || newPos[0]<0 || newPos[1]>7 || newPos[1]<0) { //check if it is not a valid space on the board
            return null;
        }
        if (board[newPos[0]][newPos[1]].occupant != null && board[newPos[0]][newPos[1]].occupant.getColor() == this.getColor()){ //check if it is occupied by a teammate
            return null; 
        }
        this.position = newPos;
        return newPos; //when move is valid, return new position
    }

    public void remove(Space[][] board){
        board[this.position[0]][this.position[1]].occupant = null;
    }

}
