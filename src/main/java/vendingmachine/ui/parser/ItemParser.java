package vendingmachine.ui.parser;

import java.util.ArrayList;
import java.util.List;

public class ItemParser {

    private static final String DELIMITER_OPEN_BRACKET = "[";
    private static final String DELIMITER_CLOSE_BRACKET = "]";
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_SEMICOLON = ";";

    public static List<String[]> parseItems(String inputValue) {
        List<String[]> parsedItems = new ArrayList<>();
        validateEmpty(inputValue);

        String[] items = splitItem(inputValue);

        for (String item : items) {
            String[] splitItem = parseItem(item);
            parsedItems.add(splitItem);
        }

        return parsedItems;
    }

    private static String[] splitItem(String inputValue) {
        return inputValue.split(DELIMITER_SEMICOLON);
    }

    private static String[] parseItem(String item) {
        validateEmpty(item);
        validateBracketFormat(item);
        item = removeBrackets(item);

        String[] splitItem = splitItemDetail(item);
        return splitItem;
    }

    private static String[] splitItemDetail(String item) {
        return item.split(DELIMITER_COMMA);
    }

    private static String removeBrackets(String item) {
        return item.substring(1, item.length() - 1);
    }

    private static void validateBracketFormat(String item) {
        if (!item.substring(0, 1).equals(DELIMITER_OPEN_BRACKET)
                || !item.substring(item.length() - 1).equals(DELIMITER_CLOSE_BRACKET)) {
            throw new IllegalArgumentException("[ERROR] 입력한 상품 정보가 부적절합니다.");
        }
    }

    private static void validateEmpty(String inputValue) {
        if (inputValue.isEmpty()
                || inputValue == null
                || inputValue.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 공백을 입력할 수 없습니다.");
        }
    }

}
