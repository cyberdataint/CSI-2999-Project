import java.util.ArrayList;
import java.util.List;

public class DealerNPC {
    private List<Card> hand = new ArrayList<>();

    public void play(DeckOfCards deck) {
        boolean shouldHit = true;

        while (shouldHit) {
            int handValue = BlackjackUtil.handValue(hand);
            if (handValue <= 16) {
                Card card = deck.dealCard(); // Assume Dealer can call a method to just get a card
                if (card != null) {
                    hand.add(card);
                }
            } else {
                shouldHit = false;
            }
        }
    }

    // Assuming Dealer should not see first card
    public Card getVisibleCard() {
        if (hand.size() > 1) {
            return hand.get(1);
        }
        return null;
    }

    public void clearHand() {
        hand.clear();
    }
}