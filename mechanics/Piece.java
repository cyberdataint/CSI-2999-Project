package mechanics;

public interface Piece {
    public boolean getColor(); //black or white
    public int getId(); //#id of piece (i.e. bishop0, bishop1, pawn0/1/2/3/etc.)
    public int[] getPos();
    public Space[] validMoves(Space[][] board); //first dimension value is the relative direction, second is the distance
    public int[] moveTo(int x, int y, Space[][] board); //dist will not matter to kings or knights (or pawns after their initial move)
    public void remove(Space[][] board);
}

//all pieces must implement this interface.
//knight and pawn pieces must update relevant space danger variables upon initialization, other pieces will do so on moveto().