package vendingmachine.domain.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PriceTest {

    @DisplayName("상품 가격이 100원 이하인 경우, 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"99", "0", "1", "-5", "10", "23"})
    void validatePriceMinimalRange(String inputValue){
        // when & then
        assertThatThrownBy(() -> new Price(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("상품 금액이 10원으로 나눠지지 않는 경우, 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "555", "101", "123456789", "1111", "000105"})
    void validatePriceMinimumUnit(String inputValue){
        // when & then
        assertThatThrownBy(() -> new Price(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 상품 가격은 10원으로 나누어져야 합니다.");
    }



}