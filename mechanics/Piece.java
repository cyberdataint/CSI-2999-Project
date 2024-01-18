package mechanics;

public interface Piece {
    public Space getPos();
    public Space moveTo();
}

//all pieces must implement this interface.