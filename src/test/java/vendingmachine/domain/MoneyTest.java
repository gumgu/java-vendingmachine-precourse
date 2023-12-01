package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.item.Price;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("입력된 금액이 10원으로 나눠지지 않는 경우, 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {123, 555, 101, 12356789, 1111, 0000105})
    void validatePriceMinimumUnit(Integer inputValue){
        // when & then
        assertThatThrownBy(() -> new Money(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 10원으로 나누어져야 합니다.");
    }
}