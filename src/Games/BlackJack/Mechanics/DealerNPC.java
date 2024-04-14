package Games.BlackJack.Mechanics;
import java.util.ArrayList;
import java.util.List;
//import BlackJackUtil;

public class DealerNPC {
    private List<Card> hand = new ArrayList<>();

    // variables
    int handValue;

    public void play(DeckOfCards deck) {
        boolean shouldHit = true;

        while (shouldHit) {
            handValue = calculateHandValue(hand);
            //int handValue = BlackjackUtil.handValue(hand);
            if (handValue <= 16) {
                hand.add(deck.dealCard());
            } else {
                shouldHit = false;
            }
        }
    }

    public List<Card> getHand() {
        return hand;
    }

    public Card getVisibleCard() {
        if (!hand.isEmpty()) {
            return hand.get(0); 
        }
        return null; 
    }
    // allows the object to recieve a card and add it to the hand
    public void receiveCard(Card card) {
        hand.add(card);
    }
    public void clearHand() {
        hand.clear();
    }

    public int calculateHandValue(List<Card> hand) {
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
    public int calculateDealerInitialCardValue(List<Card> hand) {
        int value = hand.get(0).getFaceValue();
        return value;
    }
}
