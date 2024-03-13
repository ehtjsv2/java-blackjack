package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.deck.Deck;
import blackjack.domain.participant.BetMoney;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import blackjack.domain.participant.Players;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("딜러와 플레이어는 초기패로 2장의 카드를 받는다")
    @Test
    void should_getTwoCards_To_InitialHands() {
        Deck deck = Deck.createShuffledDeck();
        Players players = new Players(List.of(new Player("pobi", new BetMoney(1))));
        Dealer dealer = new Dealer();

        Game game = Game.of(deck, dealer, players);

        assertThat(dealer.getHandsCards()).hasSize(2);
        assertThat(players.getPlayers().get(0).getHandsCards()).hasSize(2);
    }
}
