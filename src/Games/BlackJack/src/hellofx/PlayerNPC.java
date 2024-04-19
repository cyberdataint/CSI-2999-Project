package hellofx;

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
            if ((handValue < 17 && dealerVisibleCard.getFaceValue() > 6) || (handValue < 17 && dealerVisibleCard.getFaceValue() == 11)) {
                //shouldHit = basicStrategyWithRandomness(handValue, dealerVisibleCard);
                    hand.add(deck.dealCard());
                
            }
            else if (handValue < 12 && dealerVisibleCard.getFaceValue() <= 6) {
                hand.add(deck.dealCard());
            }
            else if (dealerVisibleCard.getFaceValue() <= 6 && handValue >= 12) {
                shouldHit = false;
            }
            else {
                shouldHit = false; 
        }
    }
}

    private boolean basicStrategyWithRandomness(int handValue, Card dealerVisibleCard) {
        boolean basicDecision = handValue <= 16 || (handValue == 17 && handContainsAce(hand));
        if (random.nextBoolean()) {
            return !basicDecision;
        }
        return basicDecision;
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
