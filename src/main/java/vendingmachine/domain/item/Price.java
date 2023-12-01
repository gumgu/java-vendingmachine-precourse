package vendingmachine.domain.item;

import vendingmachine.ui.util.Number;

public class Price {

    private static final Integer MINIMUM_PRICE = 100;
    private static final Integer MINIMUM_PRICE_DIVISION = 10;

    private final Integer price;

    public Price(String inputValue) {
        Integer price = getIntegerPrice(inputValue);
        validatePriceMinimalRange(price);
        validatePriceMinimumUnit(price);

        this.price = price;
    }

    public boolean isPurchaseAffordable(Integer money) {
        return price <= money;
    }

    private Integer getIntegerPrice(String inputPrice) {
        Number number = new Number(inputPrice);
        return number.getNumericValue();
    }

    private void validatePriceMinimalRange(Integer price) {
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100원 이상이어야 합니다.");
        }
    }

    private void validatePriceMinimumUnit(Integer price) {
        if (price % MINIMUM_PRICE_DIVISION != 0 ) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 10원으로 나누어져야 합니다.");
        }
    }

    public Integer getPrice() {
        return price;
    }
}
