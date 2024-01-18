package mechanics;

public interface Piece {
    public boolean getColor(); //black or white
    public int getId(); //#id of piece (i.e. bishop0, bishop1, pawn0/1/2/3/etc.)
    public int[] getPos();
    public int[] moveTo(int dir, int dist, Space[][] board); //dist will not matter to kings or knights (or pawns after their initial move)
    public void remove(Space[][] board);
}

//all pieces must implement this interface.
//knight and pawn pieces must update relevant space danger variables upon initialization, other pieces will do so on moveto().