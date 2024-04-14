package Games.BlackJack.Mechanics;

import java.util.ArrayList;
import java.util.List;
import Games.BlackJack.Mechanics.DeckOfCards;

public class PlayerUser {
    private List<Card> hand = new ArrayList<>();
    

    public int calculateHandValue() {
        int value = 0;
        boolean hasAce = false;
        for (Card card : hand) {
            value += card.getFaceValue();
            if (card.getFaceValue() == 11) {
                hasAce = true;
            }
        }
        if (value > 21 && hasAce) {
            value -= 10;
        }
        return value;
    }

    // allows the object to recieve a card and add it to the hand
    public void receiveCard(Card card) {
        hand.add(card);
    }

    // function to get the hand
    public List<Card> getHand() {
        return hand;
    }
    public void clearHand() {
        hand.clear();
    }
}
