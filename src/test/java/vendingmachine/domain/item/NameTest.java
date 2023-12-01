package vendingmachine.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("중복된 이름을 입력받는 경우 true를 반환한다.")
    @Test
    void isSameName() {
        // given
        String duplicateName = "duplicate";

        // when
        Name name = new Name("duplicate");

        // then
        boolean result = name.isSameName(duplicateName);
        Assertions.assertThat(result).isEqualTo(true);
    }

}