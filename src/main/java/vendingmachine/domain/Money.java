package vendingmachine.domain;

import vendingmachine.ui.util.Number;

public class Money {

    private static final Integer MINIMUM_MONEY_DIVISION = 10;

    private Integer money;

    public Money(Integer money) {
        validateMoneyMinimumUnit(money);
        this.money = money;
    }

    public void reduceMoney(Integer price) {
        money -= price;
    }

    private void validateMoneyMinimumUnit(Integer price) {
        if (price % MINIMUM_MONEY_DIVISION != 0 ) {
            throw new IllegalArgumentException("[ERROR] 금액은 10원으로 나누어져야 합니다.");
        }
    }

    public Integer getMoney() {
        return money;
    }

}
