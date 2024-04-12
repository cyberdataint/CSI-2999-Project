import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PlayerNPC {
    private List<Card> hand = new ArrayList<>();
    private SecureRandom random = new SecureRandom();

    public void play(DeckOfCards deck, Card dealerVisibleCard) {
        boolean shouldHit = true;

        while (shouldHit) {
            int handValue = calculateHandValue(hand);
            if (handValue < 17) {
                shouldHit = basicStrategyWithRandomness(handValue, dealerVisibleCard);
                if (shouldHit) {
                    hand.add(deck.dealCard());
                }
            } else {
                shouldHit = false; 
        }
    }

    private boolean basicStrategyWithRandomness(int handValue, Card dealerVisibleCard) {
        boolean basicDecision = handValue <= 16 || (handValue == 17 && handContainsAce(hand));
        if (random.nextBoolean()) {
            return !basicDecision;
        }
        return basicDecision;
    }

    private int calculateHandValue(List<Card> hand) {
        int value = 0;
        for (Card card : hand) {
            value += card.getFaceValue();
        }
        return value;
    }

    private boolean handContainsAce(List<Card> hand) {
        return hand.stream().anyMatch(card -> card.getFace().equals("Ace"));
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