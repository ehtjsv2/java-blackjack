package blackjack.domain;

import java.util.List;

public abstract class Participant {

    protected final Name name;
    protected final Hands hands;

    protected Participant(String name) {
        this.name = new Name(name);
        this.hands = new Hands();
    }

    protected boolean addCard(Card card) {
        hands.addCard(card);
        if (hands.isBurst()) {
            return hands.downgradeAce();
        }
        return true;
    }

    public List<Card> getHandsCards() {
        return hands.getHands();
    }

    public String getName() {
        return name.getName();
    }

    public int getHandsScore() {
        return hands.getHandsScore();
    }

    public boolean isBurst() {
        return hands.isBurst();
    }
}
