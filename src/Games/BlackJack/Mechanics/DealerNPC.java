import java.util.ArrayList;
import java.util.List;

public class DealerNPC {
    private List<Card> hand = new ArrayList<>();

    public void play(DeckOfCards deck) {
        boolean shouldHit = true;

        while (shouldHit) {
            int handValue = BlackjackUtil.handValue(hand);
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
}