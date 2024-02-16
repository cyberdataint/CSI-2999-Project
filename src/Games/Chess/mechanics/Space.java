package mechanics;

public class Space {
    public Piece occupant; //pieces should only be accessed by input handling via occupants of a space
    public boolean wdanger;
    public boolean bdanger;
    public int xcoord;
    public int ycoord;

    public boolean containsAlly(Piece piece) {
        if (this.occupant != null) {
            return (piece.getColor() == this.occupant.getColor());
        }
        return false;
    }

    public boolean containsEnemy(Piece piece) {
        if (this.occupant != null) {
            return (piece.getColor() != this.occupant.getColor());
        }
        return false;
    }

    // public boolean isEqual(Space space) {
    //     return this.xcoord == space.xcoord && this.ycoord == space.ycoord;
    // }
}
//spaces are only created by the GameBoard. coord variables are set by the GameBoard, other variables are set by Piece initializations