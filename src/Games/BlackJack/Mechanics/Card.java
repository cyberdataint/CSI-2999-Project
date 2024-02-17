public class Card {

    private final String face;  //face of card ("Ace", "Deuce",...)

    private final String suit;  //suit of card ("Hearts", "Diamonds",...)

    // two - argument constructor initializes card's face and suit

    public Card(String cardFace, String cardSuit) {
        this.face = cardFace;
        this.suit = cardSuit;
    }

    // return String representation of Card
    public String toString() {
        return face + " of " + suit;
    }
    
}
