package Games.BlackJack.Mechanics;
import java.util.List;

public interface Player {
    public List<Card> getHand();
    public String name();
    public void hit(Card card);
    public void clearHand();
}
