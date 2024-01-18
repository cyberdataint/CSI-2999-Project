package mechanics;

public class Space {
    public Piece occupant; //pieces should only be accessed by input handling via occupants of a space
    public boolean wdanger;
    public boolean bdanger;
    public int xcoord;
    public int ycoord;
}
//spaces are only created by the GameBoard. coord variables are set by the GameBoard, other variables are set by Piece initializations