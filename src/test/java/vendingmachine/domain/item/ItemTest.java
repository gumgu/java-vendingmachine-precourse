package vendingmachine.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ItemTest {

    @ParameterizedTest
    @MethodSource("generateItemDetails")
    @DisplayName("입력받은 정보의 갯수가 3개(상품명, 가격, 수량)가 아닌 경우, 예외를 발생시킨다.")
    void validateItemDetailsCount(String[] inputValue) {
        // when & then
        Assertions.assertThatThrownBy(() -> new Item(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    static Stream<Arguments> generateItemDetails() {
        return Stream.of(
                Arguments.of((Object) new String[] {"콜라", "1500"}),
                Arguments.of((Object) new String[] {"콜라"}),
                Arguments.of((Object) new String[] {"콜라", "1500", "20", "1"}),
                Arguments.of((Object) new String[] {})
        );
    }

}