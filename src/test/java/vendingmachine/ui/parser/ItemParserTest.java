package vendingmachine.ui.parser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

class ItemParserTest {
    @ParameterizedTest
    @DisplayName("각 아이템들이 대괄호 안에 있지 않는 경우, 예외를 발생시킨다.")
    @ValueSource(strings = {"콜라,1500,20", "[사이다,1000,10", "환타,500,20]", ""})
    void validateBracketFormat(String inputValue) {
        // given
        ItemParser itemParser = new ItemParser();

        // when & then
        Assertions.assertThatThrownBy(() -> itemParser.parseItems(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("입력받은 상품을 각 아이템의 정보를 담은 List로 반환한다.")
    @ValueSource(strings = {"[콜라,1500,20];[사이다,1000,10]"})
    void parseItems(String inputValue) {
        // given
        ItemParser itemParser = new ItemParser();

        // when
        List<String[]> parsedItems = itemParser.parseItems(inputValue);

        // then
        List<String[]> expectItems = new ArrayList<>();
        expectItems.add(new String[]{"콜라", "1500", "20"});
        expectItems.add(new String[]{"사이다", "1000", "10"});

        Assertions.assertThat(parsedItems)
                .usingRecursiveComparison()
                .isEqualTo(expectItems);
    }
}