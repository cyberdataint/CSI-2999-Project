package BlackJack.Mechanics;

import java.util.ArrayList;
import java.util.List;
import BlackJack.Mechanics.DeckOfCards;

public class PlayerUser {
    private List<Card> hand = new ArrayList<>();
    private String name;

    public PlayerUser(String name) { //set player name if provided
        if (name != null){
            this.name = name;
        }
        else {
            this.name = "Player" + DeckOfCards.playerCount++; //establish playercount in DeckofCards, starts at 1 (dealer is zero),
        }
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public void hit(Card card) { //hit must be called from DeckOfCards
        this.hand.add(card);
    }
    
}
