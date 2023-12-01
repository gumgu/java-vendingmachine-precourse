package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.coin.CoinMaker;

class CoinMakerTest {

    @DisplayName("10원보다 작은 보유 금액을 입력한 경우, 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "9", "-2", "0"})
    void validateRetainMoneyMinimum(String retainMoney) {
        // when & then
        Assertions.assertThatThrownBy(() -> new CoinMaker(retainMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


}