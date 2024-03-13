package blackjack.domain.deck;

import static blackjack.domain.deck.Value.findValue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValueTest {

    @DisplayName("정수값을 바탕으로 순차적으로 Value를 찾을 수 있다")
    @Test
    void should_findValue_When_ExistCardNumber() {
        for (int cardNumber = 1; cardNumber <= 13; cardNumber++) {
            assertThat(Value.values()[cardNumber]).isEqualTo(findValue(cardNumber));
        }
    }

    @DisplayName("존재하지 않는 Value를 조회할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 14})
    void should_ThrowIllegalStateException_When_NonExistCardNumber(int nonExistCardNumber) {
        assertThatThrownBy(() -> findValue(nonExistCardNumber))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("존재하지 않는 카드 번호입니다.");
    }
}
