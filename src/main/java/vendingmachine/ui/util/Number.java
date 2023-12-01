package vendingmachine.ui.util;

public class Number {

    private static final String ERROR_MESSAGE_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    private static final Integer MAX_NUMBER_DIGITS = 9;

    private final Integer numericValue;

    public Number(String inputValue) {
        validateEmpty(inputValue);
        validateDigit(inputValue);
        validateLength(inputValue);

        Integer numericValue = convertToInteger(inputValue);
        this.numericValue = numericValue;
    }

    private Integer convertToInteger(String inputValue) {
        return Integer.parseInt(inputValue);
    }

    public void validateEmpty(String inputValue) {
        if (isBlank(inputValue)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER);
        }
    }

    private void validateDigit(String inputValue) {
        if (!isNumber(inputValue)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER);
        }
    }

    private void validateLength(String inputValue) {
        if (!isNumberWithinNineDigits(inputValue)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER);
        }
    }

    private boolean isBlank(String inputValue) {
        return inputValue == null || inputValue.isEmpty();
    }

    private boolean isNumberWithinNineDigits(String inputValue) {
        return isNumber(inputValue) && inputValue.length() <= MAX_NUMBER_DIGITS;
    }

    private boolean isNumber(String inputValue) {
        return inputValue.chars().allMatch(Character::isDigit);
    }

    public Integer getNumericValue() {
        return numericValue;
    }
}
