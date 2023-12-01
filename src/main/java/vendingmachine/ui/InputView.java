package vendingmachine.ui;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.ui.parser.ItemParser;
import vendingmachine.ui.util.Number;

import java.util.List;

public class InputView {

    public String readRetainMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해주세요.");
        String input = Console.readLine();

        return input;
    }

    public List<String[]> readItem() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String input = Console.readLine();

        List<String[]> parsedItems = ItemParser.parseItems(input);
        return parsedItems;
    }

    public Integer readMoney() {
        System.out.println("투입 금액을 입력해주세요.");
        String input = Console.readLine();

        Number number = new Number(input);
        return number.getNumericValue();
    }

    public String readPurchaseItemName() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        String input = Console.readLine();

        return input;
    }


}
