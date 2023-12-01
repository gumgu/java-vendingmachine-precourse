package vendingmachine.domain.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QuantityTest {

    @DisplayName("상품의 수량이 1 미만인 경우, 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-5"})
    void validateQuantityMinimalRange(String inputValue) {
        // when & then
        assertThatThrownBy(() -> new Quantity(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}