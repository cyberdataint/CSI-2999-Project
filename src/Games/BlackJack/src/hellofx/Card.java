package hellofx;

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

    public int getFaceValue() {
        switch (face) {
            case "Ace":
                return 11;
            case "Two":
                return 2;
            case "Three":
                return 3;
            case "Four":
                return 4;
            case "Five":
                return 5;
            case "Six":
                return 6;
            case "Seven":
                return 7;
            case "Eight":
                return 8;
            case "Nine":
                return 9;
            case "Ten":
            case "Jack":
            case "Queen":
            case "King":
                return 10;
            default:
                return 10;
            

        }
    }
    public String getFace() {
        return this.face;
    }
    
}
