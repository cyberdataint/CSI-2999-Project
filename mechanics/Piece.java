package mechanics;

public interface Piece {
    public boolean getColor(); //black or white
    public String getPieceName(); // name of the piece
    public int getId(); //#id of piece (i.e. bishop0, bishop1, pawn0/1/2/3/etc.)
    public int[] getPos();
    public Space[] validMoves(Space[][] board); //returns valid spaces, sets danger variables
    public int[] moveTo(int x, int y, Space[][] board); //returns null or coords of successful move
    public void remove(Space[][] board);
    public String getName(); // return name of piece (e.g. Bishop, Knight)
}

//all pieces must implement this interface.