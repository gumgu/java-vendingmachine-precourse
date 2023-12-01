package vendingmachine.domain.item;

import vendingmachine.ui.util.Number;

public class Quantity {

    private static final Integer MINIMUM_QUANTITY = 1;

    private Integer quantity;

    public Quantity(String inputValue) {
        Integer quantity = getIntegerQuantity(inputValue);
        validateQuantityMinimalRange(quantity);

        this.quantity = quantity;
    }

    public void minusQuantity() {
        quantity--;
    }

    public boolean hasStock() {
        return quantity > 0;
    }

    private Integer getIntegerQuantity(String inputQuantity) {
        Number number = new Number(inputQuantity);
        return number.getNumericValue();
    }

    private void validateQuantityMinimalRange(Integer quantity) {
        if (quantity < MINIMUM_QUANTITY) {
            throw new IllegalArgumentException("[ERROR] 상품 수량은 1개 이상이어야 합니다.");
        }
    }

}
